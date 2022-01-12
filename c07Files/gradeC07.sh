#! /bin/bash
#
#  Last modified:  November 1, 2021
#
#  This script must be executed in a directory that contains the grading harness
#  tar file (c07Grader.tar) posted on the course website; that tar file must
#  contain the files:
#
#    c07driver.c
#    Untangle.h
#    Generator.h
#    Generator.o
#    checkAnswer.h
#    checkAnswer.o
#
#  The directory must also contain your completed Untangle.c file; we recommend
#  that you name that file yourPID.c, using your VT email PID as the first part
#  of the file name (e.g., wmcquain.c).
#
#  Invocation:  ./gradeC07.sh <name of your .c file>
#               e.g., ./gradeC07.sh wmcquain.c
#
#  Various text files are created, and contain portions of the test results.
#  Overall results can be found in a file named PID.txt, if you followed the 
#  suggested naming convention for your C source file.
#
#  Alternate invocation:  ./gradeC07.sh -clean
#
#  This will remove the files created by an earlier run of the grading script;
#  it's useful if you just want to start with a pristine environment.
#
#  Name of grading package file:
gradingTar="c07Grader.tar"

#  Rename for student file; student's source file is copied to the build 
#  directory and renamed as follows:
renameC="Untangle.c"

#  Names for directories
buildDir="build"

#   Names for log files created by this script:
headerLog="header.txt"            # boilerplate and timestamp for test
buildLog="buildLog.txt"           # messages related to build process
testLog="testLog.txt"             #
vgrindLog="vgrindLog.txt"         # verbose Valgrind output
vgrindIssues="vgrind_issues.txt"  # summary of errors reported by Valgrind

#   Name for the executable
exeName="driver"

#   Names for driver output log and memory region file
driverLog="c07Log.txt"
driverBin="Data.bin"

#  Names for driver-generated test results file
scoreFile="c07scores.txt"

#   Build command:
buildCMD="gcc -o $exeName -std=c11 -Wall -ggdb3 c07driver.c $renameC Generator.o checkAnswer.o"

#   Delimiter to separate sections of report file:
Separator="============================================================"

############################################# fn to check for tar file
#                 param1:  name of file to be checked
isTar() {

   mimeType=`file -b --mime-type $1`
   if [[ $mimeType == "application/x-tar" ]]; then
     return 0
   fi
   if [[ $mimeType == "application/x-gzip" ]]; then
     return 0
   fi
   return 1
}

##################################### fn to extract token from file name
#                 param1: (possibly fully-qualified) name of file
#  Note:  in production use, the first part of the file name will be the
#         student's PID
#
getPID() { 

   fname=$1
   # strip off any leading path info
   fname=${fname##*/}
   # extract first token of file name
   sPID=${fname%%.*}
}
   
############################################################ Validate command line

# Verify number of parameters
   if [[ $# -ne 1 ]]; then
      echo "You must specify the name of your C source file (or -clean)."
      exit 1
   fi
   
# See if user selected the cleaning option
  if [[ $1 == "-clean" ]]; then
     echo "Removing earlier test files..."
     rm -Rf *.txt *.bin $buildDir $exeName
     exit 0
  fi

# Verify presence of named file
   sourceFile="$1"
   if [ ! -e $sourceFile ]; then
      echo "The file $sourceFile does not exist."
      exit 2
   fi
   
############################################################ Check for grading package

   if [[ ! -e $gradingTar ]]; then
      echo "$gradingTar is not present"
      exit 3
   fi
   
   isTar $gradingTar
   if [[ $? -ne 0 ]]; then
      echo "$gradingTar does not appear to be a tar file"
      exit 4
   fi

############################################################ Get student's PID
   
   # Extract first token of C file name (student PID when we run this)
   getPID $sourceFile
   
   # Initiate header for grading log
   echo "Grading:  $1" > $headerLog
   echo -n "Time:     " >> $headerLog
   echo `date` >> $headerLog
   echo >> $headerLog
   
############################################################ Prepare for build
  
   # Create log file:
   echo "Executing gradeC07.sh..." > $buildLog
   echo >> $buildLog
   
   # Create build directory:
   echo "Creating build subdirectory" >> $buildLog
   echo >> $buildLog
   # Create build directory if needed; empty it if it already exists
   if [[ -d $buildDir ]]; then
      rm -Rf ./$buildDir/*
   else
      mkdir $buildDir
   fi
   
   # Copy student's C file to the build directory
   echo "Copying student source file to the build directory:" >> $buildLog
   cp $sourceFile ./$buildDir/$renameC >> $buildLog
   echo >> $buildLog
   
   # Unpack the test source files into the build directory
   echo "Unpacking test code into build directory:" >> $buildLog
   tar xf $gradingTar -C ./$buildDir >> $buildLog

   # Move to build directory
   cd ./$buildDir
   
############################################################ Build the test driver

   # build the driver; save output in build log
   echo "Compiling test code and submission" >> ../$buildLog
   $buildCMD >> ../$buildLog 2>&1
   echo >> ../$buildLog

   # Verify existence of executable
   if [[ ! -e $exeName ]]; then
      echo "Build failed; the file $exeName does not exist" >> ../$buildLog
      echo $Separator >> ../$buildLog
      mv ../$buildLog ../$sPID.txt
      exit 7
   fi
   if [[ ! -x $exeName ]]; then
      echo "Permissions error; the file $exeName is not executable" >> ../$buildLog
      echo $Separator >> ../$buildLog
      mv ../$buildLog ../$sPID.txt
      exit 8
   fi

   echo "Build succeeded..." >> ../$buildLog
   
   # Move executable up to test directory and return there
   echo "Moving the executable $exeName to the test directory." >> ../$buildLog
   mv ./$exeName ..
   cd ..

############################################################ Perform testing

   # Test first with -clear
   echo "Preparing to execute student solution with -clear..." > $testLog
   killed="no"
   timeout 30 ./driver -clear >> $testLog 2>&1
   timeoutStatus="$?"
   # echo "timeout said: $timeoutStatus"
   if [[ $timeoutStatus -eq 124 || $timeoutStatus -eq 137 ]]; then
      echo "The test of your solution timed out after 30 seconds." >> $testLog
   elif [[ $timeoutStatus -eq 134 ]]; then
      echo "The test of your solution was killed by a SIGABRT signal." >> $testLog
      echo "Possible reasons include:" >> $testLog
      echo "    - a segfault error" >> $testLog
      echo "    - a serious memory access error" >> $testLog
   fi
  
   # Rename log file and data file from this test:
   if [[ -s $driverLog ]]; then
      mv $driverLog "clearLog.txt"
   else
      echo "$driverLog was not created!"
      exit 9
   fi
   if [[ -s $driverBin ]]; then
      mv $driverBin "clearData.bin"
   else
      echo "$driverBin was not created!"
      exit 9
   fi

   # Test second with -encrypted
   echo "Preparing to execute student solution with -encrypt..." >> $testLog
   timeout 30 ./driver -encrypt >> $testLog 2>&1
   if [[ $? -eq 124 ]]; then
      echo "Testing your solution took more than 30 seconds, and was killed." >> $testLog
   fi
   
   # Rename log file and data file from this test:
   if [[ -s $driverLog ]]; then
      mv $driverLog "encryptLog.txt"
   else
      echo "$driverLog was not created!"
      exit 9
   fi
   if [[ -s $driverBin ]]; then
      mv $driverBin "encryptData.bin"
   else
      echo "$driverBin was not created!"
      exit 9
   fi
   
############################################################ Run Valgrind check

   #   full valgrind output is in $vgrindLog
   #   extracted counts are in $vgrindIssues
   echo "Running valgrind test..." >> $vgrindLog
   vgrindSwitches=" --leak-check=full --show-leak-kinds=all --log-file=$vgrindLog --track-origins=yes -v"
   timeout 30 valgrind $vgrindSwitches ./driver -clear >> $vgrindLog 2>&1
   if [[ -s $tmpVgrind ]]; then
      cat $tmpVgrind >> $vgrindLog
   fi
   
   # accumulate valgrind error counts
   if [[ -e $vgrindLog ]]; then
      echo "Valgrind issues:" > $vgrindIssues
      grep "in use at exit" $vgrindLog >> $vgrindIssues
      grep "total heap usage" $vgrindLog >> $vgrindIssues
      grep "definitely lost" $vgrindLog >> $vgrindIssues
      echo "Invalid reads: `grep -c "Invalid read" $vgrindLog`" >> $vgrindIssues
      echo "Invalid writes: `grep -c "Invalid write" $vgrindLog`" >> $vgrindIssues
      echo "Uses of uninitialized values: `grep -c "uninitialised" $vgrindLog`" >> $vgrindIssues
   else
      echo "Error running Valgrind test." >> $testLog
   fi
   
   # log test data/results for valgrind check
   echo >> $vgrindLog
   echo "Test data used with valgrind:" >> $vgrindLog
   echo >> $vgrindLog
   if [[ -s $driverLog ]]; then
      cat $driverLog >> $vgrindLog
   else
      echo "$driverLog was not created!"
   fi
   echo >> $vgrindLog
   if [[ -s $driverBin ]]; then
      hexdump -C $driverBin >> $vgrindLog
   else
      echo "$driverBin was not created!"
   fi
   
############################################################ File report
# complete summary file

   summaryLog="$sPID.txt"
   
   # write header to summary log
   cat "$headerLog" > $summaryLog
   echo $Separator >> $summaryLog
   
   # write score summary to log
   echo ">>Scores from testing<<" >> $summaryLog
   echo -n "  1 >> " >> $summaryLog
   grep "Score" "clearLog.txt" >> $summaryLog
   echo -n "  2 >> " >> $summaryLog
   grep "Score" "encryptLog.txt" >> $summaryLog
   echo >> $summaryLog
   echo "The first score is from the test with clear text." >> $summaryLog
   echo "The second score is from the test with encrypted text." >> $summaryLog
   echo "Your score is a weighted average of these two scores," >> $summaryLog
   echo "using the weights from the project specification." >> $summaryLog
   echo $Separator >> $summaryLog
   
   if [[ -s $vgrindIssues ]]; then
	   # write Valgrind summary into log
	   echo "Summary of valgrind results:" >> $summaryLog
	   echo >> $summaryLog
	   cat $vgrindIssues >> $summaryLog
	   echo $Separator >> $summaryLog
	else
	   echo "Valgrind summary log was not created." >> $summaryLog
   fi
   
   # write test info for -clear to summary log
   echo "Information about testing with -clear:" >> $summaryLog
   echo >> $summaryLog
   cat "clearLog.txt" >> $summaryLog
   echo >> $summaryLog
   hexdump -C "clearData.bin" >> $summaryLog   
   echo >> $summaryLog
   echo $Separator >> $summaryLog
   
   # write test info for -encrypt to summary log
   echo "Information about testing with -encrypt:" >> $summaryLog
   echo >> $summaryLog
   cat "encryptLog.txt" >> $summaryLog
   echo >> $summaryLog
   hexdump -C "encryptData.bin" >> $summaryLog   
   echo >> $summaryLog
   echo $Separator >> $summaryLog
   
   if [[ -s $vgrindLog ]]; then
	   # write Valgrind details into log
	   echo "Details from valgrind check:" >> $summaryLog
	   echo >> $summaryLog
	   cat $vgrindLog >> $summaryLog
	   echo $Separator >> $summaryLog
	else
	   echo "Valgrind details log was not created." >> $summaryLog
   fi
   
   # write build log into summary
   echo "Results from $buildLog" >> $summaryLog
   cat $buildLog >> $summaryLog
   echo >> $summaryLog

exit 0

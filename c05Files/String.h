#ifndef STRING_H
#define STRING_H
#include <stdbool.h>
#include <inttypes.h>

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

// REMINDER: You may not use ANY of the Standard C string functions for this
//           assignment.  Do not #incude <string.h> in String.c!

/**  A C-language implementation of a character string type.
 * 
 *   Characters are stored in zero-terminated char arrays, sized precisely
 *   for the logical length of the string (so no wasted memory).
 * 
 *   A String object S is said to be proper if:
 *     - S.pData points to an array of dimension S.length + 1 and S.pData[length] = '\0'
 *     - if S.length > 0, S.pData[0:S.length - 1] hold the characters that make up the string
 * 
 *   A String object S is said to be raw if:
 *     - S.pData may or may not be NULL
 *     - S.length has no significant value 
 */

struct _String {

   char     *pData;    // dynamically-allocated array to hold the characters
   uint32_t  length;   // number of characters in the string
};
typedef struct _String String;


/** The String is initialized to hold the values in *src.
 *
 *  Pre:
 *    *pSrc is C string with length up to slength (excludes null char)
 *  Post on success:
 *    A new, proper String object S is created such that:
 *       S.pData != pSrc->pData
 *       Up to slength characters in *pSrc are copied into pDest->pData
 *         (after dynamic allocation) and the new string is terminated
 *         with a '\0'
 *       S.length is set to the number of characters copied from *pSrc;
 *         this is no more than slength, but will be less if a '\0' is
 *         encountered in *pSrc before slength chars have occurred
 * Post on failure:
 *    NULL is returned
 * 
 * Returns:
 *    pointer to the new String object;
 *    NULL value if some error occurs
 */
String* String_Create(const char* const pSrc, uint32_t slength);


/** Appends the String *pSrc to the String *pDest.
 * 
 *  Pre:
 *    *pDest is a proper String object
 *    *pSrc is is a proper String object
 *    pSrc != pDest (i.e., the source and destination are different String objects)
 *  Post on success:
 *    pSrc->pData is appended to the String pDest->data
 *    *pDest is a proper String object  
 *  Post on failure:
 *    *pDest is unchanged
 * 
 *  Returns:
 *    the length of pDest->pData, if nothing goes wrong;
 *    a negative value, if some error occurs
 */
int32_t String_Cat(String* const pDest, const String* const pSrc);


/** Compares two Strings.
 * 
 *  Pre:
 *    *pLeft is a proper String object
 *    *pRight is is a proper String object
 *
 *  Returns:
 *    < 0 if *pLeft precedes *pRight, lexically
 *      0 if *pLeft equals *pRight
 *    > 0 if *pLeft follows *pRight, lexically
 */
int32_t String_Compare(const String* const pLeft, const String* const pRight);


/** Makes an exact, full copy of a substring.
 * 
 * Pre:
 *   *pSrc is a proper String object
 *   startIdx + length <= pSrc->length
 * Post:
 *    no memory leaks have occurred
 *	  A new, proper string object S has been created such that S holds
 *      the specified substring of *pSrc
 *
 * Returns:
 *	  pointer to a String object which holds a copy of specified substring;
 *    NULL if failure occurs
 */
String* String_subString(const String* const pSrc, uint32_t start, uint32_t length);


/** Erases a specified sequence of characters from a String.
 * 
 * Pre:
 *   *pSrc is a proper String object
 *   startIdx + length <= src->length
 * Post:
 *    no memory leaks have occurred
 *    the specified range of characters have been removed
 *	  *pSrc is proper
 *
 * Returns:
 *	  if successful, pSrc
 *    NULL if failure occurs
 */
String* String_Erase(String* const pSrc, uint32_t start, uint32_t length);


/**  Deallocates a String object and all its content.
 * 
 *   Pre:
 *     *ppStr is a pointer to a proper String object, so
 *     **ppStr is a proper String object
 *     **ppStr was allocated dynamically
 *   Post:
 *     (**ppStr).data has been deallocated
 *     **ppStr has been deallocated
 *     *ppStr == NULL
 */
void String_Dispose(String** ppStr);

#endif

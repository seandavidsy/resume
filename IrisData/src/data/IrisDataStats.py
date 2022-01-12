'''
https://machinelearningmastery.com/machine-learning-in-python-step-by-step/
Loads a dataset with assosciated attribute names, then reports on details
of the dataset including statistics and graphs
'''

# Load libraries
import pandas
from pandas.plotting import scatter_matrix
import matplotlib.pyplot as plt 

# Load dataset
file = "iris.csv"
names = ['sepal-length', 'sepal-width', 'petal-length', 'petal-width', 'class']
# load data from the csv file with columns labeled by names into a DataFrame called dataset
dataset = pandas.read_csv(file, names=names)

# shape
# print the dimensions of the dataset
print("The file " + file + " has data with dimensions: " + str(dataset.shape))

# head
# print the first 20 lines of the dataset
print("The first 20 lines of the file " + file + ":")
print(dataset.head(20))

# descriptions
# print descriptive statistics of the dataset
print("Data statistics of " + file + " file:")
print(dataset.describe())

# class distribution
# print the number of elements in each class of the dataset
print ("Number of elements in each class of " + file + " file:")
print(dataset.groupby('class').size())

# box and whisker plots
# creates a box and whisker plots of the dataset
dataset.plot(kind='box', subplots=True, layout=(2,2), sharex=False, sharey=False)
plt.show()

# histograms
# creates a histogram of the dataset
dataset.hist()
plt.show()

# scatter plot matrix
# creates a scatter plot of the dataset
scatter_matrix(dataset)
plt.show()


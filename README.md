# Machine Learning Model - CA using Naive Bayes
2nd Year Java Project for Object Oriented Programming Module

# Brief Explantion of How it Works

## Testing & Training Data
1. When the program is first run the FileProcessor class gets called.
2. Inside this class, the ProcessEntry class gets called.
3. After the dataset has been trained, the Query class is used on the remaining entries.
4. Each time a Query is created it gets passed to the ProcessQuery class to check accuracy.

## GUI & Query Creation
5. Once the dataset has been trained and tested the GUI will show.
6. On pressing the submit button a Query object will be created using the provided data.
7. This Query will be passed to the ProcessQuery class where it'll provide an outcome.

# List of Classes
Class Name | Function | Input | Output
--- | --- | --- | ---
Control | Main function which calls to classes in desired order. | None | None
FileProcessor | <ul><li>Opens given file, iterates through contents to find a valid entry.</li><li>Each valid entry found will be forwarded onto the ProcessEntry class.</li><li>After a given % of entries has been trained, the rest will instead be converted to a Query object before being sent to the ProcessQuery class.</li><li>The result from the ProcessQuery instance will be compared to the 6th feature in the entry from the dataset in order to generate an accuracy for the model.</li></ul>| <ul><li>fileName</li><li>trainSize **(% amount of the entries to train)** </li></ul> | Displays info about amount trained, tested and the accuracy from the tests.
ProcessEntry | <ul><li>Given entry from FileProcessor in string format.</li><li>Entry is converted into an ArrayList.</li><li>This ArrayList is iterated through and all the ArrayList and variables that store all the desired data get populated.</li></ul> | entry | Provides the populated ArrayLists to the ProcessQuery class when needed.
Query | <ul><li>Query object that user can create using the GUI.</li><li>Gets passed to ProcessQuery which will determine whether they will become a future entrepreneur or not based on the dataset.</li></ul> | <ul><li>gender</li><li>parentBusiness</li><li>ptJob</li><li>urban</li><li>businessStudent</li></ul> | Displays the values of each instance when printed.
ProcessQuery | <ul><li>The bayes formula is used inside this class.</li><li>The class grabs the pre-populated ArrayLists from the ProcessEntry class and uses these in order to generate a result.</li></ul> | query | *'yes'* or *'no'* **whether they'll become future entrepreneur or not**
GUI | Provide a friendly UI for user to create Query objects and pass them onto ProcessQuery class in order to find a result whether they'll become a future entrepreneur or not based on the given dataset. | **User Input** | None

## Overview of Functionality
![alt text](https://github.com/SeanHampson/MLM-CA/blob/main/images/Overview.png "Program Overview")

## Optional Functionality
The GUI was an optional part which I chose to do as it makes it easier to work with the model and test it out. I could've gone with the standard java console but I thought the GUI would be a neat feature.

### When program starts up this is how the GUI will look initially.
![alt text](https://github.com/SeanHampson/MLM-CA/blob/main/images/default-gui.png "Default GUI")

### After the user selects an input such as the following and clicks 'SUBMIT' it will look like this.
![alt text](https://github.com/SeanHampson/MLM-CA/blob/main/images/selection-gui.png "Selection GUI")

## IF I Had More Time I Would've
1. Re-written the whole program using an updated structure.
2. Added an Entry object and inherited the Query object from it.
3. Added an option on the GUI to add a new entry to the dataset.
4. Added an option to specify train/test sizes.
5. Added an option in GUI to view accuracy of model.

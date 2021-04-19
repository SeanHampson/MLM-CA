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
Class Name |  Function
--- | --- 
Control | Main function which calls to classes in desired order.
FileProcessor | Opens given file, iterates through contents to find a valid entry. Each entry found will be forwarded onto the ProcessEntry class. After a given % of entries has been trained, the rest will instead be converted to a Query object before being sent to the ProcessQuery class. The result from the ProcessQuery instance will be compared to the 6th feature in the entry from the dataset in order to generate an accuracy for the model. 
ProcessEntry | ...
Query | ...
ProcessQuery | ...
GUI | ...


![alt text](https://github.com/SeanHampson/MLM-CA/blob/main/images/default-gui.png "Default GUI")
![alt text](https://github.com/SeanHampson/MLM-CA/blob/main/images/selection-gui.png "Selection GUI")

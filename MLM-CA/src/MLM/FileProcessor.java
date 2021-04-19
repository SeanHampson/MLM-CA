package MLM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileProcessor
{	
	private ProcessEntry e1;
	private Scanner scanner;
	private File file;
	private static int numEntries=0;
	private String entry;
	private boolean validEntry;
	private static double trainingSize=1.0;
	private static int trainAmount, testAmount;
	
	public FileProcessor(String fileName, double trainSize) throws FileNotFoundException
	{
		setTrainingSize(trainSize);
		file = new File(fileName);
		open(file);
	}
	
	public FileProcessor(String fileName) throws FileNotFoundException
	{
		file = new File(fileName);
		open(file);
	}
	
	private void open(File fileName) throws FileNotFoundException
	{
		setNumEntries(0);
		// Counts current entry index
		int counter = 0, totalTested=0, correct=0;
		String gender="", result;
		// Query Parameters
		boolean parentBusiness=false, ptJob=false, urban=false, businessStudent=false;
		ArrayList<String> entryArray;
		
		for(int i = 0; i < 2; i++)
		{
			// Reset counter
			counter = 0;
			
			scanner = new Scanner(fileName);
			scanner.useDelimiter("\n");
			
			while(scanner.hasNext())
			{
				// Scan and store next line in variable entry
				entry = scanner.next();
				
				// Remove whitespace
				entry = entry.replaceAll("\\s", "");
				entry = entry.toLowerCase();
				
				// If the line from data begins with Male or Female it is a valid entry
				setValidEntry(entry.startsWith("male") || entry.startsWith("female"));
				
				// Checks if next line is a valid entry
				if(getValidEntry())
				{
					counter++;
					if(i == 0)
					{
						// Increments the number of entries in data by 1
						setNumEntries(numEntries + 1);
						// Sets training size based on number of entries
						setTrainAmount( (int) Math.round( (double) getNumEntries() * getTrainingSize() ) );
					}
					else if( i == 1 && counter <= getTrainAmount() )
					{
						// Processes this entry
						setProcessEntry(entry);
					}
					else if( i == 1 && counter > getTrainAmount() )
					{
						// Splits entry into an array
						entryArray = new ArrayList<String>(Arrays.asList(entry.split(",")));

						// Convert Stripped Entry -> Query Instance & Pass to ProcessQuery
						if(entry.toLowerCase().startsWith("male")) gender = "male";
						if(entry.toLowerCase().startsWith("female")) gender = "female";
						if(entryArray.get(1).toLowerCase().equals("yes")) parentBusiness = true;
						if(entryArray.get(2).toLowerCase().equals("yes")) ptJob = true;
						if(entryArray.get(3).toLowerCase().equals("yes")) urban = true;
						if(entryArray.get(4).toLowerCase().equals("yes")) businessStudent = true;
						
						if(entryArray.get(1).toLowerCase().equals("no")) parentBusiness = false;
						if(entryArray.get(2).toLowerCase().equals("no")) ptJob = false;
						if(entryArray.get(3).toLowerCase().equals("no")) urban = false;
						if(entryArray.get(4).toLowerCase().equals("no")) businessStudent = false;
						
						// Query object with Entry Data
						Query q1 = new Query(gender,parentBusiness,ptJob,urban,businessStudent);
						
						// Pass query to process query
						ProcessQuery p1 = new ProcessQuery(q1);
						
						// Retrieve result and compare to entry data
						result = p1.getProb();
						
						// Total number tested is now incremented by 1
						totalTested++;
						
						// Store data
						if(entryArray.get(5).equals(result))
						{
							correct++;
							// Debugging
							//System.out.println("(" + q1 + ") Entry: " + entryArray.get(5) + " vs. " + result + " | Result [" +counter+ "] **** [" + correct + "]");
						}
						else
						{
							// Debugging
							//System.out.println("(" + q1 + ") Entry: " + entryArray.get(5) + " vs. " + result + " | Result [" +counter+ "]");
						}
					}
				}
			}
			setTestAmount( getNumEntries() - getTrainAmount() );
		}
		
		System.out.println("Train Amount: " + getTrainAmount() + "\nTest Amount: " + getTestAmount() );
		System.out.println("\nTested: " + totalTested + "\nTotal Correct: " + correct + "\nAccuracy: " + (double) (correct * 100) / totalTested);
	}
	
	public String toString()
	{
		String summary = "Number of entries in given file: " + getNumEntries()
		+"\nTraining Size: " + getTrainingSize();
		
		return summary;
	}
	
	public static int getTestAmount() {
		return testAmount;
	}

	public static void setTestAmount(int testAmount) {
		FileProcessor.testAmount = testAmount;
	}

	public static int getTrainAmount() {
		return trainAmount;
	}

	public static void setTrainAmount(int trainAmount) {
		FileProcessor.trainAmount = trainAmount;
	}

	private void setTrainingSize(double trainSize) 
	{
		if(trainSize <= 1 && trainSize >= 0.1)
		{
			trainingSize = trainSize;
		}
	}
	
	private double getTrainingSize()
	{
		return trainingSize;
	}
	
	private void setValidEntry(boolean bool)
	{
		validEntry = bool;
	}
	
	private boolean getValidEntry()
	{
		return validEntry;
	}
	
	private void setNumEntries(int num)
	{
		numEntries = num;
	}
	
	public static int getNumEntries()
	{
		return numEntries;
	}
	
	private void setProcessEntry(String entry) {
		e1 = new ProcessEntry(entry);
	}
	
	public void getProcessEntry() {
		System.out.println(e1);
	}
}
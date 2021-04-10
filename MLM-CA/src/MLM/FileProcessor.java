package MLM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor
{	
	private ProcessEntry e1;
	private Scanner scanner;
	private File file;
	private static int numEntries=0;
	private String entry;
	private boolean validEntry;
	
	public FileProcessor(String fileName) throws FileNotFoundException
	{
		setFile(fileName);
		open(file);
	}
	
	public void open(File fileName) throws FileNotFoundException
	{
		setNumEntries(0);
		
		setScanner(file);
		scanner.useDelimiter("\n");
		
		while(scanner.hasNext())
		{
			// Scan and store next line in variable entry
			entry = scanner.next();
			
			// Remove whitespace
			entry = entry.replaceAll("\\s",  "");
			entry = entry.toLowerCase();
			
			// If the line from data begins with Male or Female it is a valid entry
			setValidEntry(entry.startsWith("male") || entry.startsWith("female"));
			
			// Checks if next line is a valid entry
			if(getValidEntry())
			{
				// Increments the number of entries in data by 1
				setNumEntries(numEntries + 1);
				// Processes this entry
				setProcessEntry(entry);
			}
		}
		
		getProcessEntry();
		scanner.close();
	}
	
	public String toString()
	{
		String summary = "Number of entries in given file: " + getNumEntries();
		
		return summary;
	}
	
	public void setFile(String fileName)
	{
		file = new File(fileName);
	}
	
	public void setValidEntry(boolean bool)
	{
		validEntry = bool;
	}
	
	public boolean getValidEntry()
	{
		return validEntry;
	}
	
	public void setNumEntries(int num)
	{
		numEntries = num;
	}
	
	public static int getNumEntries()
	{
		return numEntries;
	}
	
	public void setScanner(File file) throws FileNotFoundException
	{
		scanner = new Scanner(file);
	}
	
	public void setProcessEntry(String entry)
	{
		e1 = new ProcessEntry(entry);
	}
	
	public void getProcessEntry()
	{
		System.out.println(e1);
	}
}
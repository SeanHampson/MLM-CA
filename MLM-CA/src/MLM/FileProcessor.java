package MLM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor
{	
	private ProcessEntry e1;
	private Trainer t1;
	private Scanner scanner;
	private File file;
	private int numEntries;
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
			entry = scanner.next();
			entry = entry.replaceAll("\\s",  "");	// Remove whitespace
			setValidEntry(entry.startsWith("Male") || entry.startsWith("Female"));
			
			if(getValidEntry())
			{
				setNumEntries(numEntries + 1);
				setProcessEntry(entry);
			}
		}
		
		t1 = new Trainer(e1.getPopulations(), getNumEntries());
		System.out.println(t1);
		
		System.out.println("No. of Entries: " + getNumEntries());
		getProcessEntry();
		scanner.close();
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
	
	public int getNumEntries()
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
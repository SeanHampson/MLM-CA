package MLM;

import java.io.FileNotFoundException;

public class Control
{
	public static String fileName = "MLdata.csv";
	
	public static void main(String args[]) throws FileNotFoundException
	{
		// Should only be called once - at the beginning of the program
		FileProcessor f1 = new FileProcessor(fileName);
		
		GUI app = new GUI("Using Naïve Bayes");
	}
}

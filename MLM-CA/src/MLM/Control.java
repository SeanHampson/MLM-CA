package MLM;

import java.io.FileNotFoundException;

public class Control
{
	public static String fileName = "MLdata.csv";
	
	public static void main(String args[]) throws FileNotFoundException
	{
		//GUI app = new GUI("Using Naïve Bayes");
		
		FileProcessor f1 = new FileProcessor(fileName);
	}
}

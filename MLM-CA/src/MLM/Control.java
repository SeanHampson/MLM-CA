package MLM;

import java.io.FileNotFoundException;

public class Control
{
	public static String fileName = "MLdata.csv";
	
	public static void main(String args[]) throws FileNotFoundException
	{
		// Should only be called once - at the beginning of the program
		@SuppressWarnings("unused")
		FileProcessor f1 = new FileProcessor(fileName, 0.7);
		//System.out.println(f1);
		
		@SuppressWarnings("unused")
		GUI app = new GUI("Using Naïve Bayes");
		//System.out.println(app);
	}
}

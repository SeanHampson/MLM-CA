/* Processes quantity of cases */
package MLM;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessEntry
{	
	/* Index 0 = Male */ /* Index 1 = Female */
	private static ArrayList<Integer> gender = new ArrayList<Integer>(Arrays.asList(0,0));
	/* Index 0 = Yes */ /* Index 1 = No */
	private static ArrayList<Integer> becameEntrepreneur = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> parentGuardianBusiness = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> partTimeJob = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> businessStudent = new ArrayList<Integer>(Arrays.asList(0,0));
	/* Index 0 = Urban */ /* Index 1 = Rural */
	private static ArrayList<Integer> address = new ArrayList<Integer>(Arrays.asList(0,0));
	/* Array of Features */
	private static ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>(Arrays.asList(gender, parentGuardianBusiness, partTimeJob, address, businessStudent, becameEntrepreneur));
	
	/* Entrepreneur Values per Feature */
	private static int maleEntre=0, femaleEntre=0, 
	y_pgBusinessEntre=0, n_pgBusinessEntre=0,	// pgBusiness = Parent Guardian Had a Business (Feature)
	y_partTimeJobEntre=0, n_partTimeJobEntre=0,		// ptJob = Had a part time job (Feature)
	y_businessStudent=0, n_businessStudent=0,
	u_address=0, r_address=0;
	
	public ProcessEntry(String entry)
	{
		ArrayList<String> entryArray = new ArrayList<String>(Arrays.asList(entry.split(",")));
		int entryLength = entryArray.size();
		
		// Is a Male
		if(entryArray.get(0).equals("male"))
		{
			// Male & Entrepreneur
			if(entryArray.get(5).equals("yes")) maleEntre++;
		}
		// Is a Female
		else if(entryArray.get(0).equals("female"))
		{
			// Female & Entrepreneur
			if(entryArray.get(5).equals("yes")) femaleEntre++;
		}
		
		// Parent/Guardian Had Own Business
		if(entryArray.get(1).equals("yes"))
		{
			// Parent/Guardian Had Own Business & Entrepreneur
			if(entryArray.get(5).equals("yes")) y_pgBusinessEntre++;
		}
		else // Parent/Guardian Didn't Own Business
		{
			// Parent/Guardian Didn't Own Business & Entrepreneur
			if(entryArray.get(5).equals("yes")) n_pgBusinessEntre++;
		}
		
		/* Had Part Time Job */
		if(entryArray.get(2).equals("yes"))
		{
			// Had Part Time Job & Entrepreneur
			if(entryArray.get(5).equals("yes")) y_partTimeJobEntre++;
		}
		else // Didn't Part Time Job
		{
			// Didn't Part Time Job & Entrepreneur
			if(entryArray.get(5).equals("yes")) n_partTimeJobEntre++;
		}
		
		/* Urban or Rural Address */
		if(entryArray.get(3).equals("urban"))
		{
			// Urban & Entrepreneur
			if(entryArray.get(5).equals("yes")) u_address++;
		}
		else // Rural
		{
			// Rural & Entrepreneur
			if(entryArray.get(5).equals("yes")) r_address++;
		}
		
		/* Studied Business */
		if(entryArray.get(4).equals("yes"))
		{
			// Studied Business & Entrepreneur
			if(entryArray.get(5).equals("yes")) y_businessStudent++;
		}
		else // Didn't Study Business
		{
			// Didn't Study Business & Entrepreneur
			if(entryArray.get(5).equals("yes")) n_businessStudent++;
		}

		populateArrays(entryArray, entryLength);
	}
	
	public void incrementValue(ArrayList<Integer> array, int index)
	{
		// Gets old value
		int oldVal = array.get(index);
		// Creates new value
		int newVal = oldVal + 1;
		// Changes to new value
		array.set(index, newVal);
	}
	
	public void populateArrays(ArrayList<String> array, int size)
	{
		for(int i = 0; i < size; i++)
		{
			String value = array.get(i).toLowerCase();
			
			if(i == 0)
			{
				if(value.equals("male"))
				{
					incrementValue(gender, 0);
				}
				else
				{
					incrementValue(gender, 1);
				}
			}
			else
			{
				if(value.equals("yes") || value.equals("urban"))
				{
					incrementValue(options.get(i), 0);
				}
				else
				{
					incrementValue(options.get(i), 1);
				}
			}
		}
	}
	
	public String toString()
	{
		/* ORDER
		 * gender	
		 * parentBusiness		
		 * ptJob
		 * urban
		 * businessStudent
		 * entrepreneur
		 * */
		
		String summary = 
		"=====<[Values for Debugging]>=====\n"
		+ "0-0: Males: " + gender.get(0)
		+"\n0-1: Females: " + gender.get(1)
		
		+"\n1-0: Parent/Guardian Had Own Business: " + parentGuardianBusiness.get(0)
		+"\n1-1: Parent/Guardian Didn't Own Business: " + parentGuardianBusiness.get(1)
		
		+"\n2-0: Had Part Time Job: " + partTimeJob.get(0)
		+"\n2-1: Didn't Have Part Time Job: " + partTimeJob.get(1)
		
		+"\n3-0: Urban: " + address.get(0)
		+"\n3-1: Rural: " + address.get(1)
		
		+"\n4-0: Business Students: " + businessStudent.get(0)
		+"\n4-1: No business: " + businessStudent.get(1)
		
		+ "\n5-0: Entrepreneurs: " + becameEntrepreneur.get(0)
		+ "\n5-1: Non Entrepreneurs: " + becameEntrepreneur.get(1) +
		
		"\n\n=====<[Values]>=====\n0: Male & Entrepreneur | " + maleEntre + "\n" +
		" : Male & Not Entrepreneur | " + (gender.get(0)-maleEntre) + "\n\n" +
				
		"1: Female & Entrepreneur | " + femaleEntre + "\n" +
		" : Female & Not Entrepreneur | " + (gender.get(1)-femaleEntre) + "\n\n" +
				
		"2: Parent/Guardian Had Own Business & Entrepreneur | " + y_pgBusinessEntre + "\n" +
		" : Parent/Guardian Had Own Business & Not Entrepreneur | " + (parentGuardianBusiness.get(0)-y_pgBusinessEntre) + "\n\n" +
			
		"3: Parent/Guardian Didn't Own Business & Entrepreneur | " + n_pgBusinessEntre + "\n" +
		" : Parent/Guardian Didn't Own Business & Not Entrepreneur | " + (parentGuardianBusiness.get(1)-n_pgBusinessEntre) + "\n\n" +
				
		"4: Had Part Time Job & Entrepreneur | " + y_partTimeJobEntre + "\n" +
		" : Had Part Time Job & Not Entrepreneur | " + (partTimeJob.get(0)-y_partTimeJobEntre) + "\n\n" +
				
		"5: Didn't Have Part Time Job & Entrepreneur | " + n_partTimeJobEntre + "\n" +
		" : Didn't Have Part Time Job & Not Entrepreneur | " + (partTimeJob.get(1)-n_partTimeJobEntre) + "\n\n" +
				
		"6: Urban & Entrepreneur | " + u_address + "\n" +
		" : Urban & Not Entrepreneur | " + (address.get(0)-u_address) + "\n\n" +
				
		"7: Rural & Entrepreneur | " + r_address + "\n" +
		" : Rural & Not Entrepreneur | " + (address.get(1)-r_address) + "\n\n" +
				
		"8: Business Student & Entrepreneur | " + y_businessStudent + "\n" +
		" : Business Student & Not Entrepreneur | " + (businessStudent.get(0)-y_businessStudent) + "\n\n" +
				
		"9: Not a Business Student & Entrepreneur | " + n_businessStudent + "\n" +
		" : Not a Business Student & Not Entrepreneur | " + (businessStudent.get(1)-n_businessStudent) + "\n";
		
		return summary;
	}

	public static ArrayList<Integer> getValues()
	{
		// Returns array of values for each feature
		// The likes of Male & Entrepreneur, and Had a part time job & No an Entrepreneur are within these values
		ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(maleEntre, femaleEntre, 
																		y_pgBusinessEntre, n_pgBusinessEntre,
																		y_partTimeJobEntre, n_partTimeJobEntre,	
																		y_businessStudent, n_businessStudent,
																		u_address, r_address));
		
		return values;
	}
	
	public static ArrayList<ArrayList<Integer>> getPopulations()
	{
		// Return array of populated arrays
		return options;
	}
}
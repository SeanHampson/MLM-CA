/* Processes quantity of cases */
package MLM;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessEntry
{	
	/* Index 0 = Male */ /* Index 1 = Female */
	private static ArrayList<Integer> entrepreneur = new ArrayList<Integer>(Arrays.asList(0,0));
	/* Index 0 = Yes */ /* Index 1 = No */
	private static ArrayList<Integer> gender = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> pgBusiness = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> ptJob = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<Integer> businessStudent = new ArrayList<Integer>(Arrays.asList(0,0));
	/* Index 0 = Urban */ /* Index 1 = Rural */
	private static ArrayList<Integer> address = new ArrayList<Integer>(Arrays.asList(0,0));
	private static ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>(Arrays.asList(gender, pgBusiness, ptJob, address, businessStudent, entrepreneur));
	
	public ProcessEntry(String entry)
	{
		ArrayList<String> entryArray = new ArrayList<String>(Arrays.asList(entry.split(",")));
		int entryLength = entryArray.size();

		populateArrays(entryArray, entryLength);
	}
	
	public void incrementValue(ArrayList<Integer> array, int index)
	{
		int oldVal = array.get(index);
		int newVal = oldVal + 1;
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
		String summary = 
		"\n1: Males: " + gender.get(0)
		+"\n2: Females: " + gender.get(1)
		
		+"\n3: PG Had biz: " + pgBusiness.get(0)
		+"\n4: PG No biz: " + pgBusiness.get(1)
		
		+"\n5: PT Job: " + ptJob.get(0)
		+"\n6: No Job: " + ptJob.get(1)
		
		+"\n7: Urban: " + address.get(0)
		+"\n8: Rural: " + address.get(1)
		
		+"\n9: Business Students: " + businessStudent.get(0)
		+"\n10: No business: " + businessStudent.get(1)
		
		+ "\n11: Entrepreneurs: " + entrepreneur.get(0)
		+ "\n12: Non Entrepreneurs: " + entrepreneur.get(1);
		
		return summary;
	}

	public ArrayList<ArrayList<Integer>> getPopulations()
	{
		return options;
	}
}
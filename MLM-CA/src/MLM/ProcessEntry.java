package MLM;

public class ProcessEntry
{
	/* Number of male/female that became entrepreneurs */
	private static int male, female;
	
	public ProcessEntry(String entry)
	{
		if(isMale(entry) && isEntrepreneur(entry))
		{
			male++;
		}
		else if(isFemale(entry) && isEntrepreneur(entry))
		{
			female++;
		}
	}
	
	public boolean isEntrepreneur(String entry)
	{
		if(entry.endsWith("Yes"))
		{
			return true;
		}
		return false;
	}
	
	public boolean isMale(String entry)
	{
		if(entry.startsWith("Male")) 
		{
			return true;
		}
		return false;
	}
	
	public boolean isFemale(String entry)
	{
		if(entry.startsWith("Female")) 
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String summary = "Male Entrepreneurs: " + male + "\nFemale "
				+ "Entrepreneurs: " + female;
		return summary;
	}
}

package MLM;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessQuery
{
	private String gender;
	private boolean parentGuardianBusiness, partTimeJob, urban, businessStudent;
	private String prob;
	
	public ProcessQuery(Query query)
	{	
		prob = bayesFormula(query);
	}
	
	public String toString()
	{
		// Should return Yes/NoS
		String summary = getProb();
		
		return summary;
	}
	
	public String getProb()
	{
		return prob;
	}
	
	public String bayesFormula(Query query)
	{
		/* 0 gender, 1 pgBusiness, 2 ptJob, 3 address, 4 businessStudent, 5 entrepreneur */
		ArrayList<ArrayList<Integer>> population = ProcessEntry.getPopulations();
		double numEntrepreneurs = population.get(5).get(0);
		double numNonEntrepreneurs = population.get(5).get(1);
		double topLine=1.0, compare=1.0;
		double numEntries = FileProcessor.getNumEntries();
		
		/* gender, parentBusiness, partTimeJob, urban, businessStudent */
		gender = query.getGender();
		parentGuardianBusiness = query.isParentBusiness();
		partTimeJob = query.isPtJob();
		urban = query.isUrban();
		businessStudent = query.isBusinessStudent();
		
		/* values array index
		 * 0 maleEntre, 
		 * 1 femaleEntre, 
		 * 2 y_pgBusinessEntre, 
		 * 3 n_pgBusinessEntre,
		 * 4 y_ptJobEntre, 
		 * 5 n_ptJobEntre,
		 * 6 u_address, 
		 * 7 r_address,	
		 * 8 y_businessStudent, 
		 * 9 n_businessStudent,
		 */
		ArrayList<Integer> values = ProcessEntry.getValues();
		int valuesLength = values.size();
		
		/* parentGuardianBusiness, partTimeJob, urban, businessStudent */
		ArrayList<Boolean> features = new ArrayList<Boolean>(Arrays.asList(parentGuardianBusiness, partTimeJob, urban, businessStudent));
		int featuresLength = features.size();
		
		if(gender.equals("male"))
		{
			topLine *= ((double) values.get(0)/ numEntrepreneurs);
			compare *= ((double) (population.get(0).get(0)-values.get(0))/ numNonEntrepreneurs);
		}
		// Female
		else
		{
			topLine *= ((double) values.get(1)/ numEntrepreneurs);
			compare *= ((double) (population.get(0).get(1)-values.get(1))/ numNonEntrepreneurs);
		}
		
		for(int i = 0, j = 2; i < featuresLength && j < valuesLength; i++, j+=2)
		{
			if(features.get(i))
			{
				topLine *= ((double) values.get(j)/ numEntrepreneurs);
				compare *= ((double) (population.get(i+1).get(0)-values.get(j))/ numNonEntrepreneurs);
			}
			else
			{
				topLine *= ((double) values.get(j+1)/ numEntrepreneurs);
				compare *= ((double) (population.get(i+1).get(1)-values.get(j+1))/ numNonEntrepreneurs);
			}
		}
		
		topLine *= ((double) population.get(5).get(0)/ numEntries);
		compare *= ((double) population.get(5).get(1)/ numEntries);
		
		if(topLine > compare) 
		{
			return "yes";
		}
		else
		{
			return "no";
		}
	}
}

package MLM;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessQuery
{
	private String gender;
	private boolean ptB, ptJ, urban, bStud, success;
	private double prob;
	
	public ProcessQuery(Query query)
	{
		//ArrayList<Boolean> queryBools = new ArrayList<Boolean>(Arrays.asList(ptB, ptJ, urban, bStud, success));
		
		prob = bayesFormula(query);
	}
	
	public String toString()
	{
		String summary=String.valueOf(getProb());
		
		return summary;
	}
	
	public double getProb()
	{
		return prob;
	}
	
	public double bayesFormula(Query query)
	{
		double tLine=1.0, bLine=1.0;
		//double ctLine=1.0, cbLine=1.0;
		
		double numEntries = FileProcessor.getNumEntries();
		
		/*private String gender;	
		private boolean parentBusiness;		
		private boolean ptJob;				
		private boolean urban;			
		private boolean businessStudent;
		private boolean success; */
		
		gender = query.getGender();
		ptB = query.isParentBusiness();
		ptJ = query.isPtJob();
		urban = query.isUrban();
		bStud = query.isBusinessStudent();
		//success = query.isSuccess();
		
		/* 0 gender, 1 pgBusiness, 2 ptJob, 3 address, 4 businessStudent, 5 entrepreneur */
		ArrayList<ArrayList<Integer>> population = ProcessEntry.getPopulations();
		
		/* values array index
		 * 0 maleEntre, 
		 * 1 femaleEntre, 
		 * 2 y_pgBusinessEntre, 
		 * 3 n_pgBusinessEntre,
		 * 4 y_ptJobEntre, 
		 * 5 n_ptJobEntre,	
		 * 6 y_businessStudent, 
		 * 7 n_businessStudent,
		 * 8 u_address, 
		 * 9 r_address
		 */
		ArrayList<Integer> values = ProcessEntry.getValues();
		
		double numEntrepreneurs = population.get(5).get(0);
		
		if(gender.equals("Male"))
		{
			tLine *= ((double) values.get(0)/ numEntrepreneurs);
			bLine *= ((double) population.get(0).get(0)/ numEntries);
		}
		else // Female
		{
			tLine *= ((double) values.get(1)/ numEntrepreneurs);
			bLine *= (((double) population.get(0).get(1))/ numEntries);
		}
		
		// Debugging
		System.out.println("1st:\nTop Line: "  + (double) values.get(1) + " / " + numEntrepreneurs + " = " + tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		if(ptB)
		{
			tLine *= ((double) values.get(2)/ numEntrepreneurs);
			bLine *= ((double) population.get(1).get(0)/ numEntries);
		}
		else // Doesn't own business
		{
			tLine *= ((double) values.get(3)/ numEntrepreneurs);
			bLine *= ((double) population.get(1).get(1)/ numEntries);
		}
		
		// Debugging
		System.out.println("2nd:\nTop Line: " + tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		if(ptJ)
		{
			tLine *= ((double) values.get(4)/ numEntrepreneurs);
			bLine *= ((double) population.get(2).get(0)/numEntries);
		}
		else
		{
			tLine *= ((double) values.get(5)/ numEntrepreneurs);
			bLine *= ((double) population.get(2).get(1)/ numEntries);
		}
		
		// Debugging
		System.out.println("3rd:\nTop Line: " + tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		if(urban)
		{
			tLine *= ((double) values.get(6)/ numEntrepreneurs);
			bLine *= ((double) population.get(3).get(0)/ numEntries);
		}
		else
		{
			tLine *= ((double) values.get(7)/ numEntrepreneurs);
			bLine *= ((double) population.get(3).get(1)/ numEntries);
		}
		
		// Debugging
		System.out.println("4th:\nTop Line: " + tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		if(bStud)
		{
			tLine *= ((double) values.get(8)/ numEntrepreneurs);
			bLine *= ((double) population.get(4).get(0)/ numEntries);
		}
		else
		{
			tLine *= ((double) values.get(9)/ numEntrepreneurs);
			bLine *= ((double) population.get(4).get(1)/ numEntries);
		}
		
		// Debugging
		System.out.println("5th:\nTop Line: " + tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		tLine *= ((double) population.get(5).get(0)/ numEntries);
		
		System.out.println("6th:\nTop Line: " + (double) population.get(5).get(0) + " / " +  numEntries + " : "+ tLine);
		System.out.println("Bottom Line: " + (double) population.get(0).get(1) + " / " + numEntries + " = " + bLine + "\n");
		
		return tLine/bLine;
	}
}

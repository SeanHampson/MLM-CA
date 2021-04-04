package MLM;

import java.util.ArrayList;
import java.util.Arrays;

public class Trainer
{
	private static ArrayList<Double> probability = new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
	
	
	public Trainer(ArrayList<ArrayList<Integer>> array, int size)
	{
		// Size = no. of entries in dataset
		int trainSize = (int) Math.floor(size * 0.7);
		int testSize = size - trainSize;
	
		populateProbability(array, size);
	}
	
	public String toString()
	{
		String summary = probValues();
		
		return summary;
	}
	
	public static ArrayList<Double> getProb()
	{
		return probability;
	}
	
	public String probValues()
	{
		String values = "Probabilities:\n";
		
		for(int i = 0; i < probability.size(); i++)
		{
			String info = String.valueOf(i+1) + ": ";
			values += info + probability.get(i) + "\n";
		}
		
		return values;
	}
	
	public void initProbability(int size)
	{
		for(int i = 0; i < size; i++)
		{
			probability.add(0.0);
		}
	}
	
	public void updateProbability(int index, double value)
	{
		probability.set(index, value);
	}
	
	public void populateProbability(ArrayList<ArrayList<Integer>> array, int size)
	{
		ArrayList<Integer> currentFeature;
		int length = array.size();
		int j = 0;
		
		for(int i = 0; i < length; i++)
		{
			/* gender, pgBusiness, ptJob, address, businessStudent, entrepreneur */
			currentFeature = array.get(i);
			//System.out.println((double) currentFeature.get(0) / size);
			//System.out.println((double) currentFeature.get(1) / size);
			
			updateProbability(j++, (double) currentFeature.get(0) / size);
			updateProbability(j++, (double) currentFeature.get(1) / size);
		}
	}
}

package construction;

import java.util.HashMap;
import java.util.Map;

public class HouseConstructionCost extends SiteDimensions
{
	int cpst;
	Map<String , Integer> cp;
	public HouseConstructionCost() 
	{
		cp = new HashMap<String,Integer>();
		cp.put("Standard", 1200);
		cp.put("Above Standard", 1500);
		cp.put("High Standard", 1800);
		cp.put("High Standard And Fully Automated", 2500);
	}
	
	public void selectPlan(String selectedPlan) 
	{
		this.cpst = cp.get(selectedPlan);
	}
	
	public void setDimensionsOfHouse(int length, int breadth) 
	{
		this.length = length;
		this.breadth = breadth;
	}
	
	public Map<String, Integer> getConstructionPlans() {
		return this.cp;
	}
	
	public int getEstimatedCost() {
		return (this.length * this.breadth * this.cpst);
	}
}
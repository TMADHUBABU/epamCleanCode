package thwkfinal.cleancode;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import calc.CompoundInterest;
import calc.SimpleInterest;
import construction.HouseConstructionCost;


/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner inputScanner = new Scanner(System.in);
	static PrintStream onScreenPrint = new PrintStream(new FileOutputStream(FileDescriptor.out));
	
	static double ipa;
	static double ari;
	static double ty;
	static int cfpy;
	static double ci;
	static double si;
	
    public static void main( String[] args )
    {
    	try 
    	{
	    	do 
	    	{
		        onScreenPrint.println("	Select Program	\n"
		        		+ "** Interest Calculator **\n"
		        		+ "1. Simple Interest\n"
		        		+ "2. Compound Interest\n\n"
		        		+ "** Estimating House Construction Cost **\n"
		        		+ "3. Select A Construction Plan : \n");
		        
		        int choice = inputScanner.nextInt();
		        switch(choice) 
		        {
		        case 1:
		        	getSimpleInterestValues();
		        	SimpleInterest simpleInterest = new SimpleInterest(ipa, ari, ty);
		        	onScreenPrint.println("Simple Interest = " + simpleInterest.calculateSimpleInterest());
		        	break;
		        case 2:
		        	getCompoundInterestValues();
		        	CompoundInterest compoundInterest = new CompoundInterest(ipa, ari, ty , cfpy);
		        	onScreenPrint.println("Compound Interest = " + compoundInterest.calculateCompoundInterest());
		        	break;
		        case 3:
		        	houseConstructionEstimation();
		        	break;
		        default:
		        	onScreenPrint.println("Invalid Option Selected");
		        }
		        onScreenPrint.println("\nWould You Like To Continue (y/n) : ");
	    	} while(inputScanner.next().charAt(0)  == 'y');
	    	
	    	onScreenPrint.println("Program Terminated Successfully\n");
	        inputScanner.close();
	        onScreenPrint.close();
    	}
    	catch(Exception e) {
    		onScreenPrint.println("\nError Occurred " + e);
    	}
    }
    
    public static void houseConstructionEstimation() 
    {
    	HouseConstructionCost houseObject = new HouseConstructionCost();
    	
    	Set< Map.Entry< String,Integer> > constructionPlans = houseObject.getConstructionPlans().entrySet();
        int index = 1, length, breadth;
        String selectedPlan;
        ArrayList<String> options = new ArrayList<String>();
        onScreenPrint.println("List Of Construction Plans");
        for (Map.Entry< String,Integer> plan : constructionPlans) 
        {
        	options.add(plan.getKey());
            onScreenPrint.println(index + ". " + plan.getKey() + " Material Costs " + plan.getValue() + " per square feet");
            index++;
        }
        index = inputScanner.nextInt();
        if(index > 0 && index < 5) 
        {
        	selectedPlan = options.get(index-1);
        	houseObject.selectPlan(selectedPlan);
        }
        else 
        {
        	onScreenPrint.println("Invalid Option\n");
        	return ;
        }
        onScreenPrint.println("Enter Area Of The House (Length x breadth) : \n");
        length = inputScanner.nextInt();
        breadth = inputScanner.nextInt();
        houseObject.setDimensionsOfHouse(length, breadth);
        onScreenPrint.println("Cost for construction = " + houseObject.getEstimatedCost() + " INR");
    }

	public static void getSimpleInterestValues()
    {
    	onScreenPrint.println("Enter the principal amount , rate of interest , time in years: ");
    	ipa = inputScanner.nextDouble();
    	ari = inputScanner.nextDouble();
    	ty = inputScanner.nextDouble();
    }
    
    public static void getCompoundInterestValues()
    {
    	onScreenPrint.println("enter the principal amount , rate of interest per annum , time in years , frequency of compounding in a year");
    	ipa = inputScanner.nextDouble();
    	ari = inputScanner.nextDouble();
    	ty = inputScanner.nextDouble();
    	cfpy = inputScanner.nextInt();
    }
}

package calc;
import java.lang.Math;
public class CompoundInterest
{
	private double ipa;
	private double ari;
	private double ty;
	private int cmfy;
	private double ci;
	
	public CompoundInterest(double initialPrincipalAmount , double annualRateOfInterest , double timeInYears, int compoundingFrequencyPerYear)
	{
		this.ipa = initialPrincipalAmount;
		this.ari = annualRateOfInterest;
		this.ty = timeInYears;
		this.cmfy = compoundingFrequencyPerYear;
	}
	
	public void setValues(double initialPrincipalAmount , double annualRateOfInterest , double timeInYears , int compoundingFrequencyPerYear)
	{
		this.ipa = initialPrincipalAmount;
		this.ari = annualRateOfInterest;
		this.ty = timeInYears;
		this.cmfy = compoundingFrequencyPerYear;
	}
	
	public double calculateCompoundInterest()
	{
		ci = (ipa * Math.pow(1 + ari / (cmfy*100) , (ty * cmfy))) - ipa;
		return ci;
	}
}

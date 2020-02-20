package calc;

public class SimpleInterest
{
	private double ia;
	private double ari;
	private double ty;
	private double smplei;

	public SimpleInterest(double initialPrincipalAmount , double annualRateOfInterest , double timeInYears)
	{
		this.ia = initialPrincipalAmount;
		this.ari = annualRateOfInterest;
		this.ty = timeInYears;
	}
	
	public void setValues(double initialPrincipalAmount , double annualRateOfInterest , double timeInYears)
	{
		this.ia = initialPrincipalAmount;
		this.ari = annualRateOfInterest;
		this.ty = timeInYears;
	}
	
	public double calculateSimpleInterest()
	{
		smplei = (ia * ty * ari)/100;
		return smplei;
	}
}
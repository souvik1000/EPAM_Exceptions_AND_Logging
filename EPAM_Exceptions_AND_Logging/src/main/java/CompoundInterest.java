public class CompoundInterest {
    public static String compoundInterest(double principalAmount, double rateOfInterest, double time)
    {
        return String.format("%.2f", principalAmount * Math.pow(1.0+rateOfInterest/100.0,time) - principalAmount);
    }
}

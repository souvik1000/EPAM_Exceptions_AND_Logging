public class SimpleInterest {
    public static String simpleInterest(double principalAmount, double rateOfInterest, double time)
    {
        return String.format("%.2f", principalAmount*time*rateOfInterest/100);
    }
}

import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    public static double predictFutureValueRecursive(double presentValue, double growthRate, int years) {
        if (years <= 0) {
            return presentValue;
        }
        
        // Recursive Step: FV(n) = FV(n-1) * (1 + r)
        return predictFutureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimization: Memoized Recursive Approach

    private static Map<Integer, Double> memoTable = new HashMap<>();

    /*
     * Predicts future value using recursion optimized with memoization.
    */
    public static double predictFutureValueOptimized(double presentValue, double growthRate, int years) {
        // Base Case
        if (years <= 0) {
            return presentValue;
        }

        // Check if the result for this year has already been calculated
        if (memoTable.containsKey(years)) {
            return memoTable.get(years);
        }

        // Calculate and store in the memo table before returning
        double result = predictFutureValueOptimized(presentValue, growthRate, years - 1) * (1 + growthRate);
        memoTable.put(years, result);

        return result;
    }

    // ---------------------------------------------------------
    // Main Method to Test
    // ---------------------------------------------------------
    public static void main(String[] args) {
        double startingCapital = 10000.0; 
        double annualGrowth = 0.07;       
        int projectionPeriod = 10;        

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.printf("Starting Capital: $%.2f\n", startingCapital);
        System.out.printf("Growth Rate: %.1f%%\n", annualGrowth * 100);
        System.out.printf("Projection Horizon: %d years\n\n", projectionPeriod);

        long startTime = System.nanoTime();
        double standardResult = predictFutureValueRecursive(startingCapital, annualGrowth, projectionPeriod);
        long endTime = System.nanoTime();
        System.out.printf("Standard Recursive Forecast: $%.2f\nTime taken:"+(endTime-startTime)+"ns", standardResult);
    

        startTime = System.nanoTime();
        double optimizedResult = predictFutureValueOptimized(startingCapital, annualGrowth, projectionPeriod);
        endTime = System.nanoTime();
        System.out.printf("Optimized Recursive Forecast: $%.2f\nTime taken:\"+(endTime-startTime)+\"ns\"", optimizedResult);
    }
}
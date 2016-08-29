import java.util.Scanner;

/**
 * Created by markdaniel on 5/19/16.
 */
public class BuyAndSellStock1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPrices = scanner.nextInt();
        int[] prices = new int[numPrices];
        scanner.nextLine();
        String numbers = scanner.nextLine();

        int index = 0;
        for (String s : numbers.split(",")) {
            prices[index] = Integer.parseInt(s);
            index++;
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        } else if (len == 2) {
            return prices[0] > prices[1] ? 0 : prices[1] - prices[0];
        }

        int[] dp = new int[len];
        boolean skippedAhead;
        int lag = 0;

        do {
            skippedAhead = false;
            for (int lead = lag + 1; lead < len; lead++) {
                if (prices[lead] < prices[lag]) {
                    lag = lead;
                    dp[lead] = dp[lead - 1];
                    skippedAhead = true;
                    break;
                }
                if (prices[lead] > prices[lag]) {
                    dp[lead] = Math.max(dp[lead - 1], Math.max(dp[lead], prices[lead] - prices[lag]));
                } else {
                    dp[lead] = Math.max(dp[lead - 1], dp[lead]);
                }
            }
        } while (skippedAhead);

        return dp[len - 1];
    }
}

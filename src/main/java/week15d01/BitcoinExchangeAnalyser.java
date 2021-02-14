package week15d01;

import java.util.List;

public class BitcoinExchangeAnalyser {

    public BestPurchaseDay analyser(List<Integer> rates) {
        int maxProfit = Integer.MIN_VALUE;
        BestPurchaseDay bestPurchaseDay = null;

        for (int i = 0; i < rates.size(); i++) {
            for (int j = i; j < rates.size(); j++) {
                if (rates.get(j) - rates.get(i) > maxProfit) {
                    maxProfit = rates.get(j) - rates.get(i);
                    bestPurchaseDay = new BestPurchaseDay(i, j, maxProfit);
                }
            }
        }

        return bestPurchaseDay;
    }

    public static void main(String[] args) {
        BitcoinExchangeAnalyser bitcoinExchangeAnalyser = new BitcoinExchangeAnalyser();

        System.out.println(bitcoinExchangeAnalyser.analyser(List.of(100, 120, 40, 70, 200, 30, 50)).toString());

    }

}

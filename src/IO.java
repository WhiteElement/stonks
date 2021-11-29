import javafx.util.Pair;

import java.util.*;

public class IO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stonk stonk = new Stonk();

        Map<String, Runnable> baseMetrix = new LinkedHashMap<String, Runnable>();
        baseMetrix.put("Um welche Aktie handelt es sich", () -> stonk.setName(scanner.nextLine()));
        baseMetrix.put("Was ist der aktuelle Kurs?", () -> stonk.setValue(scanner.nextFloat()));
        baseMetrix.put("Was sind die aktuellen EPS?", () -> stonk.setEps(scanner.nextFloat()));
        baseMetrix.put("Wie hoch ist das Wachstum?", () -> stonk.setGrowth(scanner.nextFloat()));
        baseMetrix.put("Wie hoch ist die Dividende?", () -> stonk.setDividend(scanner.nextFloat()));
        baseMetrix.put("Um welche Aktie handelt es sich", () -> stonk.setName(scanner.nextLine()));


        for(Map.Entry<String,Runnable> entry : baseMetrix.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().run();
        }

        StonkPrinter stonkPrinter = new StonkPrinter();
        stonkPrinter.printOverview(stonk);

        System.out.println("Programm beenden (1) oder");
        System.out.println("Details der der Aktie ausrechenen (2)");

        if(scanner.nextInt() == 1) {
           System.exit(0);
        }
        else {
            Map<String,Runnable> balanceSheetMetrix = new LinkedHashMap<String,Runnable>();
            balanceSheetMetrix.put("Wie hoch sind die langfristigen Verbindlichkeiten?",() -> stonk.setLt_liabilities(scanner.nextLong()));
            balanceSheetMetrix.put("Wie hoch ist das Eigenkapital?", () -> stonk.setEquity(scanner.nextLong()));
            balanceSheetMetrix.put("Wie viel Cash halten Sie?", () -> stonk.setCash(scanner.nextLong()));
            balanceSheetMetrix.put("Wie viel sonstiges Cash haben sie?", () -> stonk.setOtherCashItems(scanner.nextLong()));
            balanceSheetMetrix.put("Wie hoch war der Gewinn?", () -> stonk.setProfit(scanner.nextLong()));

            for(Map.Entry<String,Runnable> entry : balanceSheetMetrix.entrySet()) {
                System.out.println(entry.getKey());
                entry.getValue().run();
            }
        }

        StonkCalculator calculator = new StonkCalculator();
        calculator.calculateDetails(stonk);

        System.out.println("EquityDebtRatio " + calculator.getEquityDebtRatio());
        System.out.println("Total Cash " + stonkPrinter.formatThousandSeperator(calculator.getTotalCash()));
        System.out.println("Number of shares " + stonkPrinter.formatThousandSeperator(calculator.getNumOfShares()));
        System.out.println("Cash per Share " + stonkPrinter.roundToOneDec(calculator.getCashPerShare()));
    }

}




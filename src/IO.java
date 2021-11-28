import java.util.Scanner;

public class IO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stonk stonk = new Stonk();


        //Welche Aktie
        collectInputTo("Um Welche Aktie geht es?", scanner, stonk);

        //aktueller Kurs
        collectInputTo("Was ist der aktuelle Kurs?");

        // EPS
        System.out.println("Was ist sind die aktuellen EPS?");
        stonk.setEps(scanner.nextFloat());
        System.out.println(stonk.getEps());

        //Auswahl geschätztes Wachstum oder Durchschnitt mehrerer Jahre
        System.out.println("Möchtest du ein Wachstum eingeben(1) oder soll ich über die letzten Jahre mitteln(2: noch nicht impl.)?");
        if(scanner.nextInt() == 1) {
            System.out.println("Wie hoch ist das Wachstum?");
            stonk.setGrowth(scanner.nextFloat());
            System.out.println(stonk.getGrowth());
        }

        // Dividende
        System.out.println("Wie hoch ist die Dividende?");
        stonk.setDividend(scanner.nextFloat());
        System.out.println(stonk.getDividend());


        StonkPrinter stonkPrinter = new StonkPrinter();
        stonkPrinter.printOverview(stonk);

        System.out.println("Programm beenden (1) oder");
        System.out.println("Details der der Aktie ausrechenen (2)");

        if(scanner.nextInt() == 1) {
           System.exit(0);
        }
        else {
            System.out.println("Wie hoch sind die langfristigen Verbindlichkeiten?");
            stonk.setLt_liabilities(scanner.nextLong());
            System.out.println(stonkPrinter.formatThousandSeperator(stonk.getLt_liabilities()));


            System.out.println("Wie hoch ist das Eigenkapital?");
            stonk.setEquity(scanner.nextLong());
            System.out.println(stonkPrinter.formatThousandSeperator(stonk.getEquity()));

            System.out.println("Wie viel Cash halten Sie?");
            stonk.setCash(scanner.nextLong());
            System.out.println(stonkPrinter.formatThousandSeperator(stonk.getCash()));

            System.out.println("Wie viel sonstiges Cash haben sie?");
            stonk.setOtherCashItems(scanner.nextLong());
            System.out.println(stonkPrinter.formatThousandSeperator(stonk.getCash()));

            System.out.println("Wie hoch war der Gewinn?");
            stonk.setProfit(scanner.nextLong());
            System.out.println(stonkPrinter.formatThousandSeperator(stonk.getProfit()));

        }

        StonkCalculator calculator = new StonkCalculator();
        calculator.calculateDetails(stonk);

        System.out.println("EquityDebtRatio " + calculator.getEquityDebtRatio());
        System.out.println("Total Cash " + stonkPrinter.formatThousandSeperator(calculator.getTotalCash()));
        System.out.println("Number of shares " + stonkPrinter.formatThousandSeperator(calculator.getNumOfShares()));
        System.out.println("Cash per Share " + stonkPrinter.roundToOneDec(calculator.getCashPerShare()));
    }

    private static void collectInputTo(String question, Scanner scanner, Stonk stonk) {
        System.out.println(question);
        stonk.setName(scanner.nextLine());
        System.out.println(stonk.getName() + "\n");
    }
}




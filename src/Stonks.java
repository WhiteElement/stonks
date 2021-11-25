import java.util.Scanner;

public class Stonks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stonk stonk = new Stonk();


        //Welche Aktie
        System.out.println("Um Welche Aktie geht es?");
        stonk.setName(scanner.nextLine());
        System.out.println(stonk.getName());

        //aktueller Kurs
        System.out.println("Was ist der aktuelle Kurs?");
        stonk.setValue(scanner.nextFloat());
        System.out.println(stonk.getValue());

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

        //langfristige Verbindlichkeiten

        // Eigenkapital


        //Cash und andere Cashpositionen

        //Aktienanzahl ausrechnen durch teilen durch Gewinn

        //Output

    }


}

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


        print_part1(stonk);


        //langfristige Verbindlichkeiten

        // Eigenkapital


        //Cash und andere Cashpositionen

        //Aktienanzahl ausrechnen durch teilen durch Gewinn

        //Output

    }

    private static void print_part1(Stonk stonk) {
        stonk.calcPart1();

        System.out.println("\n" + stonk.getName());
        System.out.println("Kurs:\t" + stonk.getValue());
        System.out.println("EPS:\t" + stonk.getEps());
        System.out.println("Gewinnwachstum:\t" + stonk.getGrowth());
        System.out.println("Dividende:\t" + stonk.getDividend());
        System.out.println("\n--------------------\n");

        System.out.println("KGV:\t" + Math.round(stonk.getKgv() * 10.0)/10.0);
        System.out.println("PEG:\t" + Math.round(stonk.getPeg() * 10.0)/10.0);
        System.out.println("Div. adj. PEG:\t" + Math.round(stonk.getDiv_adj_peg() * 10.0)/10.0);
        System.out.println("Die Aktie ist preiswert ab:\t" + Math.round(stonk.getCheap_price()* 10.0)/10.0);
    }

}

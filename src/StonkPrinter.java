import static java.lang.String.format;

public class StonkPrinter {

    StonkPrinter() {

    }

    public float roundToOneDec(float num) {
        return (float) (Math.round(num * 10.0) / 10.0);
    }

    public void lineFormat(String metric_name, float metric_val, boolean round) {
        if(round) {
            System.out.println(metric_name + "\t" + roundToOneDec(metric_val));
        }
        else {
            System.out.println(metric_name + "\t" + metric_val);
        }
    }

    public void calcOverview(Stonk s) {
        s.calcPart1();
    }

    public String formatThousandSeperator(long number) {
       String s = String.format("%,d", number);
       return s;
    }

    public void printOverview(Stonk s) {
        calcOverview(s);

        System.out.println("\n" + s.getName());

        lineFormat("Kurs", s.getValue(), false);
        lineFormat("EPS", s.getEps(), false);
        lineFormat("Gewinnwachstum", s.getGrowth(), false);
        lineFormat("Dividende", s.getDividend(), false);
        System.out.println("\n--------------------\n");

        lineFormat("KGV", s.getKgv(), true);
        lineFormat("PEG", s.getPeg(), true);
        lineFormat("Div. adj. PEG", s.getDiv_adj_peg(), true);
        lineFormat("Die Aktie ist preiswert ab", s.getCheap_price(), true);

    }
}

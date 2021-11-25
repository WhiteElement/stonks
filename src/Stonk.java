public class Stonk {

    private String name;
    private float value;
    private float eps;
    private float growth;
    private float dividend;
    private float kgv;
    private float peg;
    private float div_adj_peg;
    private float cheap_price;

    private int lt_liabilities;
    private int equity;

    private int cash;
    private int profit;
    private double number_of_stocks;
    private double cash_per_share;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getEps() {
        return eps;
    }

    public void setEps(float eps) {
        this.eps = eps;
    }

    public float getGrowth() {
        return growth;
    }

    public void setGrowth(float growth) {
        if(growth>0 && growth<100) {
            this.growth = growth;
        }
        else {
            System.out.println("Wachstum nicht zwischen 0% und 100%");
        }
    }

    public float getDividend() {
        return dividend;
    }

    public void setDividend(float dividend) {
        if(dividend>=0 && dividend<100) {
            this.dividend = dividend;
        }
        else {
            System.out.println("Dividende nicht zwischen 0% und 100%");
        }
    }

    public int getLt_liabilities() {
        return lt_liabilities;
    }

    public void setLt_liabilities(int lt_liabilities) {
        this.lt_liabilities = lt_liabilities;
    }

    public int getEquity() {
        return equity;
    }

    public void setEquity(int equity) {
        this.equity = equity;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public double getNumber_of_stocks() {
        return number_of_stocks;
    }

    public void calcNumber_of_stocks(double number_of_stocks) {
        this.number_of_stocks = this.profit / this.eps;
    }

    public double getCash_per_share() {
        return cash_per_share;
    }

    public void calcCash_per_share() {
        this.cash_per_share = this.cash / this.number_of_stocks;
    }

    public float getKgv() {
        return kgv;
    }

    public void calcKgv() {
        this.kgv = this.value / this.eps;
    }

    public float getPeg() {
        return peg;
    }

    public void calcPeg() {
        this.peg = this.kgv / this.growth;
    }

    public float getDiv_adj_peg() {
        return div_adj_peg;
    }

    public void calcDiv_adj_peg() {
        this.div_adj_peg = this.kgv / (this.growth + this.dividend);
    }

    public float getCheap_price() {
        return cheap_price;
    }

    public void calcCheap_price() {
        this.cheap_price = (this.growth + this.dividend) * this.eps;
    }

    public Stonk() {
    }

    public void calcPart1() {
        calcKgv();
        calcPeg();
        calcDiv_adj_peg();
        calcCheap_price();
    }

}

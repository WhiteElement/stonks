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

    private long lt_liabilities;
    private long equity;

    private long cash;
    private long otherCashItems ;
    private long profit;

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

    public long getLt_liabilities() {
        return lt_liabilities;
    }

    public void setLt_liabilities(long lt_liabilities) {
        this.lt_liabilities = lt_liabilities;
    }

    public long getEquity() {
        return equity;
    }

    public long getOtherCashItems() {
        return otherCashItems;
    }

    public void setOtherCashItems(long otherCashItems) {
        this.otherCashItems = otherCashItems;
    }

    public void setEquity(long equity) {
        this.equity = equity;
    }

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
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

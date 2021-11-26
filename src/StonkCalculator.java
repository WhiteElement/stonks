public class StonkCalculator {

    private float equityDebtRatio;
    private long totalCash;
    private long numOfShares;
    private float cashPerShare;

    public StonkCalculator() {}

    public float getEquityDebtRatio() {
        return equityDebtRatio;
    }

    public void calcEquityDebtRatio(Stonk stonk) {
        long equity = stonk.getEquity();
        this.equityDebtRatio = ((float) equity / (equity + stonk.getLt_liabilities())) * 100;
    }

    public long getTotalCash() {
        return totalCash;
    }

    public void calcTotalCash(Stonk stonk) {
        this.totalCash = stonk.getCash() + stonk.getOtherCashItems();
    }

    public long getNumOfShares() {
        return numOfShares;
    }

    public void calcNumOfShares(Stonk stonk) {
        this.numOfShares = (long) (stonk.getProfit() / stonk.getEps());
    }

    public float getCashPerShare() {
        return cashPerShare;
    }

    public void calcCashPerShare(Stonk stonk) {
        this.cashPerShare = totalCash / numOfShares;
    }

    public void calculateDetails(Stonk stonk) {
        calcEquityDebtRatio(stonk);
        calcTotalCash(stonk);
        calcNumOfShares(stonk);
        calcCashPerShare(stonk);

    }
}

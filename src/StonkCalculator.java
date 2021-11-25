public class StonkCalculator {

    private float equityDebtRatio;
    private long totalCash;
    private double numOfShares;
    private double cashPerShare;

    public StonkCalculator() {}

    public float getEquityDebtRatio() {
        return equityDebtRatio;
    }

    public void calcEquityDebtRatio(Stonk stonk) {
        long equity = stonk.getEquity();
        this.equityDebtRatio = equity / (equity + stonk.getLt_liabilities());
    }

    public long getTotalCash() {
        return totalCash;
    }

    public void calcTotalCash(Stonk stonk) {
        this.totalCash = stonk.getCash() + stonk.getOtherCashItems();
    }

    public double getNumOfShares() {
        return numOfShares;
    }

    public void calcNumOfShares(Stonk stonk) {
        this.numOfShares = stonk.getProfit() / stonk.getEps();
    }

    public double getCashPerShare() {
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

public class fiftyPercDisc extends couponDecorator {
    public fiftyPercDisc(disTransaction decoratedTransaction) {
        super(decoratedTransaction);
    }
    @Override
    public double getCharge() {
        double totalCharge = 0.0;
        double mostExpensive = 0.0;
        for (TransactionItem item : decoratedTransaction.transItemList){
            double tempCharge = item.getCharge();
            if (tempCharge > mostExpensive){
                mostExpensive = tempCharge;
            }
            totalCharge += tempCharge;
        }
        return totalCharge - (mostExpensive/2.0);  // 50% discount off of the cheapest item
    }
}

public class fpRentalRedemptionDisc extends couponDecorator {
    public Customer customer;
    private final int pointsCost = 10;

    public fpRentalRedemptionDisc(disTransaction decoratedTransaction, Customer customer) {
        super(decoratedTransaction);
        this.customer = customer;
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
        int currentFRP = customer.getFrequentRenterPoints();
        if (currentFRP >= pointsCost){
            customer.setFrequentRenterPoints(currentFRP-pointsCost);
            totalCharge -= mostExpensive;
        }
        return totalCharge;  // 100% discount off of the most exp item

    }
}

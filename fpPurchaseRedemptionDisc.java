public class fpPurchaseRedemptionDisc extends couponDecorator {
    public Customer customer;
    private final int pointsCost = 20; 

    public fpPurchaseRedemptionDisc(disTransaction decoratedTransaction, Customer customer) {
        super(decoratedTransaction);
        this.customer = customer;
    }
    @Override
    public double getCharge() {
        double totalCharge = 0.0;
        double leastExpensive = 99999999;
        for (TransactionItem item : decoratedTransaction.transItemList){
            double tempCharge = item.getCharge();
            if (tempCharge < leastExpensive  &&  item instanceof Purchase){
                leastExpensive = tempCharge;
            }
            totalCharge += tempCharge;
        }
        int currentFRP = customer.getFrequentRenterPoints();
        if (currentFRP >= pointsCost  &&  leastExpensive<99999999){
            customer.setFrequentRenterPoints(currentFRP-pointsCost);
            totalCharge -= leastExpensive;
        }
        return totalCharge;  // 100% discount off of the least expensive Purchase

    }
}

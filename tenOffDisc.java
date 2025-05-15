public class tenOffDisc extends couponDecorator {
    public tenOffDisc(disTransaction decoratedTransaction) {
        super(decoratedTransaction);
    }
    @Override
    public double getCharge() {
        double charge = super.getCharge();
        if (charge > 50){
            charge -= 10;  // -10$ if total is >50$
        }
        return charge;
    }
}

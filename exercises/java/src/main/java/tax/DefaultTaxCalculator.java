package tax;

public class DefaultTaxCalculator extends TaxCalculator {

    public DefaultTaxCalculator() {
    }

    public DefaultTaxCalculator(int year) {
        super(year);
    }

    @Override
    int calculateTax(Vehicle vehicle) {
        return 0;
    }
}

package tax;

import java.time.LocalDate;

import static tax.FuelType.*;

public class DefaultTaxCalculator extends TaxCalculator {
    boolean toggleCarsUnder40k;

    boolean isExpensiveCarTaxEnabled;

    public DefaultTaxCalculator() {
    }

    public DefaultTaxCalculator(boolean toggleCarsUnder40k, boolean isExpensiveCarTaxEnabled) {
        this.toggleCarsUnder40k = toggleCarsUnder40k;
        this.isExpensiveCarTaxEnabled = isExpensiveCarTaxEnabled;
    }

    public DefaultTaxCalculator(int year) {
        super(year);
    }


    @Override
    int calculateTax(Vehicle vehicle) {
        Integer co2Emissions = vehicle.getCo2Emissions();
        tax.FuelType fuelType = vehicle.getFuelType();

        if (isExpensiveCarTaxEnabled && vehicle.getListPrice() > 40000) {
            return calculateExpensiveCarTax(vehicle);
        }

        if (toggleCarsUnder40k) {
            if (vehicle.getDateOfFirstRegistration().isBefore(LocalDate.now().minusYears(2))) {
                return taxAfterSecondPaymentForCarsUnder40k(fuelType);
            }
        }

        if (vehicle.getFuelType() == PETROL) {
            return calculatePetrolTax(co2Emissions);
        } else if (vehicle.getFuelType() == DIESEL) {
            return calculateDieselTax(co2Emissions);
        } else {
            return calculateAlternativeTax(co2Emissions);
        }
    }

    private int calculateExpensiveCarTax(Vehicle vehicle) {
        FuelType fuelType = vehicle.getFuelType();

        if(fuelType.equals(PETROL) || fuelType.equals(DIESEL)) {
            return 450;
        }
        else if (fuelType.equals(ELECTRIC)) {
            return 310;
        }
        return 440;
    }


    private int taxAfterSecondPaymentForCarsUnder40k(tax.FuelType fuel) {
        if (fuel.equals(DIESEL) || fuel.equals(PETROL)) {
            return 140;
        } else if (fuel.equals(ALTERNATIVE_FUEL)) {
            return 130;
        } else {
            return 0;
        }
    }

    private int calculateDieselTax(Integer co2Emissions) {
        if (co2Emissions == 0)
            return 0;
        else if (co2Emissions <= 50)
            return 25;
        else if (co2Emissions <= 75)
            return 105;
        else if (co2Emissions <= 90)
            return 125;
        else if (co2Emissions <= 100)
            return 145;
        else if (co2Emissions <= 110)
            return 165;
        else if (co2Emissions <= 130)
            return 205;
        else if (co2Emissions <= 150)
            return 515;
        else if (co2Emissions <= 170)
            return 830;
        else if (co2Emissions <= 190)
            return 1240;
        else if (co2Emissions <= 225)
            return 1760;
        else if (co2Emissions <= 255)
            return 2070;
        else return 2070;
    }

    private int calculateAlternativeTax(Integer co2Emissions) {
        if (co2Emissions == 0)
            return 0;
        else if (co2Emissions >= 1 && co2Emissions <= 50)
            return 0;
        else if (co2Emissions >= 51 && co2Emissions <= 75)
            return 15;
        else if (co2Emissions >= 76 && co2Emissions <= 90)
            return 95;
        else if (co2Emissions >= 91 && co2Emissions <= 100)
            return 115;
        else if (co2Emissions >= 101 && co2Emissions <= 110)
            return 135;
        else if (co2Emissions >= 111 && co2Emissions <= 130)
            return 155;
        else if (co2Emissions >= 131 && co2Emissions <= 150)
            return 195;
        else if (co2Emissions >= 151 && co2Emissions <= 170)
            return 505;
        else if (co2Emissions >= 171 && co2Emissions <= 190)
            return 820;
        else if (co2Emissions >= 191 && co2Emissions <= 225)
            return 1230;
        else if (co2Emissions >= 226 && co2Emissions <= 255)
            return 1750;
        else return 2060;
    }

    private int calculatePetrolTax(Integer co2Emissions) {
        if (co2Emissions == 0)
            return 0;
        else if (co2Emissions >= 1 && co2Emissions <= 50)
            return 10;
        else if (co2Emissions >= 51 && co2Emissions <= 75)
            return 25;
        else if (co2Emissions >= 76 && co2Emissions <= 90)
            return 105;
        else if (co2Emissions >= 91 && co2Emissions <= 100)
            return 125;
        else if (co2Emissions >= 101 && co2Emissions <= 110)
            return 145;
        else if (co2Emissions >= 111 && co2Emissions <= 130)
            return 165;
        else if (co2Emissions >= 131 && co2Emissions <= 150)
            return 205;
        else if (co2Emissions >= 151 && co2Emissions <= 170)
            return 515;
        else if (co2Emissions >= 171 && co2Emissions <= 190)
            return 830;
        else if (co2Emissions >= 191 && co2Emissions <= 225)
            return 1240;
        else if (co2Emissions >= 226 && co2Emissions <= 255)
            return 1760;
        else return 2070;
    }
}

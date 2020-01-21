package tax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static tax.FuelType.*;

public class DefaultTaxCalculator extends TaxCalculator {

    Map<Integer, Integer> alternativeFuel = new TreeMap<>();

    public DefaultTaxCalculator() {
        alternativeFuel.put(255, 1750);
        alternativeFuel.put(225, 1230);
        alternativeFuel.put(190, 820);
        alternativeFuel.put(170, 505);
        alternativeFuel.put(150, 195);
        alternativeFuel.put(130, 155);
        alternativeFuel.put(110, 135);
        alternativeFuel.put(100, 115);
        alternativeFuel.put(90, 95);
        alternativeFuel.put(75, 15);
        alternativeFuel.put(74, 0);
    }


    public DefaultTaxCalculator(int year) {
        super(year);
    }

    @Override
    int calculateTax(Vehicle vehicle) {
        Integer co2Emissions = vehicle.getCo2Emissions();
        tax.FuelType fuelType = vehicle.getFuelType();

        if (vehicle.getListPrice() > 40000) {
            return calculateExpensiveCarTax(vehicle);
        }

        if (vehicle.getDateOfFirstRegistration().isBefore(LocalDate.now().minusYears(2))) {
            return taxAfterSecondPaymentForCarsUnder40k(fuelType);
        }

        if (vehicle.getFuelType() == PETROL || vehicle.getFuelType() == RED2COMPLIANTDIESEL) {
            return calculatePetrolTax(co2Emissions);
        } else if (vehicle.getFuelType() == DIESEL) {
            return calculateDieselTax(co2Emissions);
        } else {
            return calculateAlternativeTax(co2Emissions);
        }
    }

    private int calculateExpensiveCarTax(Vehicle vehicle) {
        FuelType fuelType = vehicle.getFuelType();

        if (fuelType.equals(PETROL) || fuelType.equals(DIESEL)) {
            return 450;
        } else if (fuelType.equals(ELECTRIC)) {
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
            return 110;
        else if (co2Emissions <= 90)
            return 130;
        else if (co2Emissions <= 100)
            return 150;
        else if (co2Emissions <= 110)
            return 170;
        else if (co2Emissions <= 130)
            return 210;
        else if (co2Emissions <= 150)
            return 530;
        else if (co2Emissions <= 170)
            return 855;
        else if (co2Emissions <= 190)
            return 1280;
        else if (co2Emissions <= 225)
            return 1815;
        else if (co2Emissions <= 255)
            return 2135;
        else return 2135;
    }

    private int calculateAlternativeTax(Integer co2Emissions) {

        for (Map.Entry<Integer, Integer> emissionsAndValues : alternativeFuel.entrySet()) {
            if (co2Emissions <= emissionsAndValues.getKey()) {
                return emissionsAndValues.getValue();
            }
        }
        return 2135;
    }

    private int calculatePetrolTax(Integer co2Emissions) {
        if (co2Emissions == 0)
            return 0;
        else if (co2Emissions >= 1 && co2Emissions <= 50)
            return 10;
        else if (co2Emissions >= 51 && co2Emissions <= 75)
            return 25;
        else if (co2Emissions >= 76 && co2Emissions <= 90)
            return 110;
        else if (co2Emissions >= 91 && co2Emissions <= 100)
            return 130;
        else if (co2Emissions >= 101 && co2Emissions <= 110)
            return 150;
        else if (co2Emissions >= 111 && co2Emissions <= 130)
            return 170;
        else if (co2Emissions >= 131 && co2Emissions <= 150)
            return 210;
        else if (co2Emissions >= 151 && co2Emissions <= 170)
            return 530;
        else if (co2Emissions >= 171 && co2Emissions <= 190)
            return 855;
        else if (co2Emissions >= 191 && co2Emissions <= 225)
            return 1280;
        else if (co2Emissions >= 226 && co2Emissions <= 255)
            return 1815;
        else return 2135;

    }
}

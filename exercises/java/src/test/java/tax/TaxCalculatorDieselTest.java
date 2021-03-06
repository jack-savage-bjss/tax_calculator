package tax;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.Month.JANUARY;
import static org.assertj.core.api.Assertions.assertThat;
import static tax.FuelType.DIESEL;


public class TaxCalculatorDieselTest {

    private static final LocalDate FIRST_OF_JAN_2019 = LocalDate.of(2019, JANUARY, 1);
    private TaxCalculator taxCalculator;

    @Before
    public void setUp(){
        taxCalculator = new DefaultTaxCalculator(2019);
    }

    @Test
    public void firstYearsTaxForDiesel_0_grams_co2() {
        Vehicle vehicle = new Vehicle(0, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(0);
    }

    @Test
    public void firstYearsTaxForDiesel_1_to_50_grams_co2() {
        Vehicle vehicle = new Vehicle(50, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(25);
    }

    @Test
    public void firstYearsTaxForDiesel_51_to_75_grams_co2() {
        Vehicle vehicle = new Vehicle(75, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(110);
    }

    @Test
    public void firstYearsTaxForDiesel_76_to_90_grams_co2() {
        Vehicle vehicle = new Vehicle(90, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(130);
    }

    @Test
    public void firstYearsTaxForDiesel_91_to_100_grams_co2() {
        Vehicle vehicle = new Vehicle(100, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(150);
    }

    @Test
    public void firstYearsTaxForDiesel_101_to_110_grams_co2() {
        Vehicle vehicle = new Vehicle(110, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(170);
    }

    @Test
    public void firstYearsTaxForDiesel_111_to_130_grams_co2() {
        Vehicle vehicle = new Vehicle(130, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(210);
    }

    @Test
    public void firstYearsTaxForDiesel_131_to_150_grams_co2() {
        Vehicle vehicle = new Vehicle(150, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(530);
    }

    @Test
    public void firstYearsTaxForDiesel_151_to_170_grams_co2() {
        Vehicle vehicle = new Vehicle(170, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(855);
    }

    @Test
    public void firstYearsTaxForDiesel_171_to_190_grams_co2() {
        Vehicle vehicle = new Vehicle(190, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(1280);
    }

    @Test
    public void firstYearsTaxForDiesel_191_to_225_grams_co2() {
        Vehicle vehicle = new Vehicle(225, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(1815);
    }

    @Test
    public void firstYearsTaxForDiesel_226_to_255_grams_co2() {
        Vehicle vehicle = new Vehicle(255, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(2135);
    }

    @Test
    public void firstYearsTaxForDiesel_over_to_255_grams_co2() {
        Vehicle vehicle = new Vehicle(256, DIESEL, FIRST_OF_JAN_2019, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(2135);
    }
}

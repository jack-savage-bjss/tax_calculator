package tax;

import java.util.Map;
import java.util.TreeMap;

public class DieselTaxBands {

    private final Map<Integer, Integer> dieselTaxBands;

    {
        dieselTaxBands = new TreeMap<>();
        dieselTaxBands.put(0,0);
        dieselTaxBands.put(50,25);
        dieselTaxBands.put(75,110);
        dieselTaxBands.put(90,130);
        dieselTaxBands.put(100,150);
        dieselTaxBands.put(110,170);
        dieselTaxBands.put(130,210);
        dieselTaxBands.put(150,530);
        dieselTaxBands.put(170,855);
        dieselTaxBands.put(190,1280);
        dieselTaxBands.put(225,1815);
        dieselTaxBands.put(255,2135);
        dieselTaxBands.put(Integer.MAX_VALUE,2135);
    }

    public Map<Integer, Integer> getDieselTaxBands() {
        return dieselTaxBands;
    }
}

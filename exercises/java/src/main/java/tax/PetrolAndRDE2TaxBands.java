package tax;

import java.util.Map;
import java.util.TreeMap;

public class PetrolAndRDE2TaxBands {
    private final Map<Integer, Integer> petrolAndRDE2TaxBands;

    {
        petrolAndRDE2TaxBands = new TreeMap<>();
        petrolAndRDE2TaxBands.put(0,0);
        petrolAndRDE2TaxBands.put(50,10);
        petrolAndRDE2TaxBands.put(75,25);
        petrolAndRDE2TaxBands.put(90,110);
        petrolAndRDE2TaxBands.put(100,130);
        petrolAndRDE2TaxBands.put(110,150);
        petrolAndRDE2TaxBands.put(130,170);
        petrolAndRDE2TaxBands.put(150,210);
        petrolAndRDE2TaxBands.put(170,530);
        petrolAndRDE2TaxBands.put(190,855);
        petrolAndRDE2TaxBands.put(225,1280);
        petrolAndRDE2TaxBands.put(255,1815);
        petrolAndRDE2TaxBands.put(Integer.MAX_VALUE,2135);
    }

    public Map<Integer, Integer> getPetrolAndRDE2TaxBands() {
        return petrolAndRDE2TaxBands;
    }
}

package lsp.park;

import net.sf.saxon.functions.Abs;

public interface StrategyParking {
    boolean parking(AbstractCar car);
    void remove(AbstractCar car);

}

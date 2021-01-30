package lsp;

import java.time.LocalDate;
import java.util.Calendar;

public class Fruit extends Food {

    public Fruit(String name, Calendar createDate, Calendar expireDate, int price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}

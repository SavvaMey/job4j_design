package lsp;

import java.time.LocalDate;
import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar createDate, Calendar expireDate, int price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}

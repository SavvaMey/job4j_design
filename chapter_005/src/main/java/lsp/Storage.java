package lsp;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public interface Storage {
        void add (Food food);
        boolean accept(Food food);
        List<Food> clear();

      default double percentageSpent (Food food) {
        long now =  Calendar.getInstance().getTimeInMillis();
        long expired = food.getExpireDate().getTimeInMillis();
        long created = food.getCreateDate().getTimeInMillis();
          return (double) (now - created) / (expired - created);
    }
}

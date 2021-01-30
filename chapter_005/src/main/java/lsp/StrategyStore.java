package lsp;

import java.util.Calendar;
import java.util.List;

public interface StrategyStore {
        void add (Food food);
        boolean control(Food food);

      default double percentageSpent (Food food) {
        long now =  Calendar.getInstance().getTimeInMillis();
        long expired = food.getExpireDate().getTimeInMillis();
        long created = food.getCreateDate().getTimeInMillis();
          return (double) (now - created) / (expired - created);
    }
}

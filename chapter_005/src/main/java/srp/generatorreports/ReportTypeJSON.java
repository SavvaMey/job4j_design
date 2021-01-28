package srp.generatorreports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportTypeJSON implements Report  {
    private Store store;

    public ReportTypeJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        final Gson gson = new GsonBuilder().create();
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(gson.toJson(employee));
        }
        return text.toString();
    }
}

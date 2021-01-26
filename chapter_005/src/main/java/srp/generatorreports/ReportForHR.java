package srp.generatorreports;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {
    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> listEm = store.findBy(filter);
        listEm.sort(new CompSalary().reversed());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : listEm) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

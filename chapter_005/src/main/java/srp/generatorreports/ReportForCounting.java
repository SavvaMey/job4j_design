package srp.generatorreports;

import java.util.function.Predicate;

public class ReportForCounting implements Report {
    private Store store;
    private Convert convert;

    public ReportForCounting(Store store, Convert convert) {
        this.store = store;
        this.convert = convert;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(String.format("%.3f",
                            convert.convert(employee.getSalary())))
                    .append("$;")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

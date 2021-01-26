package srp.generatorreports;

import java.util.function.Predicate;

public class ReportForIT implements Report {
    private Store store;

    public ReportForIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>")
                .append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title> Report </title>")
                .append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h1> Name; Hired; Fired; Salary; </h1>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("<br>")
                    .append(System.lineSeparator());
        }
        text.append("</body>")
                .append(System.lineSeparator())
                .append("</html>");
        return text.toString();
    }
}

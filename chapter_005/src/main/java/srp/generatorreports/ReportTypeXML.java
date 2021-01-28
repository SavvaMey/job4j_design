package srp.generatorreports;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportTypeXML implements Report {
    private Store store;

    public ReportTypeXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        text.append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>")
                .append("Name; Hired; Fired; Salary;")
                .append("<report>").append(System.lineSeparator())
                .append("<header>Name; Hired; Fired; Salary;</header>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<employee>")
                    .append("<name>")
                    .append(employee.getName())
                    .append("</name")
                    .append(System.lineSeparator())
                    .append("<hired>")
                    .append(employee.getHired())
                    .append("/hired")
                    .append(System.lineSeparator())
                    .append("<fired>")
                    .append(employee.getFired())
                    .append("</fired>")
                    .append(System.lineSeparator())
                    .append("<salary>")
                    .append(employee.getSalary())
                    .append("</salary>")
                    .append(System.lineSeparator())
                    .append("</employee>")
                    .append(System.lineSeparator());
        }
        text.append("/report");
        return text.toString();
    }
}

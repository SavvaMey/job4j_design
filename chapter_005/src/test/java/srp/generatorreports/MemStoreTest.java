package srp.generatorreports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenCountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForCounting(store, new ConvertToDollars());
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("1,429$").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee workerTwo = new Employee("Niko", now, now, 200);
        Employee workerThr = new Employee("Sas", now, now, 150);
        store.add(worker);
        store.add(workerTwo);
        store.add(workerThr);
        Report engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerTwo.getName()).append(";")
                .append(workerTwo.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerThr.getName()).append(";")
                .append(workerThr.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForITGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForIT(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<html>")
                .append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title> Report </title>")
                .append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h1> Name; Hired; Fired; Salary; </h1>")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("<br>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportTypeJSON(store);
        final Gson gson = new GsonBuilder().create();
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(gson.toJson(worker));
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportTypeXML(store);
        StringBuilder expect = new StringBuilder()
        .append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>")
                .append("Name; Hired; Fired; Salary;")
                .append("<report>").append(System.lineSeparator())
                .append("<header>Name; Hired; Fired; Salary;</header>")
                .append(System.lineSeparator())
                .append("<employee>")
                .append("<name>")
                .append(worker.getName())
                .append("</name")
                .append(System.lineSeparator())
                .append("<hired>")
                .append(worker.getHired())
                .append("/hired")
                .append(System.lineSeparator())
                .append("<fired>")
                .append(worker.getFired())
                .append("</fired>")
                .append(System.lineSeparator())
                .append("<salary>")
                .append(worker.getSalary())
                .append("</salary>")
                .append(System.lineSeparator())
                .append("</employee>")
                .append(System.lineSeparator())
                .append("/report");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}
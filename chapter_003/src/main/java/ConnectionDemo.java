import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<String> lines= load();
        Class.forName("org.postgresql.Driver");
        String url = lines.get(0);
        String login = lines.get(1);
        String password = lines.get(2);
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
    public static List<String> load() {
        String path = "./chapter_003/data/app.properties";
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            lines = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}

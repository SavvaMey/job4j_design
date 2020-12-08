import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class.forName("org.postgresql.Driver");
        String url = settings.getValue("jdbc.url");
        String login = settings.getValue("jdbc.login");
        String password = settings.getValue("jdbc.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    static class Settings {
        private final Properties prs = new Properties();

        public void load (InputStream io) {
            try {
                this.prs.load(io);
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
        public String getValue(String key) {
            return this.prs.getProperty(key);
        }
    }
}

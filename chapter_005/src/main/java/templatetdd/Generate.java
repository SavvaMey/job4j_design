package templatetdd;

import java.util.Map;

public interface Generate {
    String produce(String template, Map<String, String> args);
}

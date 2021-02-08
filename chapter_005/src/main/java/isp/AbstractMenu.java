package isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AbstractMenu {
    boolean add(String parent, String child);
    Optional<SimpleMenu.Node> findBy(String value);

}

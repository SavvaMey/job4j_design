package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> userMap = previous.stream().collect(Collectors.toMap(User::getId , User::getName));
        Info info = new Info(0,0,0);
        current.forEach(el -> {
            if (!userMap.containsKey(el.getId())) {
                info.added++;
            }
            if (Objects.equals(el.getName(), userMap.get(el.getId()))) {
                info.changed++;
            }
        });
        info.deleted = previous.size() + info.added - current.size();
        return info;

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added ;
        int changed ;
        int deleted ;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Info)) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }


    }
}

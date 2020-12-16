package ru.job4j.mail;

import java.util.*;
import java.util.function.Function;

public class UnionEmail {
    public static Map<String, Set<String>> merge(
            Map<String, Set<String>> users) {
        Map<String, String> userEmail = new HashMap<>();
        Map<String, Set<String>> result = new HashMap<>();

        for (Map.Entry<String, Set<String>> userEntry : users.entrySet()) {
            String tempUs = null;
            for (String email : userEntry.getValue()) {
                tempUs = userEmail.get(email);
                if (tempUs != null) {
                    break;
                }
            }
            if (tempUs == null) {
                result.put(userEntry.getKey(), userEntry.getValue());
            } else {
                result.get(tempUs).addAll(userEntry.getValue());
            }
            String user = tempUs == null ?  userEntry.getKey() : tempUs;
            users.get(userEntry.getKey())
                    .forEach(email -> userEmail.putIfAbsent(email, user));
        }
        return result;
    }
}

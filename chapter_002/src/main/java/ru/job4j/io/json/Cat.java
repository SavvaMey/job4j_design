package ru.job4j.io.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class Cat {
    private boolean sex;
    private int weight;
    private String name;
    private Contact ownerNumber;
    private String[] features;

    public String getName() {
        return name;
    }

    public Contact getOwnerNumber() {
        return ownerNumber;
    }

    public String[] getFeatures() {
        return features;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isSex() {
        return sex;
    }

    public Cat(boolean sex, int weight, String name, Contact ownerNumber, String... features) {
        this.sex = sex;
        this.weight = weight;
        this.name = name;
        this.ownerNumber = ownerNumber;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sex=" + sex +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", ownerNumber=" + ownerNumber +
                ", features=" + Arrays.toString(features) +
                '}';
    }

    public static void main(String[] args) {
        final Cat cat = new Cat(false, 30, "solo", new Contact("11-111"),
                "white", "fluffy");

//        /* Преобразуем объект cat в json-строку. */
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(cat));
//
//        /* Модифицируем json-строку */
//        final String catJson =
//                "{"
//                        + "\"sex\":false,"
//                        + "\"weight\":10,"
//                        + "\"name\":solo,"
//                        + "\"ownerNumber\":"
//                        + "{"
//                        + "\"phone\":\"+7(924)111-111-11-11\""
//                        + "},"
//                        + "\"features\":"
//                        + "[\"black\",\"bald\"]"
//                        + "}";
//        final Cat catMod = gson.fromJson(catJson, Cat.class);
//        System.out.println(catMod);

        JSONObject jsonOwner = new JSONObject("{\"phone\":" + cat.getOwnerNumber().getPhone() + "}");
        JSONObject json = new JSONObject();
        json.put("sex", cat.isSex());
        json.put("weight", cat.getWeight());
        json.put("name", cat.getName());
        json.put("ownerNumber", jsonOwner);
        json.put("features", new JSONArray(cat.getFeatures()));
        System.out.println(json.toString());
        System.out.println(new JSONObject(cat).toString());
    }
}

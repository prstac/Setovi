package Polaznik;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapRegistar<T> implements Registar<T>{
    Map<String, T> data;
    String sortFieldName;

    public MapRegistar(Map<String, T> data, String sortFieldName) {
        this.sortFieldName = sortFieldName;
        this.data = data;
    }

    public void add(T element) {
        try {

            String value = (String)element.getClass().getMethod(sortFieldName).invoke(element);
            data.put(value ,element);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printAllElements() {
        data.forEach((k, v) -> System.out.println(v));
    }

    public void printAllElementsRandom() {
        List<T> values = new ArrayList<>(data.values());
        Collections.shuffle(values);
        values.forEach(System.out::println);
    }

    public boolean elementExists(T element) {
        String value = "";
        try {
            value = (String)element.getClass().getMethod(sortFieldName).invoke(element);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data.containsKey(value);
    }

    public String getDataClassName() {
        return data.getClass().getSimpleName();
    }
}

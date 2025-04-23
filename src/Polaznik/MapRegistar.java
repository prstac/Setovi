package Polaznik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapRegistar implements Registar<Polaznik>{
    Map<String, Polaznik> data;

    public MapRegistar(Map<String, Polaznik> data) {
        this.data = data;
    }

    public void add(Polaznik element) {
        data.put(element.Email,element);
    }

    @Override
    public void printAllElements() {
        data.forEach((k, v) -> System.out.println(v));
    }

    public void printAllElementsRandom() {
        List<Polaznik> values = new ArrayList<Polaznik>(data.values());
        Collections.shuffle(values);
        values.forEach(System.out::println);
    }

    public boolean elementExists(Polaznik p) {
        return data.containsKey(p.Email);
    }

    public String getDataClassName() {
        return data.getClass().getSimpleName();
    }
}

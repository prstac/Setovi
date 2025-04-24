package Polaznik;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SetRegistar<T> implements Registar<T>{
    Set<T> data;

    public SetRegistar(Set<T> data) {
        this.data = data;
    }

    public void add(T element) {
        data.add(element);
    }

    public void printAllElements() {
        data.forEach(System.out::println);
    }

    public void printAllElementsRandom() {
        List<T> values = new ArrayList<T>(data);
        Collections.shuffle(values);
        values.forEach(System.out::println);
    }

    public boolean elementExists(T p) {
        return data.contains(p);
    }

    @Override
    public String getDataClassName() {
        return data.getClass().getSimpleName();
    }
}

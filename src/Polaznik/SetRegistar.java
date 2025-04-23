package Polaznik;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SetRegistar implements Registar<Polaznik>{
    Set<Polaznik> data;

    public SetRegistar(Set<Polaznik> data) {
        this.data = data;
    }

    public void add(Polaznik element) {
        data.add(element);
    }

    public void printAllElements() {
        data.forEach(p -> System.out.println(p));
    }

    public void printAllElementsRandom() {
        List<Polaznik> values = new ArrayList<Polaznik>(data);
        Collections.shuffle(values);
        values.forEach(System.out::println);
    }

    public boolean elementExists(Polaznik p) {
        return data.contains(p);
    }
}

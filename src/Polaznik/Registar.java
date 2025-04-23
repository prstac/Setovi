package Polaznik;

public interface Registar<T> {
    void add(T e);

    void printAllElements();
    void printAllElementsRandom();
    boolean elementExists(T e);
    String getDataClassName();

}

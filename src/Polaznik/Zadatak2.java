package Polaznik;
import java.util.*;

public class Zadatak2 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashSet<Polaznik> polazniciHashSet = new HashSet<>();
        TreeSet<Polaznik> polazniciTreeSet = new TreeSet<>();

        mainLoop(polazniciHashSet, "Unos hash set");
        mainLoop(polazniciTreeSet, "Unos tree set");

        scanner.close();
        System.out.println("Kraj.");
    }

    public static void mainLoop(Set<Polaznik> polaznici, String unosText) {
        System.out.println(unosText);
        do {
            tryUnos(polaznici);
            System.out.println("Nastaviti D?");
        } while (scanner.nextLine().equalsIgnoreCase("d"));
        System.out.println();
    }

    public static void tryUnos(Set<Polaznik> polaznici) {
        try {
            unosPolaznika(polaznici);
            ispisiPolaznike(polaznici);
        } catch (Exception e) {
            System.out.println("Greska, probajte ponovno");
        }
    }

    public static  void unosPolaznika(Set<Polaznik> polaznici) {
        System.out.println("Unesite polaznika (Ime Prezime Email):");

        Polaznik polaznik = getPolaznikFromLine(scanner.nextLine());

        if (polaznici.contains(polaznik)) {
            System.out.println("Korisnik vec postoji");
            return;
        }

        polaznici.add(polaznik);
    }

    public static Polaznik getPolaznikFromLine(String linija) {
        List<String> linijaList = Arrays.stream(linija.split(" ")).toList();

        String ime = linijaList.get(0);
        String prezime = linijaList.get(1);
        String email = linijaList.get(2);

        return new Polaznik(ime,prezime,email);
    }


    public static void ispisiPolaznike(Set<Polaznik> polaznici) {
        System.out.println("Polaznici su:");
        polaznici.forEach(System.out::println);
    }

}
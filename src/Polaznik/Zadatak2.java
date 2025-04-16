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
        while (true) {
            try {
                unosPolaznika(polaznici);
                ispisiPolaznike(polaznici);
            } catch (Exception e) {
                System.out.println("Greska, probajte ponovno");
            }
            System.out.println("Nastaviti D?");
            if (!scanner.nextLine().equals("D")) break;
        }
        System.out.println();
    }

    public static  void unosPolaznika(Set<Polaznik> polaznici) {
        System.out.println("Unesite polaznika (Ime Prezime Email):");
        String linija = scanner.nextLine();
        List<String> linijaList = Arrays.stream(linija.split(" ")).toList();
        String ime = linijaList.get(0);
        String prezime = linijaList.get(1);
        String email = linijaList.get(2);
        Polaznik p = new Polaznik(ime, prezime, email);

        if (polaznici.contains(p)) {
            System.out.println("Korisnik vec postoji");
            return;
        }

        polaznici.add(p);
    }


    public static void ispisiPolaznike(Set<Polaznik> polaznici) {
        polaznici.forEach(p-> System.out.println(p));
    }

}
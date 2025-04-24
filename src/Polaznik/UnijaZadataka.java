package Polaznik;

import java.util.*;

public class UnijaZadataka {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Registar<Polaznik>> polaznikRegistri = Arrays.asList(
                new SetRegistar<Polaznik>(new HashSet<>()),
                new SetRegistar<Polaznik>(new TreeSet<>()),
                new MapRegistar<Polaznik>(new HashMap <> (), "getEmail"),
                new MapRegistar<Polaznik>(new TreeMap <> (), "getEmail")
        );

        mainLoop(polaznikRegistri);

        scanner.close();
        System.out.println("Kraj.");
    }

    public static void printIzbornik(List<Registar<Polaznik>> registri) {
        for (int i = 1; i <= registri.size() ; i++) {
            System.out.println(i + " za "+ registri.get(i-1).getDataClassName());
        }
        System.out.println("0 za prekid");
    }

    public static int izbor() {
        var izbor = scanner.nextInt();
        scanner.nextLine();
        return izbor;
    }

    public static void mainLoop(List<Registar<Polaznik>> registriPolaznika) {
        var izbor = 1;
        do {
            printIzbornik(registriPolaznika);
            izbor = izbor();
            var polaznici = registriPolaznika.get(0);
            if (izbor > 0) {
                polaznici = registriPolaznika.get(izbor - 1);
                System.out.println("unos "+ polaznici.getDataClassName() + " polaznika, q za prekid");
            } else break;
            do {} while (tryUnos(polaznici));
            System.out.println("Nastaviti s novim izborom, D?");
        } while (scanner.nextLine().equalsIgnoreCase("D"));
        System.out.println();
    }

    public static boolean tryUnos(Registar<Polaznik> polaznici) {
        var nastavi = false;
        try {
            nastavi = unosPolaznika(polaznici);
            if (!nastavi) return nastavi;
            ispisiPolaznike(polaznici);
            ispisiPolaznikeNasumicno(polaznici);
        } catch (Exception e) {
            System.out.println("Greska, probajte ponovno");
        }
        return nastavi;
    }

    public static boolean unosPolaznika(Registar<Polaznik> registarPolaznika) {
        System.out.println("Unesite polaznika (Ime Prezime Email):");
        var line = scanner.nextLine();

        if (line.equalsIgnoreCase("q")) return false;
        Polaznik polaznik = getPolaznikFromLine(line);


        if (registarPolaznika.elementExists(polaznik)) {
            System.out.println("Korisnik vec postoji");
            return true;
        }

        registarPolaznika.add(polaznik);
        return true;
    }

    public static Polaznik getPolaznikFromLine(String linija) {
        List<String> linijaList = Arrays.stream(linija.split(" ")).toList();

        String ime = linijaList.get(0);
        String prezime = linijaList.get(1);
        String email = linijaList.get(2);

        return new Polaznik(ime,prezime,email);
    }


    public static void ispisiPolaznike(Registar<Polaznik> polaznici) {
        System.out.println("Polaznici su:");
        polaznici.printAllElements();
    }

    public static void ispisiPolaznikeNasumicno(Registar<Polaznik> polaznici) {
        System.out.println("Polaznici nasumicno su:");
        polaznici.printAllElementsRandom();
    }

}
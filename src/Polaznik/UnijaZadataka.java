package Polaznik;

import java.util.*;

public class UnijaZadataka {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Registar<Polaznik>> polaznikRegistri = Arrays.asList(
                new SetRegistar(new HashSet<Polaznik>()),
                new SetRegistar(new TreeSet<Polaznik>()),
                new MapRegistar(new HashMap < String, Polaznik > ()),
                new MapRegistar(new TreeMap < String, Polaznik > ())
        );

        mainLoop(polaznikRegistri);

        scanner.close();
        System.out.println("Kraj.");
    }

    public static void printIzbornik(List<Registar<Polaznik>> registri) {
        for (int i = 1; i <= registri.size() ; i++) {
            System.out.println(i + " za "+ registri.get(i-1).getDataClassName());
        }
    }

    public static void mainLoop(List<Registar<Polaznik>> registriPolaznika) {

        printIzbornik(registriPolaznika);

        var izbor = scanner.nextInt();
        scanner.nextLine();

        var polaznici = registriPolaznika.get(izbor - 1);


        System.out.println("unos "+polaznici.getDataClassName() + " polaznika");
        do {
            tryUnos(polaznici);
            System.out.println("Nastaviti D?");
        } while (scanner.nextLine().equalsIgnoreCase("d"));
        System.out.println();
    }

    public static void tryUnos(Registar<Polaznik> polaznici) {
        try {
            unosPolaznika(polaznici);
            ispisiPolaznike(polaznici);
            ispisiPolaznikeNasumicno(polaznici);
        } catch (Exception e) {
            System.out.println("Greska, probajte ponovno");
        }
    }

    public static  void unosPolaznika(Registar<Polaznik> registarPolaznika) {
        System.out.println("Unesite polaznika (Ime Prezime Email):");

        Polaznik polaznik = getPolaznikFromLine(scanner.nextLine());

        if (registarPolaznika.elementExists(polaznik)) {
            System.out.println("Korisnik vec postoji");
            return;
        }

        registarPolaznika.add(polaznik);
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
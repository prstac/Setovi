import Polaznik.Polaznik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Polaznik> polaznici = new ArrayList<>();
        while (true) {
            System.out.println();
            System.out.println("Za unos polaznika birajte 1");
            System.out.println("Za ispis polaznika birajte 2");
            System.out.println("Za biranje polaznika po adresi birajte 3");
            System.out.println("Za prekid birajte 0");

            try {

                int odabir = Integer.parseInt(scanner.nextLine());

                if (odabir == 0) break;

                switch (odabir) {
                    case 1: {
                        unosPolaznika(polaznici);
                        break;
                    }
                    case 2: {
                        ispisiPolaznike(polaznici);
                        break;
                    }
                    case 3: {
                        var p = dohvatiPolaznikaPoEmailu(polaznici);
                        System.out.println("Odabrali ste :\n" + p);
                        break;
                    }
                    default: {
                        System.out.println("Krivi odabir");
                    }
                }
            } catch (Exception e) {
                System.out.println("Greska, probajte ponovno");
            }
        }
        scanner.close();
        System.out.println("Kraj.");
    }

    public static Polaznik dohvatiPolaznikaPoEmailu(List<Polaznik> polaznici) {
        System.out.println("Unesite email polaznika kojeg zelite dohvatiti");
        String email = scanner.nextLine();
        return polaznici.stream().filter(p-> p.getEmail().equals(email)).findFirst().get();
    }

    public static  void unosPolaznika(List<Polaznik> polaznici) {
        System.out.println("Unesite polaznika (Ime Prezime Email):");
        String linija = scanner.nextLine();
        List<String> linijaList = Arrays.stream(linija.split(" ")).toList();
        String ime = linijaList.get(0);
        String prezime = linijaList.get(1);
        String email = linijaList.get(2);
        Polaznik polaznik = new Polaznik(ime, prezime, email);
        polaznici.add(polaznik);
    }

    public static void ispisiPolaznike(List<Polaznik> polaznici) {
        polaznici.forEach(p-> System.out.println(p.getIme()));
    }

}
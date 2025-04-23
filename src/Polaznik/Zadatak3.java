package Polaznik;


import java.util.*;

    public class Zadatak3 {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            HashMap<String, Polaznik> polaznici = new HashMap<>();
            TreeMap<String, Polaznik> polazniciTree = new TreeMap<>();

            mainLoop(polaznici);
            mainLoop(polazniciTree);

            scanner.close();
            System.out.println("Kraj.");
        }

        public static void mainLoop(Map<String, Polaznik> polaznici) {
            System.out.println("unos " + polaznici.getClass().getSimpleName() + " polaznika");
            do {
                tryUnos(polaznici);
                System.out.println("Nastaviti D?");
            } while (scanner.nextLine().equalsIgnoreCase("d"));
            System.out.println();
        }

        public static void tryUnos(Map<String, Polaznik> polaznici) {
            try {
                unosPolaznika(polaznici);
                ispisiPolaznike(polaznici);
            } catch (Exception e) {
                System.out.println("Greska, probajte ponovno");
            }
        }

        public static void unosPolaznika(Map<String, Polaznik> polaznici) {
            System.out.println("Unesite polaznika (Ime Prezime Email):");

            Polaznik polaznik = getPolaznikFromLine(scanner.nextLine());
            if (polaznici.get(polaznik.Email) != null) {
                System.out.println("Korisnik vec postoji");
                return;
            }

            polaznici.put(polaznik.Email, polaznik);
        }

        public static Polaznik getPolaznikFromLine(String linija) {
            List<String> linijaList = Arrays.stream(linija.split(" ")).toList();

            String ime = linijaList.get(0);
            String prezime = linijaList.get(1);
            String email = linijaList.get(2);

            return new Polaznik(ime, prezime, email);
        }


        public static void ispisiPolaznike(Map<String, Polaznik> polaznici) {
            System.out.println("Polaznici su:");
            polaznici.forEach((k, v) -> System.out.println(v));
        }
    }

package Polaznik;

public class Polaznik implements Comparable<Polaznik> {
    String Ime;
    String Prezime;
    String Email;

    public Polaznik(String ime, String prezime, String email) {
        Ime = ime;
        Prezime = prezime;
        Email = email;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return Ime+' '+Prezime+' '+Email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik polaznik = (Polaznik) o;
        return getEmail().equals(polaznik.getEmail());
    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }

    @Override
    public int compareTo(Polaznik o) {
        return this.Prezime.compareTo(o.Prezime);
    }
}

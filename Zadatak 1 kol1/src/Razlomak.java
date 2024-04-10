public class Razlomak {
    private int brojnik;
    private int nazivnik;

    public Razlomak(int brojnik, int nazivnik) {
        if (nazivnik == 0) {
            throw new IllegalArgumentException("Nazivnik ne može biti nula");
        }
        this.brojnik = brojnik;
        this.nazivnik = nazivnik;
    }

    public int getBrojnik() {
        return brojnik;
    }
    public int getNazivnik() {
        return nazivnik;
    }

    // Metoda za zbrajanje razlomaka
    public Razlomak zbroji(Razlomak r) {
        int brojnik = this.brojnik * r.getNazivnik() + r.getBrojnik() * this.nazivnik;
        int nazivnik = this.nazivnik * r.getNazivnik();
        return new Razlomak(brojnik, nazivnik).pokratiRazlomak();
    }

    // Metoda za oduzimanje razlomaka
    public Razlomak oduzmi(Razlomak r) {
        int brojnik = this.brojnik * r.getNazivnik() - r.getBrojnik() * this.nazivnik;
        int nazivnik = this.nazivnik * r.getNazivnik();
        return new Razlomak(brojnik, nazivnik).pokratiRazlomak();
    }

    // Metoda za množenje razlomaka
    public Razlomak pomnozi(Razlomak r) {
        int brojnik = this.brojnik * r.getBrojnik();
        int nazivnik = this.nazivnik * r.getNazivnik();
        return new Razlomak(brojnik, nazivnik).pokratiRazlomak();
    }

    // Metoda za dijeljenje razlomaka
    public Razlomak podijeli(Razlomak r) {
        if (r.getBrojnik() == 0) {
            throw new IllegalArgumentException("Dijeljenje s nulom nije definirano");
        }
        int brojnik = this.brojnik * r.getNazivnik();
        int nazivnik = this.nazivnik * r.getBrojnik();
        return new Razlomak(brojnik, nazivnik).pokratiRazlomak();
    }

    // Metoda za skraćivanje razlomka
    public Razlomak pokratiRazlomak() {
        int zajedBr = zajednickiDjelitelj(brojnik, nazivnik);
        return new Razlomak(brojnik / zajedBr, nazivnik / zajedBr);
    }

    // Metoda za pronalaženje najvećeg zajedničkog nazivnika
    private int zajednickiDjelitelj(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return zajednickiDjelitelj(b, a % b);
        }
    }
    @Override
    public String toString() {
        return brojnik + "/" + nazivnik;
    }

}

package pkg;

class Znamka {

    private final String nazevPredmetu;
    private final int hodnota;
    private final int kredity;

    public Znamka(String nazevPredmetu, int hodnota, int kredity) {
        this.nazevPredmetu = nazevPredmetu;
        this.hodnota = hodnota;
        this.kredity = kredity;
    }

    @Override
    public String toString() {
        return this.nazevPredmetu + " - Znamka: " + this.hodnota + ", Kredity: " + this.kredity;
    }

    public String getNazevPredmetu() {
        return nazevPredmetu;
    }

    public int getHodnota() {
        return hodnota;
    }

    public int getKredity() {
        return kredity;
    }
}

class SeznamZnamek {

    private Znamka[] znamky;

    public SeznamZnamek() { this.znamky = new Znamka[0]; }
    public SeznamZnamek (Znamka[] znamky) { this.znamky = znamky; }

    public void pridejZnamku(Znamka znamka) {
        Znamka[] tempArr = new Znamka[this.znamky.length + 1];
        for (int i = 0; i < this.znamky.length; i++) tempArr[i] = this.znamky[i];
        tempArr[this.znamky.length] = znamka;
        this.znamky = tempArr;
        System.out.println("Byla přidána známka: " + znamka);
    }

    public double suma() {
        double suma = 0;
        for (Znamka znamka : this.znamky) suma += znamka.getHodnota();
        return suma;
    }

    public double spocitejPrumerZnamek() {
        return suma() / this.znamky.length;
    }

    public Znamka najdiNejhorsiZnamku() {
        Znamka pom;
        for (int i = 0; i > this.znamky.length - 1; i++) {
            if (this.znamky[i].getHodnota() > this.znamky[i + 1].getHodnota()) {
                pom = this.znamky[i];
                this.znamky[i] = this.znamky[i + 1];
                this.znamky[i + 1] = pom;
            }
        }
        return this.znamky[this.znamky.length - 1];
    }

    public double spocitejVazenyPrumer() {
        double a = 0, b = 0;
        for (Znamka znamka : this.znamky) {
            a += (znamka.getHodnota() * znamka.getKredity());
            b += znamka.getKredity();
        }
        return a / b;
    }

    public void vypisZnamky() {
        System.out.println("Počet známek: " + this.znamky.length);
        for (Znamka znamka : this.znamky) System.out.println(znamka);
    }

}

public class Main {

    private Main() {
        Znamka[] znamky = {
                new Znamka("BZAPR", 4, 7),
                new Znamka("BMAT1", 1, 6),
                new Znamka("BZALG", 2, 5),
                new Znamka("BSWIN", 3, 6),
                new Znamka("BINFZ", 5, 3)
        };
        SeznamZnamek seznam1 = new SeznamZnamek();
        seznam1.vypisZnamky();
        seznam1.pridejZnamku(znamky[0]);
        seznam1.vypisZnamky();
        System.out.println("-------");
        SeznamZnamek seznam2 = new SeznamZnamek(znamky);
        seznam2.vypisZnamky();
        System.out.println("Nejhorsi známka: " + seznam2.najdiNejhorsiZnamku());
        System.out.println("Prumer znamek: " + seznam2.spocitejPrumerZnamek());
        System.out.println("Vazeny prumer znamek: " + seznam2.spocitejVazenyPrumer());
        seznam2.pridejZnamku(new Znamka("BPALP", 5, 5));
        seznam2.vypisZnamky();
    }

    public static void main(String[] args) {
        new Main();
    }

}
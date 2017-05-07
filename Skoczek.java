
import java.awt.Point;

/**
 *
 * @author KrzysieK
 */
class Skoczek {

    private final boolean[][] plansza;
    private final int[][] rozwiazanie;
    private int licznik, iteracja;
    private final int iloscMiejscNaPlanszy;
    private final Point[] ruchSkoczka;

    public Skoczek(int wiersz, int kolumna) {
        this.ruchSkoczka = new Point[]{
            new Point(-2, -1),
            new Point(-2, 1),
            new Point(2, -1),
            new Point(2, 1),
            new Point(-1, -2),
            new Point(-1, 2),
            new Point(1, -2),
            new Point(1, 2)
        };
        this.plansza = new boolean[wiersz][kolumna];
        this.rozwiazanie = new int[wiersz][kolumna];
        this.iloscMiejscNaPlanszy = wiersz * kolumna;
        this.licznik = 0;
        this.iteracja = 0;
    }

    public boolean wykonajRuch(int wiersz, int kolumna, Boolean pokazKrokiObliczania) {

        plansza[wiersz][kolumna] = true;
        licznik++;
        iteracja++;
        rozwiazanie[wiersz][kolumna] = licznik;

        if (licznik == iloscMiejscNaPlanszy) {
            return true;
        }
        if (pokazKrokiObliczania) {
            wydrukujPlansze();
        }
        for (Point ruch : ruchSkoczka) {

            int nastepnyWiersz = wiersz + ruch.x;
            int nastepnaKolumna = kolumna + ruch.y;

            if (nastepnyWiersz < 0 || nastepnyWiersz >= plansza.length) {
                continue;
            } else if (nastepnaKolumna < 0 || nastepnaKolumna >= plansza.length) {
                continue;
            } else if (plansza[nastepnyWiersz][nastepnaKolumna]) {
                continue;
            }
            if (wykonajRuch(nastepnyWiersz, nastepnaKolumna, pokazKrokiObliczania)) {
                return true;
            }
        }

        plansza[wiersz][kolumna] = false;
        licznik--;
        return false;
    }

    private void wydrukujPlansze() {
        System.out.println("iteracja nr: " + iteracja + ".\nIlość wykonanych ruchów przez skoczka: " + licznik + "\n");
        if (licznik == 1) {
            System.out.println("Tablica potwierdzająca, że skoczek odwiedził " + licznik + " pole:");
        } else if (licznik > 1 && licznik < 5) {
            System.out.println("Tablica potwierdzająca, że skoczek odwiedził " + licznik + " pola:");
        } else {
            System.out.println("Tablica potwierdzająca, że skoczek odwiedził " + licznik + " pól:");
        }

        for (boolean[] wiersz : plansza) {
            for (boolean element : wiersz) {
                System.out.print((element) ? "T " : "F ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void wydrukujRozwiazanie(int rozmiar, int[][] tablica) {
        String[] wiersz = new String[2 * rozmiar + 1];

        String ramka = "";
        for (int i = 0; i < rozmiar; i++) {
            ramka += "+----";
        }
        ramka += "+";

        for (int i = 0; i < 2 * rozmiar + 1; i += 2) {
            wiersz[i] = ramka;
        }

        for (int i = 0; i < rozmiar; i++) {
            String wypelnienie = "| ";
            for (int j = 0; j < rozmiar; j++) {
                wypelnienie += Integer.toString(tablica[i][j]);
                if (tablica[i][j] < 10) {
                    wypelnienie += "  | ";
                } else {
                    wypelnienie += " | ";
                }
            }
            if (2 * i + 1 < 2 * rozmiar + 1) {
                wiersz[2 * i + 1] = wypelnienie;
            }

        }
        for (int i = 0; i < 2 * rozmiar + 1; i++) {
            System.out.println(wiersz[i]);
        }
    }

    public static void main(String[] args) {
        int rozmiarTablicy = 6;
        Boolean pokazKrokiObliczania = false;
        
        Skoczek skoczek = new Skoczek(rozmiarTablicy, rozmiarTablicy);
        if (skoczek.wykonajRuch(0, 0, pokazKrokiObliczania)) {
            skoczek.wydrukujPlansze();
            System.out.println("Rozwiąznie pokazujące kolejne ruchy skoczka na planszy: ");
            skoczek.wydrukujRozwiazanie(rozmiarTablicy, skoczek.rozwiazanie);
        } else {
            System.out.println("Brak rozwiązania.");
        }
    }

}

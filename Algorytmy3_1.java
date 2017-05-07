package zadania;

import java.util.Scanner;

enum Kierunek {
    LEWO(0),
    PRAWO(1);
    int wartosc;

    Kierunek(int i) {
        wartosc = i;
    }

}

public class Algorytmy3_1 {

    public static void main(String[] args) {
        System.out.println("Podaj ilość elementów: ");
        Scanner czytaj = new Scanner(System.in);
        int n = czytaj.nextInt();
        Algorytmy3_1 klasa = new Algorytmy3_1();
        klasa.wylicz(n);
    }

    void wylicz(int n) {
        int[] dane = stworzTablice(n, 1);
        int[] kierunek = stworzTablice(n);
        System.out.println("Twój ciąg liczb to:");
        wydrukuj(dane);
        System.out.println("permutacje danych:");
        dane = sortujTablice(dane);
        wydrukuj(dane);
        while (czyDalej(dane, kierunek)) {
            int aktualnaMobilna = znajdzMinMobilna(dane, kierunek);
            int przesunPozycje = aktualnaMobilna + (kierunek[aktualnaMobilna] == Kierunek.LEWO.wartosc ? -1 : 1);
            int temp;
            temp = dane[przesunPozycje];
            dane[przesunPozycje] = dane[aktualnaMobilna];
            dane[aktualnaMobilna] = temp;

            temp = kierunek[przesunPozycje];
            kierunek[przesunPozycje] = kierunek[aktualnaMobilna];
            kierunek[aktualnaMobilna] = temp;

            for (int i = 0; i < n; i++) {
                if (dane[i] < dane[przesunPozycje]) {
                    kierunek[i] = kierunek[i] == Kierunek.LEWO.wartosc ? Kierunek.PRAWO.wartosc : Kierunek.LEWO.wartosc;
                }
            }

            wydrukuj(dane);
            wydrukuj(kierunek);
        }
    }

    int[] stworzTablice(int n, int k) {
        int[] tablica = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            tablica[i] = n - i;
        }
        return tablica;
    }

    int[] stworzTablice(int n) {
        int[] tablica = new int[n];
        for (int i = 0; i < n; i++) {
            tablica[i] = Kierunek.PRAWO.wartosc;
        }
        return tablica;
    }

    int[] sortujTablice(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp;
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    void wydrukuj(int[] tabilca) {
        for (int liczba : tabilca) {
            System.out.print(liczba + " ");
        }
        System.out.println();
    }

    boolean czyDalej(int[] tablicaRobocza, int[] kierunkowa) {
        for (int i = 0, n = tablicaRobocza.length; i < n; i++) {
            if (jestMobilna(tablicaRobocza, kierunkowa, i)) {
                return true;
            }
        }
        return false;
    }

    boolean jestMobilna(int[] tablicaRobocza, int[] tablicaKierunkowa, int i) {
        // leftmost integer pointing to the left is not mobile
        // rightmost integer pointing to the right is not mobile
        if ((i == 0 && tablicaKierunkowa[i] == Kierunek.LEWO.wartosc)
                || (i == tablicaRobocza.length - 1 && tablicaKierunkowa[i] == Kierunek.PRAWO.wartosc)) {
            return false;
        }
        // An integer is mobile if, in the direction of its mobility, the
        // nearest integer is less than the current integer.
        if (i > 0 && tablicaKierunkowa[i] == Kierunek.LEWO.wartosc
                && tablicaRobocza[i] < tablicaRobocza[i - 1]) {
            return true;
        }
        if (i < tablicaRobocza.length - 1
                && tablicaKierunkowa[i] == Kierunek.PRAWO.wartosc
                && tablicaRobocza[i] < tablicaRobocza[i + 1]) {
            return true;
        }
        if (i > 0 && i < tablicaRobocza.length) {
            if ((tablicaKierunkowa[i] == Kierunek.LEWO.wartosc
                    && tablicaRobocza[i] < tablicaRobocza[i - 1])
                    || (tablicaKierunkowa[i] == Kierunek.PRAWO.wartosc
                    && tablicaRobocza[i] < tablicaRobocza[i + 1])) {
                return true;
            }
        }
        return false;
    }

    int znajdzMaxMobilna(int[] tablicaRobocza, int[] tablicaKierunkowa) {
        int najwieksza = -1;
        int pozycja = -1;
        for (int i = 0; i < tablicaRobocza.length; i++) {
            if (jestMobilna(tablicaRobocza, tablicaKierunkowa, i) && najwieksza < tablicaRobocza[i]) {
                najwieksza = tablicaRobocza[i];
                pozycja = i;
            }
        }
        return pozycja;
    }

    int znajdzMinMobilna(int[] tablicaRobocza, int[] tablicaKierunkowa) {
        int najmniejsza = tablicaRobocza[0];
        int pozycja = 0;
        for (int i = 0; i<tablicaRobocza.length; i++){
            if(jestMobilna(tablicaRobocza, tablicaKierunkowa, i) && najmniejsza > tablicaRobocza[i]){
                najmniejsza = tablicaRobocza[i];
                pozycja = i;
            }
        }

        System.out.println("minimalna mobilna to: " + najmniejsza + " na pozycj5i " + pozycja);
        return pozycja;
    }
}

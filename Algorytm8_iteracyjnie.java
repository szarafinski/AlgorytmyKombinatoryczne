
/**
 *
 * @author KrzysieK
 */
import java.util.Arrays;
import java.util.Scanner;

public class Algorytm8_iteracyjnie {

    public static void main(String[] args) {
        System.out.println("Wybierz co chcesz zrobić:\n"
                + "[1] wygeneruj losowy ciąg liczb\n"
                + "[2] wprowadź swoje liczby");
        System.out.print("Twój wybór to: ");
        int wybor = wczytajLiczbe("Podj liczbę 1 lub 2: ");
        switch (wybor) {
            case 1: {
                System.out.print("Podaj długość ciągu liczb. ");
                int dlugosc = wczytajDodatniaLiczbe("Liczba powinna być dodania. ");
                int[] tablica = generujTablice(dlugosc);
                int[] tablicaIndksow = generujTabliceIndeksow(dlugosc + 1);
                System.out.println("Podany ciąg to: ");
                wypisz(tablica);
                System.out.println("Pertmutacje ciągu:");
                wypisz(tablica);
                wykonajPermutacje2(tablica, tablicaIndksow);
                break;
            }
            case 2: {
                System.out.print("Podaj długość ciągu liczb. ");
                int dlugosc = wczytajDodatniaLiczbe("Liczba powinna być dodania. ");
                int[] tablica = generujTabliceUzytkownika(dlugosc);
                int[] tablicaIndksow = generujTabliceIndeksow(dlugosc + 1);
                System.out.println("Podany ciąg to: ");
                wypisz(tablica);
                System.out.println("Pertmutacje ciągu:");
                sortujTablice(tablica);
                wypisz(tablica);
                wykonajPermutacje2(tablica, tablicaIndksow);
                break;
            }
            default: {
                System.out.println("Błędny wybór");
                break;
            }
        }
    }

    static int wczytajLiczbe(String wiadomosc) {
        Scanner wczytaj = new Scanner(System.in);
        int liczba;
        while (true) {
            try {
                liczba = wczytaj.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Błędny znak \n"
                        + wiadomosc);
                wczytaj.next();
            }
        }
        return liczba;
    }

    static int wczytajDodatniaLiczbe(String wiadomosc) {
        int liczba;
        while (true) {
            liczba = wczytajLiczbe(wiadomosc + "Podaj poprawną liczbę");

            if (liczba > 0) {
                break;
            }
            System.out.println(wiadomosc + "Podaj poprawną liczbę");
        }
        return liczba;
    }

    static int[] generujTablice(int dlugosc) {
        int[] tablica = new int[dlugosc];
        for (int i = 0; i < dlugosc; i++) {
            tablica[i] = i + 1;
        }
        return tablica;
    }

    static int[] generujTabliceUzytkownika(int dlugosc) {
        int[] tablica = new int[dlugosc];
        for (int i = 0; i < dlugosc; i++) {
            System.out.print("Podaj " + (i + 1) + " liczbę ciągu: ");
            tablica[i] = wczytajLiczbe("Podaj liczbę całkowitą: ");
        }
        return tablica;
    }

    static int[] generujTabliceIndeksow(int dlugosc) {
        int[] tablicaIndeksow = new int[dlugosc];
        //Arrays.fill(tablicaIndeksow, 0);
        for (int i = 0; i < dlugosc; i++) {
            tablicaIndeksow[i] = i;
        }
        wypisz(tablicaIndeksow);
        return tablicaIndeksow;
    }

    static void wypisz(int[] tablica) {
        System.out.println(Arrays.toString(tablica));

    }

    static void sortujTablice(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica.length - 1; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    int temp = tablica[j + 1];
                    tablica[j + 1] = tablica[j];
                    tablica[j] = temp;
                }
            }
        }
    }

    static void wykonajPermutacje(int[] tablica, int[] tablicaIndeksow) {
        int i = 1;
        int j, temp;
        while (i < tablica.length) {
            if (tablicaIndeksow[i] < i) {
                j = i % 2 * tablicaIndeksow[i];
                temp = tablica[j];
                tablica[j] = tablica[i];
                tablica[i] = temp;
                wypisz(tablica);
                tablicaIndeksow[i]++;
                i = 1;
            } else {
                tablicaIndeksow[i] = 0;
                i++;
            }
        }
    }

    static void wykonajPermutacje2(int[] tablica, int[] tablicaIndeksow) {
        int i = 1;
        int j, temp;
        while (i < tablica.length) {
            tablicaIndeksow[i]--;
            j = i % 2 * tablicaIndeksow[i];
            temp = tablica[j];
            tablica[j] = tablica[i];
            tablica[i] = temp;
            wypisz(tablica);
            i = 1;
            while (tablicaIndeksow[i] == 0) {
                tablicaIndeksow[i] = i;
                i++;
            }
        }
    }
}

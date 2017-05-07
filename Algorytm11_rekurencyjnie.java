package algorytm11_rekurencyjnie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KrzysieK
 */
public class Algorytm11_rekurencyjnie {

    public static void main(String[] args) {
        System.out.println("Wybierz co chcesz zrobić:\n"
                + "[1] wygeneruj losowy ciąg liczb\n"
                + "[2] wprowadź swoje liczby");
        System.out.print("Twój wybór to: ");
        int wybor = wczytajLiczbe("Podaj liczbę 1 lub 2: ");
        switch (wybor) {
            case 1: {
                System.out.print("Podaj wielkość zbioru liczb. ");
                int dlugosc = wczytajDodatniaLiczbe("Liczba powinna być dodania: ");
                int[] tablica = generujTablice(dlugosc);
                System.out.println("Podany zbirór liczb to: ");
                wypiszTablice(tablica);
                System.out.println("Podzbiory ciągu to:");
                wypiszPodzbiory(dlugosc, tablica);
                break;
            }
            case 2: {
                System.out.print("Podaj wielkość zbioru liczb. ");
                int dlugosc = wczytajDodatniaLiczbe("Liczba powinna być dodania: ");
                int[] tablica = generujTabliceUzytkownika(dlugosc);
                System.out.println("Podany zbirór liczb to: ");
                wypiszTablice(tablica);
                System.out.println("Podzbiory ciągu to: ");

                wypiszPodzbiory(dlugosc, tablica);
                break;
            }
            default: {
                System.out.println("Błędny wybór");
                break;
            }
        }

    }

    static void wypiszPodzbiory(int dlugosc, int[] tablica) {
        for (String s : wyliczKodGraya(tablica.length)) {
            System.out.println(generujPodzbior(s, tablica));
        }
    }

    static void wypiszTablice(int[] tablica) {
        System.out.println(Arrays.toString(tablica));

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

    static List<String> dolaczPrefiks(List<String> list, String prefiks) {
        List<String> tablica = new ArrayList<>(list.size());
        for (String ciagZnakow : list) {
            tablica.add(prefiks + ciagZnakow);
        }
        return tablica;
    }

    static List<String> odwrocListe(List<String> list) {
        List<String> odwroconaLista = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            odwroconaLista.add(list.get(i));
        }
        return odwroconaLista;
    }

    static List<String> wyliczKodGraya(int dlugosc) {
        if (dlugosc == 1) {
            List<String> poczatek = new ArrayList<String>();
            poczatek.add("0");
            poczatek.add("1");
            return poczatek;
        } else {
            List<String> tablicaPrim = wyliczKodGraya(dlugosc - 1);

            List<String> tablica = dolaczPrefiks(tablicaPrim, "0");
            tablica.addAll(dolaczPrefiks(odwrocListe(tablicaPrim), "1"));
            return tablica;
        }
    }

    static String generujPodzbior(String s, int[] tablica) {
        String napis = "";
        for (int i = (tablica.length - 1); i >= 0; i--) {
            if (s.charAt(i) == '1') {
                napis += " " + Integer.toString(tablica[tablica.length - 1 - i]) + " ";
            }
        }
        return napis;
    }

}

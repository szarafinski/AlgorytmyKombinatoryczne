import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KrzysieK
 */
public class KompozycjeLiczbyN {
static int licznik = 1;
static int licznik2 = 1;
static int wybrana_liczba;

    public static void main(String[] args) {
        System.out.println("Wprowadź liczbę by wypisać jej kompozcje");
        System.out.print("Twój wybór to: ");
        wybrana_liczba = wczytajDodatniaLiczbe("Podaj dodanią liczbą całkowitą");
        System.out.println();
        generujKombinacje(wybrana_liczba);
        System.out.println();
        System.out.println("Wypisane możliwe rozkłady liczby: ");
        generujRozklad(wybrana_liczba);
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
            liczba = wczytajLiczbe(wiadomosc);

            if (liczba > 0) {
                break;
            }
            System.out.println(wiadomosc);
        }
        return liczba;
    }

    static void generujKombinacje(int n) {
        generujKombinacje(n, "");
    }

    static void generujKombinacje(int n, String tekst) {
        if (n == 0) {
            System.out.println("kombinacja liczby " + wybrana_liczba + " numer " + licznik2 + ") " + tekst.substring(0,tekst.length()-1));
            licznik2++;
            return;
        }

        for (int i = n; i >= 1; i--) {
            generujKombinacje(n - i, tekst + i + "+");
        }
    }

    static int suma(ArrayList<Integer> tablica) {
        int suma = 0;
        for (int i = 1; i < tablica.size(); i++) {
            suma += tablica.get(i);
        }
        return suma;
    }
    
    static void wydrukuj(ArrayList tablica){
        ArrayList<Integer> temp = new ArrayList<Integer>(tablica);
        temp.remove(0);
        String suma = "";
        for (Integer liczba : temp){
            suma += liczba.toString() + "+";
        }
        System.out.println("rozklad liczby " + wybrana_liczba + " numer " + licznik + ") " + suma.substring(0, suma.length()-1));
        licznik++;
    }

    static void generujRozklad(int liczba) {
        int dlugosc = 1;
        int indeks;
        ArrayList<Integer> tablica = new ArrayList<Integer>();
        tablica.add(-1);
        tablica.add(liczba);
        while (dlugosc <= 3) {
            wydrukuj(tablica);
            indeks = dlugosc - 1;
            while (tablica.get(dlugosc) - tablica.get(indeks) < 2) {
                indeks--;
            }
            if (indeks != 0) {
                for (int i = dlugosc - 1; i >= indeks; i--) {
                    tablica.set(i, tablica.get(indeks) + 1);
                }
                tablica.set(dlugosc, 0);
            } else {
                for (int i = 1; i <= dlugosc; i++) {
                    tablica.set(i, 1);
                }
                dlugosc++;
                tablica.add(0);

            }
            tablica.set(dlugosc, liczba - suma(tablica));
        }
    }

}


/**
 *
 * @author KrzysieK
 */
import java.util.ArrayList;
import java.util.Collections;

public class Znaczki {

    static ArrayList<Integer> tablicaNominalow;
    static int sumaZnaczkow = 0;
    static Boolean czyDalej = true;
    static int najwyzszaSuma = 0;
    static ArrayList<Integer> listaPowtorzen = new ArrayList<>();
    static String najlepszeNominaly;

    public static void main(String[] args) {
        /* parametry*/
        int nominaly = 4,
                miejscaNaKopercie = 4,
                dokladnosc = 10;
        /* ----------im parametr DOKLADNOSC blizszy 1 tym mniej dokladne oszacowanie ------------------------*/
        System.out.println("Rozpoczęto wyszukiwanie w celu oszacowania najwyższej sumy nominałów: "
                + nominaly + " znaczków, których ilość na kopercie nie może przekroczyć " + miejscaNaKopercie + " miejsc.");

        tablicaNominalow = generujNominaly(nominaly);
        int rozwiazanie;
        System.out.println("Rozpoczynam wyszukiwanie od nominałów o wartościach: " + tablicaNominalow.toString() + "\n");
        while (czyDalej) {
            rozwiazanie = rozwiaz(nominaly, miejscaNaKopercie);
            usprawnijSzukanie(dokladnosc, rozwiazanie);
            reorganizujTabliceNominalow(nominaly, miejscaNaKopercie, dokladnosc, rozwiazanie);
        }
        System.out.println("\nNajwyższa możliwa do uzyskania liczba to: " + najwyzszaSuma + " dla znaczków o nominałach: " + najlepszeNominaly + "\n\n");
    }
    public static ArrayList<Integer> generujNominaly(int nominaly) {
        ArrayList<Integer> tablica = new ArrayList<Integer>(nominaly);
        for (int i = 1; i <= nominaly; i++) {
            tablica.add(i);
        }
        return tablica;
    }
    public static int rozwiaz(int nominaly, int miejsca) {
        int liczba = 1;
        int poprzedniaSuma = 0;
        int aktualnaSuma;
        while (true) {
            if (miejsca > liczba) {
                generujRozklad(liczba, liczba);
            } else {
                generujRozklad(liczba, miejsca);
            }
            //----------------------------------//

            if (sumaZnaczkow - poprzedniaSuma > 1) {
                //System.out.println("Maksymalna suma to: " + poprzedniaSuma + " przy elemenach: " + tablicaNominalow.toString());
                aktualnaSuma = poprzedniaSuma;
                znajdzRozwiazanie(poprzedniaSuma);
                break;
            }
            if (miejsca * Collections.max(tablicaNominalow) == liczba) {
                //System.out.println("Maksymalna suma to: " + sumaZnaczkow + " przy elemenach: " + tablicaNominalow.toString());
                aktualnaSuma = sumaZnaczkow;
                znajdzRozwiazanie(sumaZnaczkow);
                break;
            }

            liczba++;
            poprzedniaSuma = sumaZnaczkow;
        }
        return aktualnaSuma;
    }

    public static void znajdzRozwiazanie(int aktualnaSuma) {
        if (najwyzszaSuma < aktualnaSuma) {
            najwyzszaSuma = aktualnaSuma;
            najlepszeNominaly = tablicaNominalow.toString();
            System.out.println("Znaleziono lokalne maksimum: "
                    + najwyzszaSuma
                    + " dla tablicy nominalow: "
                    + najlepszeNominaly);
        }
    }

 
 public static void usprawnijSzukanie(int licznik, int aktualnaSuma) {
        listaPowtorzen.add(aktualnaSuma);
        if (listaPowtorzen.size() > licznik) {
            listaPowtorzen.remove(0);
        }
    }
// public static boolean czyWejsc (int aktualnaSuma, int miejsca){
//     for (int nominal : tablicaNominalow)
//                if (aktualnaSuma == miejsca /* nominal*/)
//                        return true;
//        return false;
// }
 
    public static void reorganizujTabliceNominalow(int nominaly, int miejsca, int licznik, int sumaNominalow) {
        if ((listaPowtorzen.size() > licznik - 1) && czyWszystkoTakieSame(listaPowtorzen)){
            if (sumaNominalow == miejsca) {
                tablicaNominalow.remove(tablicaNominalow.size() - 1);
                listaPowtorzen.clear();
            } else  {
                tablicaNominalow.set(tablicaNominalow.size() - 1, 116);
                listaPowtorzen.clear();
            }
            return;
        }

        int wartoscElementu = tablicaNominalow.get(tablicaNominalow.size() - 1);
        if (wartoscElementu == 1) {
            czyDalej = false;
        } else if (wartoscElementu
                <= 115) {
            tablicaNominalow.set(tablicaNominalow.size() - 1, wartoscElementu + 1);
        } else {
            tablicaNominalow.remove(tablicaNominalow.size() - 1);
            reorganizujTabliceNominalow(nominaly, miejsca, licznik, sumaNominalow);
            wartoscElementu = tablicaNominalow.get(tablicaNominalow.size() - 1);
            tablicaNominalow.add(wartoscElementu + 1);
        }
    }
   public static boolean czyWszystkoTakieSame(ArrayList array) {
        for (int i = 1; i < array.size(); i++) {
            if (!array.get(0).equals(array.get(i))) {
                return false;
            }

        }

        return true;
    }

//    static void wydrukuj(ArrayList tablica) {
//        ArrayList<Integer> temp = new ArrayList<Integer>(tablica);
//        temp.remove(0);
//        String tekst = "";
//        sumaZnaczkow = 0;
//        for (Integer liczba : temp) {
//            tekst += liczba.toString() + "+";
//            sumaZnaczkow += liczba;
//        }
//        System.out.println("Możliwe znaczki to: " + tekst.substring(0, tekst.length() - 1));
//
//    }

    static void generujRozklad(int liczba, int dlugoscLiczbyZapisanejJedynkami) {
        int dlugosc = 1;
        int indeks;
        ArrayList<Integer> rozklad = new ArrayList<Integer>();
        rozklad.add(-1);
        rozklad.add(liczba);
        while (dlugosc <= dlugoscLiczbyZapisanejJedynkami) {
            if (waliduj(rozklad)) {
                //wydrukuj(rozklad);
                sumaZnaczkow = sumuj(rozklad);
            }
            indeks = dlugosc - 1;
            while (rozklad.get(dlugosc) - rozklad.get(indeks) < 2) {
                indeks--;
            }
            if (indeks != 0) {
                for (int i = dlugosc - 1; i >= indeks; i--) {
                    rozklad.set(i, rozklad.get(indeks) + 1);
                }
                rozklad.set(dlugosc, 0);
            } else {
                for (int i = 1; i <= dlugosc; i++) {
                    rozklad.set(i, 1);
                }
                dlugosc++;
                rozklad.add(0);

            }
            rozklad.set(dlugosc, liczba - sumuj(rozklad));
        }
    }
    
      static int sumuj(ArrayList<Integer> tablica) {
        int suma = 0;
        for (int i = 1; i < tablica.size(); i++) {
            suma += tablica.get(i);
        }
        return suma;
    }

    public static Boolean waliduj(ArrayList tablica) {
        ArrayList<Integer> temp = new ArrayList<Integer>(tablica);
        temp.remove(0);
        for (Integer liczba : temp) {
            if (!tablicaNominalow.contains(liczba)) {
                return false;
            }
        }
        return true;
    }
}

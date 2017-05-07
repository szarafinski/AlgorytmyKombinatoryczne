import java.util.ArrayList;

/**
 *
 * @author KrzysieK
 */
public class PiPrefixFunkcja {

    public static void funkcjaPi(String tekst, int dlugoscWzorca) {

        int dlugoscTekstu = tekst.length();
        int[] tablicaPi = new int[dlugoscTekstu];
        tablicaPi[1] = 0;
        int licznik = 0;
        /*
        wypisuje znaleienie wzroca, ponieważ przeszukiwany tekst zaczyna się od wzorca
        */
        System.out.println("Znaleziono tekst na pozcji: " + 0 + " od początku."); 
        for (int indeks = 2; indeks < dlugoscTekstu; indeks++) {
            while (licznik > 0) {
                if (tekst.charAt(indeks) != tekst.charAt(licznik)) {
                    licznik = tablicaPi[licznik - 1];
                } else {
                    break;
                }
            }
            if (tekst.charAt(indeks) == tekst.charAt(licznik)) {
                licznik++;
            }
            tablicaPi[indeks] = licznik;
            /*
            dodana został dodany warunek sprawdzajacy czy ilosc powtorzen liter od poczatku odpowiada
            dlugosci wzorca (szukanego slowa). Jezeli tak to w tedy wypisywana jest pozycja znalezionego tekstu.
            */
            if (licznik == dlugoscWzorca) {
                System.out.println("Znaleziono tekst na pozcji: " + (indeks - dlugoscWzorca + 2) + " od początku.");
            }

        }
    }

    public static void main(String[] args) {
        String tekst = "wyszukaj trzy slowa skladajace sie kazde z liter w tekscie o ilosci liter wiecej niz liter maja slowa trzy";
        String wzorzec = "liter ";
        String konkatenacja = wzorzec + tekst;
        System.out.println("Tekst podstawowy to: \n\"" + tekst + "\"\n");
        System.out.println("Tekst wzorca to: \n\"" + wzorzec + "\"\n");
        System.out.println("Zlaczenie tekstow to: \n\"" + konkatenacja + "\"");
        System.out.println("\nRozpoczeto przeszukiwanie...");
        /*
        funkcja Pi została zmodyfikowana tak, że przyjmuje dodakowy argument informujacy o dlugosci szukanego slowa.
        bez tego argumentu funkcja nie jest wstanie znalezc za kazdym przypadkiem poprawnej odpowiedzi w sytuacji kiedy
        we wzorcu np. ostatnia litera jest taka sama jak pierwsza litera, druga, jak przed ostatnia i analogicznie dalej.
        ta informacja jest potrzebna.
        */
        funkcjaPi(konkatenacja, wzorzec.length());
        
    }
}

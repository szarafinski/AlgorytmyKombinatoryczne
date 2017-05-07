

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KrzysieK
 */
public class NaiwnyAlgorytm {

    public static void main(String[] args) {
        String tekst = "wyszukaj trzy slowa skladajace sie kazde z liter w tekscie o ilosci liter wiecej niz liter maja slowa trzy";
        String wzorzec = "liter";
        System.out.println("Tekst przeszukiwany to: \n\"" + tekst + "\"\n");
        System.out.println("Tekst szukany to: \n\"" + wzorzec + "\"");
        int dlugoscTekstu = tekst.length();
        int dlugoscWzorca = wzorzec.length();
        int indeks;
        System.out.println("\nRozpoczeto przeszukiwanie...");
        for(int pozycja = 0; pozycja <= dlugoscTekstu - dlugoscWzorca; pozycja++) {
            for ( indeks = 0; indeks < dlugoscWzorca; indeks++) {
                if (tekst.charAt(indeks + pozycja) != wzorzec.charAt(indeks)){
                    break;
                }
            }
            if (indeks == dlugoscWzorca) {
                System.out.println("Znaleziono tekst na pozcji: " + (pozycja + 1) + " od początku.");
            }
            /*poniższy zabieg powoduje, że nie sprawdzamy wszystkich liter we wzorcu,
              poniewaz sa one rozne. Dodajemy ilosc elementow pasujacych do pozycji
            dzieki temu szybciej zmieniamy pozycje i nie tracimy czasu na sprawdzanie
            pol: (dlugoscWzorca - indeksyPoprawne) * dlugoscWzorca. 
            Daje to czas wykonania teta(n) zamiast teta(n^2)*/
            pozycja += indeks;
        }
    }
}


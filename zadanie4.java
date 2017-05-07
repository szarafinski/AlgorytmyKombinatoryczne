import java.util.Arrays;
import java.util.Scanner;

class zadanie3 {

    static Kolejka kolejka = new Kolejka();

    public static void main(String[] args) {

        while (true) {
            System.out.println("-------------\nPodaj komendę, co chcesz zrobić:\nnapisz \"put\" i LICZBĘ, by dodać element \nnapisz \"get\", by pobrać element");
            Scanner wczytaj = new Scanner(System.in);
            String komenda = wczytaj.next();
            double liczba;
            switch (komenda) {
                case "put": {
                    if (wczytaj.hasNextDouble()) {
                        liczba = wczytaj.nextDouble();
                        kolejka.put(liczba);
                        System.out.println("Wprowadzona liczba to: " + liczba);
                    } else  {
                        System.out.println("Błędny argument");
                    }  
                        
                    break;
                }
                case "get": {
                    try {
                        liczba = kolejka.get();
                        System.out.println("Pobrana liczba to: " + liczba);
                    } catch (Exception e) {
                        System.out.println("Pusto, brak elementów do pobrania.");
                    }
                    break;
                }
                default: {
                    System.out.println("nieznana komenda");
                }
            }
        }
    }
}

class Kolejka {

    double[] tablica = new double[10];
    int licznik = 0;

    void put(double liczba) {
        if (licznik + 1 >= tablica.length) {
            tablica = Arrays.copyOf(tablica, tablica.length * 2);
        }
        tablica[licznik] = liczba;
        licznik++;
    }

    double get() throws Exception {
        if (licznik == 0) {
            throw new Exception();
        }
        licznik--;
        double liczba = tablica[0];
        tablica = Arrays.copyOfRange(tablica, 1, tablica.length-1);
        return liczba;
    }
}

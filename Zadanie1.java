import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner czytaj = new Scanner(System.in);
        while (true) {
            int n;
            System.out.println("Podaj argument n: ");
            
            if (czytaj.hasNextInt()) {
                n = czytaj.nextInt();
                System.out.println("Obliczona liczba " + n + " to: " + wyraz(n));
            } else {
                System.out.println("podano błędny argument.");
                czytaj.next();
            }
            
        }
    }
    
   
    static double wyraz(int n){
        double zero = 2;
        double jeden = 1;
        double wynik=0;
        if (n==0){
            return zero;
        }
        if (n==1){
            return jeden;
        }
        
        for (int i =0;i<n-1;i++){
            wynik = (jeden +2) / (zero +1);
            zero = jeden;
            jeden = wynik;
        }
        
        return wynik;
        
    }

}

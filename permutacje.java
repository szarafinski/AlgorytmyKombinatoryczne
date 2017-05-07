
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KrzysieK
 */
public class Program {

    public static void main(String[] args) {
        System.out.println("Podaj ilość elementów: ");
        Scanner czytaj = new Scanner(System.in);
        int n = czytaj.nextInt();
        Program klasa = new Program();
        klasa.wylicz(n);
        
        String s = "1234";
        String s1 = "EBAY";
        String s2 = "Yahoo";
       System.out.println("\nString " + s + ":\nPermutations: " + crunchifyPermutation(s));
       // System.out.println("\nString " + s1 + ":\nPermutations: " + crunchifyPermutation(s1));
       // System.out.println("\nString " + s2 + ":\nPermutations: " + crunchifyPermutation(s2));
    }
void wylicz(int n){
    int[] dane = stworzTablice(n);
    wydrukuj(dane);
    ArrayList<int[]> mniam;
        mniam = permutacja(dane);
    for (int[] tablica : mniam){
        for (int i = 0; i< tablica.length;i++)
            System.out.print(tablica[i] + " ");
        System.out.println();
    }
}
void wydrukuj(int[] tabilca) {
        for (int liczba : tabilca) {
            System.out.print(liczba + " ");
        }
        System.out.println();
    }
  int[] stworzTablice(int n) {
        int[] tablica = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            tablica[i] = n - i;
        }
        return tablica;
    }
  ArrayList<int[]> permutacja(int[] liczby){
      ArrayList<int[]> wynik = new ArrayList<>();
      if (liczby.length ==0){
          return wynik;
      }
      
      int pierwsza = liczby[0];
    int[] reszta = Arrays.copyOfRange(liczby, 1, liczby.length);
    ArrayList<int[]> kombinacje = permutacja(reszta);
    for (int[] nowa : kombinacje){
        for (int i =0; i<=nowa.length;i++){
        wynik.add(dodajCos(nowa,pierwsza,i));
    }}
    return wynik;
  }
  
int[] dodajCos(int[] nowa, int pierwsza, int i){
    int[] pierwsze = Arrays.copyOfRange(nowa, 0, i);
    int[] ostatnie = Arrays.copyOfRange(nowa, i, nowa.length);
    int[] zwrot = new int[nowa.length+1];
    for (int j = 0; j==i;j++)
        zwrot[j] = nowa[j];
    zwrot[i+1] = pierwsza;
    for (int j=i; j==nowa.length;j++)
        zwrot[i+2]=nowa[j];
    
    return zwrot;
}

   public static Set<String> crunchifyPermutation(String str) {
        Set<String> crunchifyResult = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            crunchifyResult.add("");
            return crunchifyResult;
        }

        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = crunchifyPermutation(rem);
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                
                System.out.println(crunchifyCharAdd(newString, firstChar, i));
            }
        }
        return crunchifyResult;
    }

    public static String crunchifyCharAdd(String str, char c, int j) {
        String first = str.substring(0, j);
        String last = str.substring(j);
        return first + c + last;
    }

}


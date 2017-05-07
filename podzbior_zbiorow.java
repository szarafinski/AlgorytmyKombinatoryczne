
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KrzysieK
 */

/* generowanie k-elementowych podzbiorów zbioru {1,2,...,n} w porządku leksykograficznym */
public class Aha {

    public static void main(String[] args) {
        int k = 3;
        int n = 5;
        int[] Tablica = new int[k + 1];
        Tablica[0] = 0;
        for (int i = 1; i <= k; i++) {
            Tablica[i] = i;
        }
        if (k <= n) {
            int p = k;
            while (p >= 1) {
                System.out.println(Arrays.toString(Tablica));
                if (Tablica[k] == n) {
                    p--;
                } else {
                    p = k;
                }
                if (p >= 1) {
                    int j = k;
                    do {
                        Tablica[j] = Tablica[p] + j - p + 1;
                        j--;
                    } while (j >= p);
                }
            }
        } else { 
            System.out.println("wielkość podzbioru przekracza wielkosc zbioru");
        }
    }
}

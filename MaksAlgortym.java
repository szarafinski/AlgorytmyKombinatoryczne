
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
public class MaksAlgortym {

    public static void main(String[] args) {
        int[] W = {-1, 3, 1, 2, 1, 4, 1, 2, 2};
        System.out.println("tablic z wartościami: ");
        System.out.println(Arrays.toString(W));
        int[] NEXT = {-1, 2, 3, 6, 7, 0, 5, 1, 4};
        int[] S = NEXT;
        int[] sort = {-1, 8, 4, 7, 1, 2, 3, 6, 5};
        for (int j = 0; j < (Math.log(W.length - 1) / Math.log(2)); j++) {
            for (int i = 1; i < W.length; i++) {
                if (S[i] != 0) {
                    W[S[i]] = W[i] + W[S[i]];
                    S[i] = S[S[i]];
                }
            }
        }
        System.out.println("tablic z wartościami po maksymilizacji: ");
        System.out.println(Arrays.toString(W));
        for (int i = 1; i < S.length; i++) {
            S[i] = W[sort[i]];
        }
        System.out.println("tablic z wartościami po ustawieniu: ");
        System.out.println(Arrays.toString(S));
    }

}

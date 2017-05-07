/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KrzysieK
 */
public class Tablica {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lista;
        lista = new ArrayList<>();
        while (true) {
            System.out.println("Podaj liczbę by co zrobić 1-dodaj, 2-usun, 3-jaka jest ostatnia liczba");
            Scanner czytaj = new Scanner(System.in);
            int liczba = czytaj.nextInt();
            switch (liczba) {
                case 1:
                    System.out.println("podaj liczbę");
                    liczba = czytaj.nextInt();
                    lista.add(liczba);
                    System.out.println("podałes " + liczba + ", która zostałą dopisana do tablicy.");
                    break;
                case 2:
                    lista.remove(0);
                    break;
                case 3:
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }
                    break;
                default:
                    System.out.println("niepoprawny wybór");
                    break;
            }

        }
    }

}

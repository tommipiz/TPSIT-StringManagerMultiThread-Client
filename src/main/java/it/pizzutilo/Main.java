package it.pizzutilo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 5672);
        System.out.println("Il client si è collegato");


        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String scelta;
        String stringaRicevuta;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("(1) Trasformare stringa in maiuscolo");
            System.out.println("(2) Trasformare stringa in minuscolo");
            System.out.println("(3) Ribaltare i caratteri della stringa");
            System.out.println("(4) Contare il numero di caratteri");
            System.out.println("(0) Termina");

            scelta = scanner.nextLine();
            out.writeBytes(scelta + "\n");
            if(scelta.equals(0)) {
                System.out.println("stop");
            }else {
            System.out.println("Inserire una stringa per terminare l'esecuzione");
            scelta = scanner.nextLine();
            out.writeBytes(scelta + "\n");
            stringaRicevuta = in.readLine();
            System.out.println("La stringa ricevuta: " + stringaRicevuta);
            }
        } while (!scelta.equals("0"));

        s.close();
        scanner.close();

    }
}
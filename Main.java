

import java.util.Scanner;
import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "Windows-1250");
        Evidence evidence = new Evidence();
        String volba = " ";

        /**tělo programu s volbou
         *
         */
        while (!volba.equals("4")) {
            evidence.uvodniVypis();
            out.println();
            System.out.println();
            out.println("\n1 - Přidat nového pojištěného");
            out.println("2 - Vypsat všechny pojištěné");
            out.println("3 - Vyhledat pojištěného");
            out.println("4 - Ukončit program");
            volba = sc.nextLine();

            /**akce po volbě
             *
             */
            switch (volba) {
                case "1" -> evidence.pridatZaznam();
                case "2" -> evidence.vypsatZaznam();
                case "3" -> evidence.vyhledatZaznam();
                case "4" -> out.println("Program byl ukončen.");
                default ->
                        out.println("Volba je neplatná, zadejte novou volbu.");
            }
        }
    }
}

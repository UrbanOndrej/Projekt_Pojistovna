import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Scanner;
public class Evidence {
    LocalDateTime datumCas = LocalDateTime.now();
    private Databaze databaze;
    //sca nner ( instance) pro čtení z konzole
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public Evidence() {
        databaze = new Databaze();
    }

    public void uvodniVypis() {
        System.out.println("-------------------------");
        System.out.println("---Evidence pojištěnců---");
        System.out.println("-------------------------");
    }

    public void pridatZaznam() {
        System.out.println("Zadejte jméno: ");
        String jmeno = sc.nextLine().trim().toUpperCase();
        System.out.println("Zadejte příjmení: ");
        String prijmeni = sc.nextLine().trim().toUpperCase();
        System.out.println("Zadejte věk pojištěnce: ");
        byte vek = (byte) Integer.parseInt(sc.nextLine().trim());
        System.out.println("Děkujeme, nyní ještě telefonní číslo a email:  ");
        System.out.println("Telefonní číslo (bez předvolby +420 ) :");
        String telCislo = sc.nextLine().trim();
        System.out.println("Email: ");
        String email = sc.nextLine();
        String chyba;
        if ((jmeno.length() < 3 || (jmeno.length() > 20) || (jmeno.equals("")) && (prijmeni.equals(""))
                || ((vek < 1 || (vek > 125)) || (telCislo.length() != 9) || (!email.contains("@")))) || (!email.contains("."))) {
            chyba = ("Chybně zadané údaje.Zadejte, prosím, znovu: ");
            System.out.println(chyba);

        } else {
            databaze.pridatZaznam(jmeno, prijmeni, vek, telCislo, email);
            System.out.println("Záznam byl úspěšně přidán do databáze." +
                    "\nDatum a čas uložení: " +
                    datumCas.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));
        }
    }

    /**
     *
     */
    public void vypsatZaznam() {
        for (Zaznam x : databaze.getZaznamy()) {
            System.out.println(x);
            System.out.println();
        }
    }

    /**
     *
     */
    public void vyhledatZaznam() {
        System.out.println("Zadejte vybrané jméno a příjmení pro vyhledání v databázi: ");
        //zadání textu uživatelem
        String[] vyhledane = sc.nextLine().toUpperCase().trim().split(" ");
        ArrayList<Zaznam> zaznamy = databaze.vyhledatZaznam(vyhledane[0], vyhledane[1]);


        if (zaznamy.isEmpty()) {
            System.out.println("Záznam nenalezen.");
            System.out.println("\nChcete pokračovat novým zadáním? [ano/ne]");

            String volba = sc.nextLine().trim();
            if (volba.equals("ano")) {
                vyhledatZaznam();
            } else {
                System.out.println("Program bude ukončen.");
            }
        } else {
            System.out.println("Nalezený údaj:\n ");
            for (Zaznam zaznam:zaznamy){
                System.out.println(zaznam);
            }
            System.out.println("\nChcete pokračovat novým zadáním? [ano/ne]");
            String volba = sc.nextLine().trim();
            if (volba.equals("ano")) {
                vyhledatZaznam();
            } else {
                System.out.println("Program bude ukončen.");

            }
        }
    }
}








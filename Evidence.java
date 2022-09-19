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
        System.out.println("Telefonní číslo :");
        String telCislo = sc.nextLine().trim();
        System.out.println("Email: ");
        String email = sc.nextLine();
        String chyba;
        if ((jmeno.length() < 3 || (jmeno.length() > 20) || (jmeno.equals("")) && (prijmeni.equals(""))
                || ((vek < 1 || (vek > 125)) || (telCislo.length() != 9) || (!email.contains("@"))))) {
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
        String[]vyhledane = sc.nextLine().toUpperCase().trim().split(" ");
        if (vyhledane.equals(databaze.vyhledatZaznam(vyhledane[0], vyhledane[1]))){
            /**
             *
             */
            ArrayList<Zaznam> zaznamy = databaze.vyhledatZaznam(vyhledane[0], vyhledane[1]);
            System.out.println("Nalezený údaj: ");
            System.out.println(zaznamy);
        }else{
            System.out.println("Záznamy podle Vašeho zadání nebyly nalezeny." +
                    "\n" +
                    "Zkuste nové zadání: ");


        }


    }
}


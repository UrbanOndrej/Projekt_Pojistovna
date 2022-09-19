import java.util.ArrayList;

public class Databaze {
    private ArrayList<Zaznam> zaznamy;
    private Databaze vyhledane;

    public ArrayList<Zaznam> getZaznamy() {
        return zaznamy;
    }

    public Databaze() {
        zaznamy = new ArrayList<>();
    }

    public void pridatZaznam(String jmeno, String prijmeni, int vek, String telCislo, String email) {
        Zaznam zaznam = new Zaznam(jmeno, prijmeni, vek, telCislo,email);
        zaznamy.add(zaznam);
    }

    /**
     *
     * @param jmeno
     * @param prijmeni
     * @return
     * @param <zaznamy>
     */
        public <zaznamy> ArrayList<Zaznam> vyhledatZaznam (String jmeno, String prijmeni){
            ArrayList<Zaznam> vyhledane =  new ArrayList<>();
            for(Zaznam z : zaznamy){
                if (z.getJmeno().equals(jmeno) && z.getPrijmeni().equals(prijmeni) ){
                    vyhledane.add(z);
                }
            }
            return vyhledane;
        }


    }


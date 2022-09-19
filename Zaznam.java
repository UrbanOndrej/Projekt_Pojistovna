public class Zaznam {


    private String jmeno;
    private String prijmeni;
    private String email;
    private String telCislo;
    private int vek;
    public String getJmeno() {
        return jmeno;
    }
    public String getPrijmeni() {
        return prijmeni;
    }
    public String getEmail() {
        return email;
    }
    public String getTelCislo() {
        return telCislo;
    }
    public int getVek() {
        return vek;
    }

    /**
     *
     * @param jmeno
     * @param prijmeni
     * @param vek
     * @param telCislo
     * @param email
     */
    public Zaznam(String jmeno, String prijmeni, int vek, String telCislo, String email) {
        this.jmeno=jmeno;
        this.prijmeni = prijmeni;
        this.telCislo = telCislo;
        this.vek = vek;
        this.email = email;
    }
    @Override
    public String toString(){
        return jmeno + " " +  prijmeni + "\nVěk: " + vek + " let" +
                "\nKontakt: \nTel.číslo: +420 " + telCislo + "\nEmail: " + email;
    }
}

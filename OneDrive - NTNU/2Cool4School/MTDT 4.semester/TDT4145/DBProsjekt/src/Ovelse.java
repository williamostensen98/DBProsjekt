public class Ovelse {

    private String navn, beskrivelse;
    private int kg, sett, type, apparatID;

    public Ovelse(String navn, String beskrivelse,int kg, int sett, int type, int apparatID){
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.kg = kg;
        this.sett = sett;
        this.type = type;
        this.apparatID = apparatID;

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getSett() {
        return sett;
    }

    public void setSett(int sett) {
        this.sett = sett;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getApparatID() {
        return apparatID;
    }

    public void setApparatID(int apparatID) {
        this.apparatID = apparatID;
    }
}
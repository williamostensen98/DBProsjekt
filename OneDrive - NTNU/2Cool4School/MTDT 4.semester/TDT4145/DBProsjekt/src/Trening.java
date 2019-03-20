import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Trening {

    private Date tidsstempel;
    private int varighet;
    private int form;
    private int prestasjon;
    private String formal;
    private String opplevelse;

    private List<Ovelse> ovelsesListe;

    public Trening(Date tidsstempel, int varighet, int form, int prestasjon, String formal, String opplevelse) {
        this.tidsstempel = tidsstempel;
        this.varighet = varighet;
        this.form = form;
        this.prestasjon = prestasjon;
        this.formal = formal;
        this.opplevelse = opplevelse;

        this.ovelsesListe = new ArrayList<Ovelse>();

    }

    public void addOvelse(Ovelse o){
        this.ovelsesListe.add(o);
    }

    public Date getTidsstempel() {
        return tidsstempel;
    }

    public int getVarighet() {
        return varighet;
    }

    public int getForm() {
        return form;
    }

    public int getPrestasjon() {
        return prestasjon;
    }

    public String getFormal() {
        return formal;
    }

    public String getOpplevelse() {
        return opplevelse;
    }
}
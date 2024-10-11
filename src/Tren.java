import java.util.HashMap;
import java.util.Map;

class Tren {
    public String numar;
    private String tipTren;
    private float pretClasaI;
    private float pretClasaII;
    private String plecare;
    private String sosire;
    private String ora_plecare;
    private String ora_sosire;
    private HashMap<String , String> gari_parcurse = new HashMap<String , String>();

    Tren(){}

    Tren(String numar ,String tipTren ,float pretClasaI , float pretClasaII , String plecare , String sosire , String ora_plecare , String ora_sosire, HashMap<String , String> gari_parcurse) {
        this.numar = numar;
        this.tipTren = tipTren;
        this.pretClasaI = pretClasaI;
        this.pretClasaII = pretClasaII;
        this.plecare = plecare;
        this.sosire = sosire;
        this.ora_plecare = ora_plecare;
        this.ora_sosire = ora_sosire;
        this.gari_parcurse = gari_parcurse;
    }

    public void setTipTren(String tip) {
        this.tipTren = tip;
    }

    public void setPretClasaI(float pret) {
        this.pretClasaI = pret;
    }

    public void setPretClasaII(float pret) {
        this.pretClasaII = pret;
    }

    public void setPlecare(String plecare) {
        this.plecare = plecare;
    }

    public void setSosire(String sosire) {
        this.sosire = sosire;
    }

    public void setOra_plecare(String ora) {
        this.ora_plecare = ora;
    }

    public void setOra_sosire(String ora) {
        this.ora_sosire = ora;
    }

    public void adaugaGariParcurse(String gara , String ora) {
        gari_parcurse.put(gara , ora);
    }

    public String getTipTren() {
        return this.tipTren;
    }

    public float getPret(int clasa) {
        if (clasa == 1) {
            return this.pretClasaI;
        } else {
            return this.pretClasaII;
        }
    }

    public String getPlecare() {
        return this.plecare;
    }

    public String getSosire() {
        return this.sosire;
    }

    public String getOra_plecare() {
        return this.ora_plecare;
    }

    public String getOra_sosire() {
        return this.ora_sosire;
    }

    public Map<String , String> getGari_parcurse() {
        return this.gari_parcurse;
    }
}
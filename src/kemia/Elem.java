package kemia;

public class Elem {
    private String ev;
    private String nev;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;

    public Elem(String sor) {
        String[] s = sor.split(";");
        this.ev = s[0];
        this.nev = s[1];
        this.vegyjel = s[2];
        this.rendszam = Integer.parseInt(s[3]);
        this.felfedezo = s[4];
    }

    public String getEv() {
        return ev;
    }

    public String getNev() {
        return nev;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public int getRendszam() {
        return rendszam;
    }

    public String getFelfedezo() {
        return felfedezo;
    }

    @Override
    public String toString() {
        return "Elem{" + "ev=" + ev + ", nev=" + nev + ", vegyjel=" + vegyjel + ", rendszam=" + rendszam + ", felfedezo=" + felfedezo + '}';
    }
    
    
}

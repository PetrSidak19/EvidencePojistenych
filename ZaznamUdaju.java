package EvidencePojistenych;

import java.time.LocalDate;

public class ZaznamUdaju {


    private final LocalDate datumCas;
    private final String jmeno;

    private final String prijmeni;

    private final int telefon;

    private final int vek;
    /**
     * vyvolání konstruktoru
     */
    public ZaznamUdaju(LocalDate datumCas, String jmeno, String prijmeni, int telefon, int vek) {
        this.datumCas = datumCas;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.vek = vek;
    }
    /**
     * vrátí datumCas
     */
    public LocalDate getDatum() {
        return datumCas;
    }
    /**
     * vrátí jméno
     */
    public String getJmeno() {
        return jmeno;
    }
    /**
     * vrátí příjmení
     */
    public String getPrijmeni() {
        return prijmeni;
    }
    /**
     * vrátí telefon
     */
    public int getTelefon() {
        return telefon;
    }
    /**
     * vrátí věk
     */
    public int getVek() {
        return vek;
    }
}


package com.mycompany.app.domain;

public class Classe {
    private int idC;
    private String libelle;
    private String matiere1;
    private String matiere2;
    private String matiere3;
    private String matiere4;
    private String matiere5;

    public Classe(int idC, String libelle,String matiere1,String matiere2,String matiere3,String matiere4,String matiere5) {
        this.idC = idC;
        this.libelle = libelle;
        this.matiere1 = matiere1;
        this.matiere2 = matiere2;
        this.matiere3 = matiere3;
        this.matiere4 = matiere4;
        this.matiere5 = matiere5;
    }

    public int getId() {
        return idC;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMatiere1() {
        return matiere1;
    }

    public void setMatiere1(String matiere1) {
        this.matiere1 = matiere1;
    }

    public String getMatiere2() {
        return matiere2;
    }

    public void setMatiere2(String matiere2) {
        this.matiere2 = matiere2;
    }

    public String getMatiere3() {
        return matiere3;
    }

    public void setMatiere3(String matiere3) {
        this.matiere3 = matiere3;
    }

    public String getMatiere4() {
        return matiere4;
    }

    public void setMatiere4(String matiere4) {
        this.matiere4 = matiere4;
    }

    public String getMatiere5() {
        return matiere5;
    }

    public void setMatiere5(String matiere5) {
        this.matiere5 = matiere5;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "idC=" + idC +
                '}';
    }
}

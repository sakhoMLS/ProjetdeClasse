package com.mycompany.app.domain;

public class Etudiant {
    private int id;
    private String nom;
    private  String prenom;
    private String tel;
    private Classe id_classe;

    public Etudiant(int id, String nom, String prenom, String tel, Classe id_classe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.id_classe = id_classe;
    }

    public Etudiant() {

    }

    public int getId() {
        return id;

    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Classe getId_classe() {
        return id_classe;
    }

    public void setId_classe(Classe id_classe) {
        this.id_classe = id_classe;
    }

}

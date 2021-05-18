package com.mycompany.app.service;

import com.mycompany.app.domain.Etudiant;

public interface DisplayeEtudiant {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeEtudiants(Etudiant[] etudiants);
    Etudiant addEtudiant() throws Exception;
    void  afficherOptionInconnue();
    Etudiant updateEtudiant();
    int deleteEtudiant();
}

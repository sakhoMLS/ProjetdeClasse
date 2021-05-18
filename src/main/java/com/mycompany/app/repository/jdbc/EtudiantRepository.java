package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;

public interface EtudiantRepository {
    int add(Etudiant etudiant);
    int update(Etudiant etudiant);
    int delete(int id);
    Etudiant[] getAll();

    public Classe getClaById(int idC) throws Exception;

}


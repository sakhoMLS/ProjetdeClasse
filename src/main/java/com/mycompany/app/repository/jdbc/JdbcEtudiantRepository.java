package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEtudiantRepository implements  EtudiantRepository{
    private DataSource dataSource;

    public JdbcEtudiantRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int add(Etudiant etudiant) {
        int ok = 0;
        String query = "INSERT INTO etudiant (nom,prenom,tel,id_classe) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getTel());
            statement.setInt(4, 2);

            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("etudiant créé avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Etudiant etudiant ) {
        String query = "UPDATE  user SET id=? ,nom=?, prenom=?, tel=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getTel());
           // statement.setInt(4, etudiant.getId_classe().getId());
            statement.setInt(4, etudiant.getId());
            ok = statement.executeUpdate();

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("etudiant est modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }



    @Override
    public int delete(int id) {
        String query = "DELETE FROM etudiant where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("etudiant est supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Etudiant[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM etudiant e,classe c where e.id_classe = c.idC";
        //mapper le résultat
        List<Etudiant> etudiants = new ArrayList<Etudiant>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel = rs.getString("tel");
                int IdC = rs.getInt("id_classe");
               String libelle = rs.getString("libelle");
                String matiere1 = rs.getString("matiere1");
                String matiere2 = rs.getString("matiere2");
                String matiere3 = rs.getString("matiere3");
                String matiere4 = rs.getString("matiere4");
                String matiere5 = rs.getString("matiere5");
                Classe classe = new Classe(IdC,libelle,matiere1,matiere2,matiere3,matiere4,matiere5);
                //mapping retour db (relationnel) avec objet Offre
                Etudiant etudiant = new Etudiant( id, nom,prenom,tel,classe);

                etudiants.add(etudiant);
            }
            return etudiants.toArray(new Etudiant[0]);

        }
        catch (SQLException e) {
            return new Etudiant[0];
        }
        catch (Exception ex){
            return new Etudiant[0];
        }
    }

    public Classe getClaById(int idC) throws Exception {
        String query = "SELECT idC, libelle, matiere1,matiere2,matiere3,matiere4,matiere5, from classe where idC = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idC);
            ResultSet rs = statement.executeQuery();
            int retrievedIdC = rs.getInt("idC");
            String retrievedLibelle = rs.getString("libelle");
            String retrievedMatiere1 = rs.getString("matiere1");
            String retrievedMatiere2 = rs.getString("matiere2");
            String retrievedMatiere3 = rs.getString("matiere3");
            String retrievedMatiere4 = rs.getString("matiere4");
            String retrievedMatiere5 = rs.getString("matiere5");

            Classe classe = new Classe(retrievedIdC, retrievedLibelle, retrievedMatiere1,  retrievedMatiere2,  retrievedMatiere3,retrievedMatiere4, retrievedMatiere5);
            return classe;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

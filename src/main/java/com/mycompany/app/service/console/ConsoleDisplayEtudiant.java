package com.mycompany.app.service.console;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;
import com.mycompany.app.repository.jdbc.DataSource;
import com.mycompany.app.repository.jdbc.EtudiantRepository;
import com.mycompany.app.repository.jdbc.JdbcEtudiantRepository;
import com.mycompany.app.repository.jdbc.MysqlDataSource;
import com.mycompany.app.service.DisplayeEtudiant;

import java.util.Scanner;

public class ConsoleDisplayEtudiant implements DisplayeEtudiant {
   DataSource dataSource = new MysqlDataSource();
   private EtudiantRepository etudiantRepository = new JdbcEtudiantRepository(dataSource);

    @Override
    public void afficherBienvenu() {
        System.out.println("BIENVENUE ");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("1 /lister des etudiants");
        System.out.println("-------------------------");
        System.out.println("2 /ajouter un etudiant");
        System.out.println("-------------------------");
        System.out.println("3 /modifier un etudiant");
        System.out.println("-------------------------");
        System.out.println("4 /supprimer un etudiant");
        System.out.println("+++++++++++++++++++++++++");
    }

    @Override
    public void afficherListeEtudiants(Etudiant[] etudiants) {
        System.out.println("Les etudiants disponibles sont:");
        for (int i = 0; i < etudiants.length; i++) {
            Etudiant etudiant = etudiants[i];
            System.out.println(String.format("> %s/    %s   %s   %s     < %s >         -     %s     -     %s     -     %s     -     %s     -     %s", etudiant.getId(), etudiant.getNom(),etudiant.getPrenom(),etudiant.getTel(),etudiant.getId_classe().getLibelle(),etudiant.getId_classe().getMatiere1(),etudiant.getId_classe().getMatiere2(),etudiant.getId_classe().getMatiere3(),etudiant.getId_classe().getMatiere4(),etudiant.getId_classe().getMatiere5()));
        }
    }

    @Override
    public Etudiant addEtudiant() throws Exception {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("entrer le nom");
        etudiant.setNom(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer la prenom");
        etudiant.setPrenom(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer le tel");
        etudiant.setTel(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer l'id de la classe");
        int idC=sc.nextInt();
       //Classe Cla = EtudiantRepository.getClaById(idC);
      // etudiant.setId_classe(Cla);

        return etudiant;
    }

    @Override
    public void afficherOptionInconnue() {
        System.out.println("Menu Introuvable");
    }

    @Override
    public Etudiant updateEtudiant() {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("entrer l'id de l'etudiant");
        etudiant.setId(sc.nextInt());
        System.out.println("-------------------------");
        System.out.println("entrer le nom");
        etudiant.setNom(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer le prenom");
        etudiant.setPrenom(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer le tel");
        etudiant.setTel(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("entrer l'id de la classe");
      //  etudiant.setId_classe(sc.nextInt());

        return  etudiant;
    }

    @Override
    public int deleteEtudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'etudiant à supprimer");
        return  scanner.nextInt();
    }
}

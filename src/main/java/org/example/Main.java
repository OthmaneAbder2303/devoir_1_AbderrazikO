package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Création des clients
        Client client1 = new Client(0, null, null, null, null, null);
        client1.AjouterClient(1, "Dupont", "Jean", "365 Rue Mexique", "0601234567", "jean.dupont@email.com");
        Client client2 = new Client(1, "Laurey", "Mathis", "67 Rue Les Citoyens", "0648871178", "mathis_987@email.com");

        // Création de comptes
        Compte compte11 = new Compte("ACC001", new Date(), new Date(), "USD", "Banque Populaire", client1);
        Compte compte12 = new Compte("ACC002", new Date(), new Date(), "EUR", "Banque Populaire", client1);
        Compte compte21 = new Compte("DCZ001", new Date(), new Date(), "EUR", "Bank Of Africa", client2);

        // Ajouter des comptes au client
        client1.AjouterCompte(compte11);
        client1.AjouterCompte(compte12);
        client2.AjouterCompte(compte21);

        // Créer des transactions
        List<Compte> comptesTransaction1 = new ArrayList<>();
        comptesTransaction1.add(compte11);
        comptesTransaction1.add(compte12);

        List<Compte> comptesTransaction2 = new ArrayList<>();
        comptesTransaction2.add(compte11);
        comptesTransaction2.add(compte21);

        List<Compte> comptesTransaction3 = new ArrayList<>();
        comptesTransaction3.add(compte11);
        comptesTransaction3.add(compte12);
        comptesTransaction3.add(compte21);


        try {
            Transaction transaction1 = new Transaction(comptesTransaction1, "REF001");
            Transaction transaction2 = new Transaction(comptesTransaction2, "REF002");
            Transaction transaction3 = new Transaction(comptesTransaction3, "REF003");

            // Ajouter la transaction au compte
            compte11.AjouterTransaction(transaction1);
            compte12.AjouterTransaction(transaction1);
            compte11.AjouterTransaction(transaction2);
            compte21.AjouterTransaction(transaction2);
            compte12.AjouterTransaction(transaction3);
            compte11.AjouterTransaction(transaction3);
            compte21.AjouterTransaction(transaction3);

            // Afficher les comptes de chaque client
            client1.AfficherComptes();
            client2.AfficherComptes();

            // Afficher les détails de la transaction
            transaction1.afficherDetails();
            transaction2.afficherDetails();
            transaction3.afficherDetails();

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}

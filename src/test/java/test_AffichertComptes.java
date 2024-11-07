import org.example.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test_AffichertComptes {

    @Test
    public void test() {
        /*public static TransactionType CalculerTypeTransaction(List<Compte> comptes) {
            String premiereBanqueNom = comptes.get(0).getBanqueNom();
            boolean memeBanque = comptes.stream().allMatch(c -> c.getBanqueNom().equals(premiereBanqueNom));
            return memeBanque ? TransactionType.VIRINT : TransactionType.VIREST;
        }*/

        Client client = new Client(0, null, null, null, null, null);
        client.AjouterClient(1, "Benanni", "Omar", "576 Rue Mexique", "0601234567", "omar.ben089@email.com");

        // Création de comptes
        Compte compte1 = new Compte("AYC001", new Date(), new Date(), "DH", "Banque Populaire", client);
        Compte compte2 = new Compte("AZC002", new Date(), new Date(), "DH", "Banque Populaire", client);

        // Ajouter des comptes au client
        client.AjouterCompte(compte1);
        client.AjouterCompte(compte2);

        // Créer des transactions
        List<Compte> comptesTransaction = new ArrayList<>();
        comptesTransaction.add(compte1);
        comptesTransaction.add(compte2);

        Transaction transaction1 = new Transaction(comptesTransaction, "REF001");
        Assert.assertEquals( "VIRINT", transaction1.CalculerTypeTransaction(comptesTransaction).name());

    }



}



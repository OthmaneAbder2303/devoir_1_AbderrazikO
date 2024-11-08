package org.example;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Transaction {
    @Expose
    private final TransactionType type;
    @Expose
    private final Date timeStamp;
    @Expose
    private final String ref;
    @JsonManagedReference
    private final List<Compte> comptes;  // Keep the list but limit to 2 accounts

    // Constructor that validates the account count
    public Transaction(List<Compte> comptes, String ref) {

        if (comptes == null || comptes.size() < 2) {
            throw new IllegalArgumentException("La transaction doit être entre plus de deux comptes.");
        }

        this.comptes = comptes;
        this.timeStamp = new Date();
        this.ref = ref;
        this.type = CalculerTypeTransaction(comptes);

    }

    // Getters and Setters
    public TransactionType getType() {
        return type;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }


    public String getRef() {
        return ref;
    }

    public List<Compte> getComptes() {
        return comptes;
    }


    // Keep the transaction type calculation as in the original
    public TransactionType CalculerTypeTransaction(List<Compte> comptes) {
        String premiereBanqueNom = comptes.get(0).getBanqueNom();
        boolean memeBanque = comptes.stream().allMatch(c -> c.getBanqueNom().equals(premiereBanqueNom));
        return memeBanque ? TransactionType.VIRINT : TransactionType.VIREST;
    }

    public void afficherDetails() {
        System.out.println("Détails de la transaction:");
        System.out.println("  Type: " + type);
        System.out.println("  Référence: " + ref);
        System.out.println("  Date: " + timeStamp);
    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

}


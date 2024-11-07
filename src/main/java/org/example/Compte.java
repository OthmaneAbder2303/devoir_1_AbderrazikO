package org.example;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.Expose;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Compte {
    @Expose
    private String numCompte;
    @Expose
    private Date dateCreation;
    @Expose
    private Date dateUpdate;
    @Expose
    private String devise;
    @Expose
    private String banqueNom; // Nom de la banque associée au compte
    @JsonManagedReference
    private List<Transaction> transactions;
    @Expose
    private Client client;

    // Constructor
    public Compte(String numCompte, Date dateCreation, Date dateUpdate, String devise, String banqueNom, Client client) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.devise = devise;
        this.banqueNom = banqueNom; // Initialisation de banqueNom
        this.transactions = new ArrayList<>();
        this.client = client;
    }

    // Getters et Setters
    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getBanqueNom() {
        return banqueNom;
    }

    public void setBanqueNom(String banqueNom) {
        this.banqueNom = banqueNom;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Ajouter une Transaction
    public void AjouterTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public static Compte RechercherCompte(String numcompte, List<Compte> comptes) {

        for(Compte compte : comptes) {
            if(compte.getNumCompte() == numcompte) {
                return compte;
            }
        }
        System.out.println("Compte Inexistant");
        return null;

    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

}

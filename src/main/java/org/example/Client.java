package org.example;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ArrayList;

public class Client {

  private int NumClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;
    List<Compte> comptes;

    // Constructor
    public Client(int numClient, String nom, String prenom, String adresse, String phone, String email) {

        this.NumClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
        this.comptes = new ArrayList<>();

    }

    // Getters and Setters
    public int getNumClient() {
        return NumClient;
    }

    public void setNumClient(int numClient) {
        NumClient = numClient;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    //Ajouter un compte au Client
    public void AjouterCompte(Compte compte) {
        this.comptes.add(compte);
    }

    // Ajouter un nouveau Client
    public void AjouterClient(int numClient, String nom, String prenom, String adresse, String phone, String email) {

        this.NumClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;

    }

    // Search for a client by ID
    public static Client RechercherClient(int numClient, List<Client> clients) {

        for (Client client : clients) {
            if (client.getNumClient() == numClient) {
                return client;
            }
        }
        System.out.println("Client Inexistant");
        return null;

    }

    // Search for an account by number
    public Compte RechercherCompte(String numCompte) {
        for (Compte compte : comptes) {
            if (compte.getNumCompte().equals(numCompte)) {
                return compte;
            }
        }
        return null;
    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }


    // Méthode pour afficher les détails des comptes associés
    public void AfficherComptes() {
        System.out.println("Comptes de " + nom + " " + prenom + ":");
        for (Compte compte : comptes) {
            System.out.println("Numéro de compte: " + compte.getNumCompte() +
                    ", Banque: " + compte.getBanqueNom() +
                    ", Devise: " + compte.getDevise());
            // Afficher les transactions si nécessaire
            if (!compte.getTransactions().isEmpty()) {
                System.out.println("Transactions:");
                for (Transaction transaction : compte.getTransactions()) {
                    System.out.println("  Type: " + transaction.getType() +
                            ", Référence: " + transaction.getRef() +
                            ", Date: " + transaction.getTimeStamp());
                }
            } else {
                System.out.println("  Aucune transaction.");
            }
        }
    }
}

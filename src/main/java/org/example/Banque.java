package org.example;

import java.util.ArrayList;
import java.util.List;

public class Banque {

    private final String nom;
    private final String pays;
    private List<Compte> comptes;

    //Constructor
    public Banque(String nom, String pays) {

        this.nom = nom;
        this.pays = pays;
        this.comptes = new ArrayList<>();

    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public String getPays() {
        return pays;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    //Ajouter un compte à la banque
    public void AjouterCompte(Compte compte) {
        comptes.add(compte);
    }

    //Rechercher un compte dans la banque par n° de compte
    public Compte RechercherCompte(String numCompte) {

        for(Compte compte : comptes) {
            if(compte.getNumCompte() == numCompte) {
                return compte;
            }
        }
        System.out.println("Compte Inexistant");
        return null;

    }

}




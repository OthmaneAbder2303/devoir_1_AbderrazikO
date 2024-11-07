package org.example;

public enum TransactionType {
    VIRINT,  // Transfert interne (même banque)
    VIREST,  // Transfert externe (différentes banques)
    VIRMULTA // Transfert multiple (plusieurs comptes dans différentes banques)
};

package org.example.kataoptionalstreams.NullPointerDemo;


import java.util.Optional;

public class NullPointerDemo {
    public static void main(String[] args) {

        // === Cas classique avec null ===
        String entreprise = null;

        //  Provoque un NullPointerException
        System.out.println("Nom en majuscules : " + entreprise.toUpperCase());

        // === Correction avec Optional (à activer en live) ===
        /*
        Optional<String> entreprise = Optional.ofNullable(null);

        String nom = entreprise.orElse("Valeur par défaut");
        System.out.println(" Nom affiché avec Optional : " + nom.toUpperCase());
        */
    }
}

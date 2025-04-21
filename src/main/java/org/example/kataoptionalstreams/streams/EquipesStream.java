package org.example.kataoptionalstreams.streams;

import java.util.*;
import java.util.stream.Collectors;

public class EquipesStream {
    public static void main(String[] args) {
        System.out.println("========= Traitement des ÉQUIPES chez PROXIAD =========");

        // getNomParDefaut Structure de données : équipes par département
        List<List<String>> equipes = List.of(
                List.of("IT", "RH", "Qualité"),
                List.of("IT", "Marketing"),
                List.of("RH", "Production")
        );

        // getNomParDefaut Étape 1 : Aplatir, supprimer doublons, collecter
        List<String> equipesUniques = equipes.stream()
                .flatMap(List::stream)          // Fusionne toutes les listes
                .distinct()                     // Supprime les doublons
                .collect(Collectors.toList());  // Résultat dans une nouvelle liste

        System.out.println("\ngetNomParDefaut Équipes uniques (après flatMap + distinct) :");
        equipesUniques.forEach(equipe -> System.out.println("- " + equipe));

        // getNomParDefaut Étape 2 : Compter le nombre total d'équipes uniques
        long total = equipesUniques.stream().count();
        System.out.println("\n Nombre total d'équipes uniques : " + total);

        // getNomParDefaut Étape 3 : Calcul de la somme des longueurs de noms > 2 caractères
        int sommeLongueurs = equipesUniques.stream()
                .map(String::length)               // Longueur de chaque nom
                .filter(len -> len > 2)            // Garde ceux supérieurs à 2 lettres
                .reduce(0, Integer::sum);          // Additionne les longueurs

        System.out.println(" Somme des longueurs de noms > 2 caractères : " + sommeLongueurs);

       // getNomParDefaut Résumé final
        System.out.println("\n ==> 📊 Résumé des opérations Stream :");
        System.out.println("+-----------------------------------------------+-----------------------------------------------+");
        System.out.println("| Opération                                     | Résultat                                      |");
        System.out.println("+-----------------------------------------------+-----------------------------------------------+");
        System.out.printf("| Équipes uniques (flatMap + distinct)          | %s%n", equipesUniques);
        System.out.printf("| Nombre total (count)                          | %d%n", total);
        System.out.printf("| Somme longueurs > 2 lettres (map + filter + reduce) | %d%n", sommeLongueurs);
        System.out.println("+-----------------------------------------------+-----------------------------------------------+");

    }
}

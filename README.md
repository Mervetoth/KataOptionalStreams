
# Kata Java – Optional & Stream 

Ce projet regroupe une série de petits programmes Java pour comprendre et démontrer l'utilisation des classes `Optional` et des `Streams` introduits à partir de Java 8.
---

##  Structure du projet

```
src/
├── optional/         // Démo de toutes les méthodes Optional
│   └── ChatOptional.java
├── streams/          // Traitement Stream sur des listes imbriquées
│   └── EquipesStream.java
├── combined/         // Exemple combiné Optional + Stream
│   └── ProxiadOptionalStream.java
├── benchmark/        // Benchmark orElse vs orElseGet
│   └── OrElseVsOrElseGetSimple.java
```

---

## ✅ Nous allons apprendre
###  `Optional`
- isPresent()
- ifPresent()
- orElse()
- orElseGet()
- orElseThrow()
- map()
- flatMap()

###  `Stream`
- filter()
- map()
- flatMap()
- distinct()
- reduce()
- collect()
- count()
- forEach()

###  Combinaisons
- `Optional.stream()` + `flatMap()` pour ignorer les valeurs absentes
- Pipelines Stream fluides et lisibles

---

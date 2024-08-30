## Tables

1. Users: stock les infos sur les clients

| Nom de la colonne | Type de donnée | Description             |
| ----------------- | -------------- | ----------------------- |
| id                | BIGINT         | Clé primaire            |
| username          | VARCHAR        | Pseudo unique du client |
| email             | VARCHAR        | Email du client         |
| password          | VARCHAR        | MDP du client           |
| created_at        | TIMESTAMP      | Date de création        |
| updated_at        | TIMESTAMP      | Date de modification    |

2. Poducts : stock les infos sur les produits

| Nom de la colonne | Type de donnée | Description            |
| ----------------- | -------------- | ---------------------- |
| id                | BIGINT         | Clé primaire           |
| name              | VARCHAR        | Nom du produit         |
| description       | TEXT           | Desctiption du produit |
| price             | DECIMAL        | Prix du produit        |
| stock_qty         | INT            | Quantité en stock      |
| created_at        | TIMESTAMP      | Date de création       |
| updated_at        | TIMESTAMP      | Date de modification   |

3. Orders: stock les infos sur les commandes faites par les clients

| Nom de la colonne | Type de donnée | Description             |
| ----------------- | -------------- | ----------------------- |
| id                | BIGINT         | Clé primaire            |
| user_id           | BIGINT         | Clé secondaire          |
| total_amount      | DECIMAL        | Montant total           |
| status            | VARCHAR        | Status (ex: en cours..) |
| created_at        | TIMESTAMP      | Date de création        |
| updated_at        | TIMESTAMP      | Date de modification    |

4. Order items: stock les infos sur les produits inclus dans chaque commande:

| Nom de la colonne | Type de donnée | Description                 |
| ----------------- | -------------- | --------------------------- |
| **id **           | BIGINT         | Clé primaire                |
| **order_id**      | BIGINT         | Clé secondaire =>`orders`   |
| **product_id**    | BIGINT         | Clé secondaire =>`products` |
| **quantity**      | INT            | Qté de produits commandée   |
| price             | DECIMAL        | Prix du produit             |
| created_at        | TIMESTAMP      | Date de création            |
| updated_at        | TIMESTAMP      | Date de modification        |

## Relations

` users` ->` orders`: un user peut faire plusieurs commandes

- `order` -> `order_items`: une commande peut avoir plusieurs items
- `products` -> `order_items`: un produit peut être commandé plusieurs fois dans la journée

`spring.jpa.hibernate.ddl-auto`: Cette propriété est utilisée pour spécifier la stratégie de génération du schéma de la BDD lors du démarrage de l'application Hibernate, l'ORM utilisé par défaut dans Spring Boot, peut automatiquement créer, mettre à jour, valider ou gérer le schéma de la BDD en fonction de cette propriété.

1.  `none`: Désactive la gestion automatique du schéma par Hibernate. Aucune modification du schéma de la BDD ne sera effectué au démarrage de l'application.

2.` validate`: hibernate vérifie que le schéma de la BDD correspond à la structure définie dans les entités JPA. Aucune modification du schéma ne sera effectuée, mais si le schéma est incorrecte ou ne correspond pas, une exception est levée

3.`update`: Hibernate met à jour le schéma de la BDD pour qu'il corresponde aux entités JPA définies. Cela inclut l'ajout de nouvelles tables, colonnes, ou contraintes, mais ne supprime ni ne modifie les tables ou colonees existantes.

4. `create`: Hibernate supprime le schéma existant et crée un nouveau schéma à partir des entités JPA définies. Cela implique de perdre toutes les données existantes puisque le schéma est recréé à chaque démarrage de l'application.
5. `create-drop`: Similaire à `create`; mais avec la particularité que le schéma est supprimé lorsque l'application est arrêtée. Cela signifie que la BDD est recréée à chaque démarrage et supprimée à chaque arrêt de l'application.

## Schéma d'une BDD

Le `schéma` d'une BDD est une représentation de la structure logique des données, incluant les tables, les colonnes, les relations entre les tables, et les contraintes. Il définit comment les données sont organisées, interconnectés, et gérées pour assurer leur cohérence et intégrité.


## Quelques annotations 
`@Table`:  L'annotation `@ Table` vous permet de spécifier les détails de la table qui seront utilisés pour conserver l'entité dans la base de données.

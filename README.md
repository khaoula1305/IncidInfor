# IncidInfor
Le projet s’agit de créer une application capable de gérer les différents incidents informatiques.

Les ressources de l'application sont:
/incident
/collaborateur
/solution
POST /solution
GET /solution/{solutionId}
PUT /solution/{solutionId}
DELETE /solution/{solutionId}

Nous voulons donc pouvoir appeler notre Microservice sur les URLs suivantes :

Requête GET à /Produits : affiche la liste de tous les produits ;

Requête GET à /Produits/{id} : affiche un produit par son Id ;

Requête PUT à /Produits/{id} : met à jour un produit par son Id ;

Requête POST à /Produits : ajoute un produit ;

Requête DELETE à /Produits/{id} : supprime un produit par son Id.

Produit vaut dire incident.

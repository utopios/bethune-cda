## <center>Tp hôtel</center>

On désire informatiser la gestion des réservations et des séjours pour un l’hôtel :

Réaliser une application web en spring mvc de gestion des réservations.

1. Gestion des Clients

   a. Affichage de la liste des clients, et détail de chaque client (Réservations, annulations).

   b. Ajout d’un nouveau client

2. Gestion des réservations

   a. Possibilité d’ajouter une réservation

   b. Possibilité de changer le statut de réservation

   c. Afficher la liste des réservations

**Pour les besoins du TP:**

Au démarrage de l’application on crée l’hôtel avec, par exemple 20 chambres au hasard.

1. Proposez une modélisation des différentes entités possibles.
    - La liste des entités :
      - Client (id, nom, prenom, telephone, reservations)
      - Chambre (id, numero, nb_occ, prix, dispo)
      - Reservation (id, chambres, client, statut)
      - Hotel (optionnel)
2. Réalisez la couche repositories.
3. Développez la couche service en utilisant le paradigme TDD
4. Réalisez la couche contrôleur et vue.
## TP 1 Début Architecture Micro-Services

Le but du TP est de créer une application de gestion clients, produits et commandes en plusieurs micro-services.

1. Un micro service en spring qui permet de créer des produits, mettre à jour le stock et récupérer les informations des produits.
2. Un micro service en spring pour créer, récupérer les informations de clients.
3. Un micro service en nodejs (express) pour créer une commande.
   - Ce micro service reçoit les ids des produits, id du client pour créer une commande.
   - Il récupère les informations des produits et clients à partir des deux premiers micro-services.
   - Il enregistre chaque commande dans un fichier json.
   - Il demande la mise à jour du stock pour chaque produit de la commande.

4. On souhaite ajouter une seule porte d'entrée(API-GATEWAY) pour la totalité des micro-services. Cette porte doit permettre :
   - Gestion des clients.
   - Gestion des produits.
   - Gestion des commandes.

5. On souhaite développer une application FRONT en Angular pour interagir avec nos micro-services.
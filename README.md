# GloomyJva

## Sommaire

  1. Login / Logout / Register
  2. Google login
  3. Gestion des dossiers
  4. Gestion des fichiers
  5. Gestion des utilisateurs
  
## I/ Login, logout, register

Permet la création, le "login" et le "logout" de l'utilisateur.
Création d'un utilisateur avec les propriétés suivantes :
  * Prénom
  * Nom
  * Adresse mail
  * Nom d'utilisateur
  * Mot de passe
  * Confirmation du mot de passe
  
Le "login" va chercher si l'utilisateur exite en base de donnée, si oui, un attribut de session et créé, sinon, on revoie sur la page de login.
Le "logout" détruit la variable de session utlisateur.

## II/ Google login

Permet la création/connection d'un utilisateur avec son compte google. Nous utilisons le protocole OAUTH 2.0 pour récuperer les informations de notre utilisateur google.

NB : si l'adresse mail google était déjà utiliser sur le site avant, la connection google ne créer pas de nouveau compte mais utlise celui déjà existant.

## III/ Gestion des dossiers

Permet à l'utilisateur de créer, naviguer, renommer et supprimer ses dossiers.
Les dossiers peuvent comprendrent des fichiers.
Les dossiers peuvent être "shared".

NB : si un dossier est supprimé, tout les sous dossiers et les fichiers compris dedans sont supprimés.

## IV/ Gestion des fichiers

L'utilisateur peut envoyer des fichiers dont la taille n'est pas supérieure à 1GB.
L'utilisateur peut télécharger des fichiers.
L'utilisateur peut renommer ses fichiers.

NB : si l'utilisateur n'a plus de place pour envoyer des fichiers, le fichier n'est pas envoyé.

## V/ Gestion des utilisateurs

L'utilisateur peut mêttre à jour son nom, prénom et son nom d'utilisateur.
L'utilisateur peut également mêttre à jour son mot de passe.

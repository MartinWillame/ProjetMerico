--
-- File generated with SQLiteStudio v3.1.1 on ven. juin 29 17:32:26 2018
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Dés
CREATE TABLE Dés (
    Idd       INTEGER PRIMARY KEY
                      NOT NULL
                      UNIQUE,
    Nbr_Lance INTEGER NOT NULL
                      DEFAULT '0',
    Valeur1   INTEGER NOT NULL
                      DEFAULT '6',
    Valeur2   INTEGER NOT NULL
                      DEFAULT '6'
);


-- Table: Lieux
CREATE TABLE Lieux (
    Idl   INTEGER PRIMARY KEY
                  NOT NULL
                  UNIQUE,
    Photo BLOB,
    Nom   TEXT    NOT NULL
                  UNIQUE
);


-- Table: ModeDeJeu
CREATE TABLE ModeDeJeu (
    Idm INTEGER PRIMARY KEY
                NOT NULL
                UNIQUE,
    Nom TEXT    NOT NULL
                UNIQUE
);


-- Table: Partie
CREATE TABLE Partie (
    Idp      INTEGER PRIMARY KEY
                     NOT NULL
                     UNIQUE,
    Idl      INTEGER NOT NULL
                     REFERENCES Lieux,
    Nbr_Tour INTEGER NOT NULL
                     DEFAULT '0',
    Idu      INTEGER REFERENCES Utilisateur,
    Idd      INTEGER NOT NULL
                     UNIQUE
                     REFERENCES Dés,
    Idm      INTEGER NOT NULL
                     REFERENCES ModeDeJeu
);


-- Table: Utilisateur
CREATE TABLE Utilisateur (
    Idu         INTEGER PRIMARY KEY
                        NOT NULL
                        UNIQUE,
    Photo       BLOB,
    Nom         TEXT    NOT NULL,
    Prenom      TEXT    NOT NULL,
    Ville       TEXT    NOT NULL,
    Unnif       TEXT    NOT NULL,
    Identifiant TEXT    NOT NULL
                        UNIQUE
);


-- Table: UtilisateurDés
CREATE TABLE UtilisateurDés (
    Idu           INTEGER REFERENCES Utilisateur,
    Idd           INTEGER REFERENCES Dés,
    Nbr_Merico    INTEGER NOT NULL
                          DEFAULT '0',
    Nbr_31        INTEGER NOT NULL
                          DEFAULT '0',
    Nbr_Beau_Jeu  INTEGER NOT NULL
                          DEFAULT '0',
    Dernier_Score INTEGER NOT NULL
                          DEFAULT '0'
);


-- Table: UtilisateurPartie
CREATE TABLE UtilisateurPartie (
    Idu         INTEGER REFERENCES Utilisateur,
    Idp         INTEGER REFERENCES Partie,
    Nbr_Merico  INTEGER NOT NULL
                        DEFAULT '0',
    Nbr_31      INTEGER NOT NULL
                        DEFAULT '0',
    Nbr_Defaite INTEGER NOT NULL
                        DEFAULT '0',
    Nbr_Refus   INTEGER NOT NULL
                        DEFAULT '0'
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;

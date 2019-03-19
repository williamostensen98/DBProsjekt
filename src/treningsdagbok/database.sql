DROP DATABASE IF EXISTS treningsdagbok;
CREATE SCHEMA treningsdagbok;
USE treningsdagbok;

CREATE TABLE Treningsokt (

                           Tidsstempel DATETIME,

                           Varighet INTEGER NOT NULL,

                           Form INTEGER NOT NULL CHECK (form BETWEEN 1 and 10),

                           Prestasjon INTEGER NOT NULL CHECK (prestasjon BETWEEN 1 and 10),

                           Notat TEXT,

                           CONSTRAINT Treningsokt_PK PRIMARY KEY(Tidsstempel));



CREATE TABLE ovelse (

                      Navn VARCHAR(30),

                      Beskrivelse VARCHAR(100),

                      AntallKilo INTEGER,

                      AntallSett INTEGER,

                      ovelsesType BIT NOT NULL,

                      ApparatID INTEGER,

                      CONSTRAINT ovelse_PK PRIMARY KEY(Navn));



CREATE TABLE ovelseGruppe(

                           GruppeID INTEGER NOT NULL AUTO_INCREMENT,

                           Muskelgruppe VARCHAR(30),

                           CONSTRAINT ovelseGruppe_PK PRIMARY KEY(GruppeID));



CREATE TABLE Apparat (

                       ApparatID INTEGER NOT NULL AUTO_INCREMENT,

                       Apparatnavn VARCHAR(30),

                       CONSTRAINT Apparat_PK PRIMARY KEY(ApparatID));



CREATE TABLE ovelseIokt (

                          Tidsstempel DATETIME,

                          Navn VARCHAR(30),

                          CONSTRAINT ovelseokt_PK PRIMARY KEY(Tidsstempel, Navn),

                          CONSTRAINT ovelseokt_FK1 FOREIGN KEY(Tidsstempel) REFERENCES Treningsokt(Tidsstempel),

                          CONSTRAINT ovelseokt_FK2 FOREIGN KEY(Navn) REFERENCES ovelse(Navn));



CREATE TABLE ovelseIGruppe (

                             GruppeID INTEGER NOT NULL,

                             Navn VARCHAR(30),

                             CONSTRAINT Apparatovelse_PK PRIMARY KEY(GruppeID, Navn),

                             CONSTRAINT Apparatovelse_FK1 FOREIGN KEY(GruppeID) REFERENCES ovelseGruppe(GruppeID),

                             CONSTRAINT Apparatovelse_FK2 FOREIGN KEY(Navn) REFERENCES ovelse(Navn));

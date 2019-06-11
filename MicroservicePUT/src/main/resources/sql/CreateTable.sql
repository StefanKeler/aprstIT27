DROP TABLE IF EXISTS proizvodjac CASCADE;
DROP TABLE IF EXISTS proizvod CASCADE;
DROP TABLE IF EXISTS racun CASCADE;
DROP TABLE IF EXISTS stavka_racuna CASCADE;

DROP SEQUENCE IF EXISTS proizvodjac_seq CASCADE;
DROP SEQUENCE IF EXISTS proizvod_seq CASCADE;
DROP SEQUENCE IF EXISTS racun_seq CASCADE;
DROP SEQUENCE IF EXISTS stavka_racuna_seq CASCADE;

CREATE TABLE proizvodjac (
    id INTEGER NOT NULL, 
    naziv VARCHAR(50) NOT NULL,
    adresa VARCHAR(200) NOT NULL,
    kontakt VARCHAR(100) NOT NULL
);

CREATE TABLE proizvod (
    id INTEGER NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    proizvodjac INTEGER NOT NULL
);

CREATE TABLE racun (
    id INTEGER NOT NULL,
    datum DATE NOT NULL,
    nacin_placanja VARCHAR(200) NOT NULL
);

CREATE TABLE stavka_racuna (
    id INTEGER NOT NULL,
    redni_broj INTEGER NOT NULL,
    kolicina NUMERIC NOT NULL,
    jedinica_mere VARCHAR(50) NOT NULL,
    cena NUMERIC NOT NULL,
    racun INTEGER NOT NULL,
    proizvod INTEGER NOT NULL
);

ALTER TABLE proizvodjac ADD CONSTRAINT PK_Proizvodjac
PRIMARY KEY(id);
ALTER TABLE proizvod ADD CONSTRAINT PK_Proizvod
PRIMARY KEY(id);
ALTER TABLE racun ADD CONSTRAINT PK_Racun
PRIMARY KEY(id);
ALTER TABLE stavka_racuna ADD CONSTRAINT PK_Stavka_Racuna
PRIMARY KEY(id);
ALTER TABLE proizvod ADD CONSTRAINT FK_Proizvod_Proizvodjac
FOREIGN KEY(proizvodjac) REFERENCES proizvodjac(id) ON DELETE SET NULL;
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Racun
FOREIGN KEY(racun) REFERENCES racun(id) ON DELETE SET NULL;
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Proizvod
FOREIGN KEY(proizvod) REFERENCES proizvod(id) ON DELETE SET NULL;

CREATE INDEX IDXFK_Proizvod_Proizvodjac
ON proizvod (proizvodjac);
CREATE INDEX IDXFK_Stavka_Racuna_Racun
ON stavka_racuna (racun);
CREATE INDEX IDXFK_Stavka_Racuna_Proizvod
ON stavka_racuna (proizvod);
CREATE SEQUENCE proizvodjac_seq
INCREMENT 1;
CREATE SEQUENCE proizvod_seq
INCREMENT 1;
CREATE SEQUENCE racun_seq
INCREMENT 1;
CREATE SEQUENCE stavka_racuna_seq
INCREMENT 1;

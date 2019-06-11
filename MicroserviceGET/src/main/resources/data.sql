
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'AD Imlek', 'Industrijsko naselje bb, Padinska skela, Beograd', '+381 11 30 50 505');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Henkel Srbija', 'Bulevar oslobodenja 383, 11040 Beograd, Srbija', '+381 11 20 72 200');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Fruit D.O.O.', 'Justina Popovica 3, 11080 Zemun, Beograd', '+381 11 3143 171');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'CENTROPROIZVOD', 'DOBANOVACKI PUT B.B. 11271, SURCIN', '+381 11 3773 600');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(-100, 'Proizvodja test', 'Adresa test', 'Kontakt test');

INSERT INTO "proizvod" ("id","naziv","proizvodjac")
VALUES
    (nextval('proizvod_seq'), 'Moja Kravica sveze mleko 2,8% MM 1l', 1),
    (nextval('proizvod_seq'), 'Moja Kravica dugotrajno mleko 3,2% MM 1l', 1),
    (nextval('proizvod_seq'), 'Moja Kravica Beli sir 1kg', 1),

	(nextval('proizvod_seq'), 'Persil Regular Prasak 2kg', 2),
    (nextval('proizvod_seq'), 'Persil Regular Gel 2l', 2),
    (nextval('proizvod_seq'), 'Persil Duo-Caps Color pak', 2),


    (nextval('proizvod_seq'), 'Jagoda', 3),
    (nextval('proizvod_seq'), 'Jabuka', 3),
    (nextval('proizvod_seq'), 'Kajsija', 3),

    (nextval('proizvod_seq'), 'Slag', 4),
    (nextval('proizvod_seq'), 'Puding vanila', 4),
    (nextval('proizvod_seq'), 'Puding jagoda', 4),
    (-100, 'proizvod test', -100);
   



INSERT INTO "racun" ("id", "datum", "nacin_placanja")
VALUES 
    (nextval('racun_seq'),  to_date('20.03.2017.', 'dd.mm.yyyy.'), 'kes'),
    (nextval('racun_seq'),  to_date('25.03.2017.', 'dd.mm.yyyy.'), 'kartica'),
    (nextval('racun_seq'),  to_date('04.04.2017.', 'dd.mm.yyyy.'), 'cek'),
    (-100, to_date('28.04.2017.', 'dd.mm.yyyy.'), 'kes');

INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES 
    (nextval('stavka_racuna_seq'), 1, 1, 'komad', 100, 1, 7),
    (nextval('stavka_racuna_seq'), 2, 1, 'komad', 150, 1, 8),
    (nextval('stavka_racuna_seq'), 3, 1, 'komad', 540, 1, 9),

    (nextval('stavka_racuna_seq'), 1, 2, 'komad', 150, 2, 1),
    (nextval('stavka_racuna_seq'), 2, 2, 'komad', 200, 2, 2),
    (nextval('stavka_racuna_seq'), 3, 5, 'komad', 500, 2, 3),

    (nextval('stavka_racuna_seq'), 1, 5, 'komad', 50, 3, 4),
    (nextval('stavka_racuna_seq'), 2, 5, 'komad', 60, 3, 5),
    (nextval('stavka_racuna_seq'), 3, 6, 'komad', 70, 3, 6),
    
    (-100, 1,1,'test','2','-100',-100);  
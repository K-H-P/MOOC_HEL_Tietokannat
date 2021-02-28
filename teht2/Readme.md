# SQL Skeema


## Tehtävänanto

| Kriteerit | Valmis |
|-----------|--------|
| 1. Verkkokaupassa on tuotteita, joilla on nimi, kuvaus ja hinta. | [X] |
| 2. Käyttäjä pystyy etsimään tuotteita ja hänellä on ostoskori, johon voi lisätä ja poistaa tuotteita. | [X] |
| 3. Tuotteita voidaan luokitella tuoteryhmiin. Sama tuote voi kuulua useaan tuoteryhmään. | [X] |
| 4. Kun tilaus on valmis, käyttäjä pystyy antamaan yhteystietonsa ja pankkikorttinsa tiedot, minkä jälkeen tilaus siirtyy käsittelyyn. | [X] |
| 5. Käyttäjä pystyy arvostelemaan tuotteita ja lukemaan muiden käyttäjien antamia arvosteluja. | [X] |
| 6. Tuotteista voidaan muodostaa tarjouspaketteja, joissa tietyt tuotteet saa tiettyyn hintaan pakettina. | [ ] |
| 7. Käyttäjä näkee tuotteen kuvauksen yhteydessä, paljonko tuotetta on jäljellä missäkin verkkokaupan varastossa. | [X] |
| 8. Käyttäjä voi saada alennuskoodin, jonka voi syöttää tilauksen yhteydessä. Alennuskoodin voi käyttää vain kerran. | [X] |
| 9. Käyttäjä näkee tuotteen yhteydessä esimerkkejä, mitä tuotteita muut tämän tuotteen ostaneen asiakkaat ovat ostaneet. | [ ] |


**Käyttäjä**

Tehdään ensin *Käyttäjä* taulu, johon tallennetaan käyttäjän tiedot (ei hyväksytä null arvoja):
- id - uniikki id käyttäjän tunnsitamiseen
- etunimi - käyttäjän etunimi
- sukunimi - käyttäjän sukunimi
- puhelin - käyttäjän puhelinumero
- sähköposti - käyttäjän s-posti
- osoite1 - käyttäjän katuosoite
- osoite2 - käyttäjän rappu/tarkennus
- kaupunki - käyttjän kaupunki 

```
CREATE TABLE Kayttaja (
    kayttajaId INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    etunimi VARCHAR(50) NOT NULL,
    sukunimi VARCHAR(50) NOT NULL,
    puhelin VARCHAR(12) UNIQUE NOT NULL,
    email VARCHAR(50) NOT NULL,
    osoite1 VARCHAR(50) NOT NULL,
    osoite2 VARCHAR(50),
    kaupunki VARCHAR(50) NOT NULL
);
```

**Verkkokaupassa on tuotteita, joilla on nimi, kuvaus ja hinta.**

Tehdään *Tuotteet* taulu, johon tallennetaan tuotteen tiedot:
- id - uniikki id tuotteen tunnistamiseen
- tuote - tuotteen nimi, joka näytetään verkkokaupassa
- kuvaus- tuotteen lyhyt kuvaus
- hinta - tuotteen hinta euroina
- tuotteenMaara - tuotteiden määrä yhteensä (viittaus)
- alennus - mahdollinen kampanja alennus tuotteessa

```
CREATE TABLE Tuotteet (
    tuoteId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuote TEXT NOT NULL,
    kuvaus TEXT,
    hinta FLOAT,
    tuotteenMaara INT REFERENCE Toimipaikat(tuotteenMaara) ,
    alennus FLOAT
);
```

**Käyttäjä pystyy etsimään tuotteita ja hänellä on ostoskori, johon voi lisätä ja poistaa tuotteita.**

Tehdään *Ostoskori* taulu, johon tallennetaan käyttäjän ostokset:
- Id - uniikki id ostoskorin tunnistamiseen
- kayttajaId - uniikki id käyttäjän tunnistamiseen (viittaus), jos on "kirjautuneena" (kirjautumis logiikka puuttuu)
- sessioId - uniikki id session tunnsitamiseen, jotta ostoskori ei "häviä"
- tuoteId - uniikki id tuotteen tunnistamiseen (viitaus)
- tuote - tuotteen nimi (viittaus)
- hinta - tuotteen hinta (viittaus)
- alennus - tuotteen mahdollinen alennus (viittaus)
- ostoMaara - ostoskorissa olevien tuotteiden määrä

```
CREATE TABLE Ostoskori (
    ostoskoriID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    kayttajaId INT FOREIGN KEY REFERENCE Kayttaja(kayttajaId),
    sessioId VARCHAR(100),
    tuoteId INT FOREIGN KEY REFERENCE Tuotteet(tuoteId),
    tuote TEXT REFERENCE Tuotteet(tuote),
    hinta FLOAT REFERENCE Tuotteet(hinta),
    alennus FLOAT REFERENCE Tuotteet(alennus),
    ostoMaara INT
);
```

**Tuotteita voidaan luokitella tuoteryhmiin. Sama tuote voi kuulua useaan tuoteryhmään.**

Tehdään *Tuoteryhmä* taulu, johon tallennetaan tuotteiden kategoriat:
- id - uniikki id ryhmän tunnistamiseen
- tuoteId - uniikki id tunnistamaan tuote (viittaus)
- otsikko - tuoteryhmän nimi
- sisalto - tarkemmat tiedot, mitä kuuluu tuoteryhmään

```
CREATE TABLE Tuoteryhma (
    tuoteryhmaId INT PRIMARY KEY NOT NULL,
    tuoteId INT FOREIGN KEY REFERENCE Tuote(tuoteid),
    otsikko VARCHAR(25) NOT NULL,
    sisalto VARCHAR(100)
);
```

**Kun tilaus on valmis, käyttäjä pystyy antamaan yhteystietonsa ja pankkikorttinsa tiedot, minkä jälkeen tilaus siirtyy käsittelyyn.**
**Käyttäjä voi saada alennuskoodin, jonka voi syöttää tilauksen yhteydessä. Alennuskoodin voi käyttää vain kerran.**

Tehdään *Tilaus* taulu, johon sisällytetään käyttäjän tekemä tilaus, maksu ja sen tilanne/status:
- tilausId - uniikki id tilaukselle
- ostoskoriId - uniikki id tunnistamaan ostoskori, joka liittyy tilaukseen (viittaus)
- kayttajaid - uniikki id käyttäjän tunnsitamiseen (viittaus)
- etunimi - käyttäjän etunimi (viittaus)
- sukunimi - käyttäjän sukunimi (viittaus)
- puhelin - käyttäjän puhelinumero (viittaus)
- sähköposti - käyttäjän s-posti (viittaus)
- osoite1 - käyttäjän katuosoite (viittaus)
- osoite2 - käyttäjän rappu/tarkennus (viittaus)
- kaupunki - käyttjän kaupunki (viittaus)
- maksutapa - käyttäjän maksutapa: käteinen tai kortti
- tila - tilauksen tila: odottaa maksua, käsittelyssä, lähetetty, valmis
- paivamaara - tilauksen päivämäärä (luonti)
- muokkausPVM - tilauksen statuksen muutos
- personalAlennus - käyttäjän antama alennuskoodi

```
CREATE TABLE Tilaus (
    tilausId INT PRIMARY KEY NOT NULL,
    ostoskoriId INT FOREIGN KEY REFERENCE Ostoskori(ostoskoriId),
    kayttajaId INT  FOREIGN KEY REFERENCE Kayttaja(kayttajaId),
    etunimi VARCHAR(50) NOT NULL REFERENCE Kayttaja(etunimi),
    sukunimi VARCHAR(50) NOT NULL REFERENCE Kayttaja(sukunimi),
    puhelin VARCHAR(12) UNIQUE NOT NULL REFERENCE Kayttaja(puhelin),
    email VARCHAR(50) NOT NULL REFERENCE Kayttaja(email),
    osoite1 VARCHAR(50) NOT NULL REFERENCE Kayttaja(osoite1),
    osoite2 VARCHAR(50) REFERENCE Kayttaja(osoite2),
    kaupunki VARCHAR(50) NOT NULL REFERENCE Kayttaja(kaupunki),
    maksutapa INT (2) NOT NULL,
    tila INT (5) NOT NULL,
    paivamaara DATETIME NOT NULL,
    muokkausPVM DATETIME NOT NULL.
    personalAlennus FLOAT DEFAULT NULL
)
```

**Käyttäjä pystyy arvostelemaan tuotteita ja lukemaan muiden käyttäjien antamia arvosteluja.**

Tehdään *tuoteArvostelut* taulu, johon tallennetaan tuotteiden arvostelut käyttäjiltä:
- id - uniikki id tuotteiden arvosteluille
- tuoteId - uniikki id tunnistamaan tuote, jota arvostellaan (viittaus)
- otsikko - tuotearvostelun otsikko
- sisalto - tuotearvostelu sisalto/sanallinen arvostelu
- arvostelu - numeraalinen arvostelu 0-5
- paivamaara - arvostelun päivämäärä

```
CREATE TABLE TuoteArvostelut (
    tuoteArvosteluId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuoteId INT FOREIGN KEY REFERENCE Tuote(tuoteID),
    otsikko VARCHAR(25) NOT NULL,
    sisalto VARCHAR(500),
    arvostelu INT(6) NOT NULL DEFAULT 0,
    paivamaara DATETIME NOT NULL
);
```

**Tuotteista voidaan muodostaa tarjouspaketteja, joissa tietyt tuotteet saa tiettyyn hintaan pakettina.**

Tehdään *Tarjoukset* taulu, jossa on kerättynä yhteisalennukset omaavat tuotteet:
- id - uniikki id tunnistamaan tarjous
- tuoteId - uniikki id tunnistamaan tuote, joka kuuluu tarjoukseen (viittaus)
- tuote - tuotteen nimi (viittaus)
- hinta - tuotteiden hinta alennuksella
- yhteisAlennus - tuotteiden alennus prosentteina

```
CREATE TABLE Tarjoukset (
    tarjouksetId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuoteId INT FOREIGN KEY REFERENCE Tuotteet(tuoteId),
    otsikko VARCHAR(25) NOT NULL,
    tuote TEXT Reference Tuotteet(tuote),
    hinta FLOAT NOT NULL,
    yhteisAlennus FLOAT NOT NULL
);
```


**Käyttäjä näkee tuotteen kuvauksen yhteydessä, paljonko tuotetta on jäljellä missäkin verkkokaupan varastossa.**

Tehdään *Toimipaikat* taulu, johon lisätään toimipaikat sekä viittaukset varastotilanteesta:
- id - uniikki id toimipaikoille
- toimipaikka - toimipaikan paikkakunta
- nimi - toimipaikan nimi
- tuoteId - tuotteiden uniikki id (viittaus)
- tuotteenMaara - tuotteiden määrä kpl

```
CREATE TABLE Toimipaikat (
    toimipaikkaId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    toimipaikka VARCHAR(25) NOT NULL,
    nimi VARCHAR (25),
    tuoteId INT FOREIGN KEY REFERENCE Tuotteet(tuoteId),
    tuotteenMaara INT REFERENCE Tuotteet(tuotteenMaara)
)
```

**Käyttäjä näkee tuotteen yhteydessä esimerkkejä, mitä tuotteita muut tämän tuotteen ostaneen asiakkaat ovat ostaneet.**

Tehdään *Ehdotukset* taulu, jossa on kerättynä ehdotuksia käyttäjälle:
- id - uniikki id tunnistamaan ehdotus
- tuoteId - uniikki id tunnistamaan tuote, joka kuuluu ehdotukseen (viittaus)
- tuote - tuotteen nimi (viittaus)

```
CREATE TABLE Ehdotukset (
    ehdotuksetId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuoteId INT FOREIGN KEY REFERENCE Tuotteet(tuoteId),
    otsikko VARCHAR(25) NOT NULL,
    tuote TEXT Reference Tuotteet(tuote)
);
```
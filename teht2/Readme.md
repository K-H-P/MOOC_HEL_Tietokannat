# SQL Skeema


## Tehtävänanto

| Kriteerit | Valmis |
|-----------|--------|
| 1. Verkkokaupassa on tuotteita, joilla on nimi, kuvaus ja hinta. | [X] |
| 2. Käyttäjä pystyy etsimään tuotteita ja hänellä on ostoskori, johon voi lisätä ja poistaa tuotteita. | [ ] |
| 3. Tuotteita voidaan luokitella tuoteryhmiin. Sama tuote voi kuulua useaan tuoteryhmään. | [X] |
| 4. Kun tilaus on valmis, käyttäjä pystyy antamaan yhteystietonsa ja pankkikorttinsa tiedot, minkä jälkeen tilaus siirtyy käsittelyyn. | [ ] |
| 5. Käyttäjä pystyy arvostelemaan tuotteita ja lukemaan muiden käyttäjien antamia arvosteluja. | [X] |
| 6. Tuotteista voidaan muodostaa tarjouspaketteja, joissa tietyt tuotteet saa tiettyyn hintaan pakettina. | [ ] |
| 7. Käyttäjä näkee tuotteen kuvauksen yhteydessä, paljonko tuotetta on jäljellä missäkin verkkokaupan varastossa. | [ ] |
| 8. Käyttäjä voi saada alennuskoodin, jonka voi syöttää tilauksen yhteydessä. Alennuskoodin voi käyttää vain kerran. | [ ] |
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

Tehdään *Tuote* taulu, johon tallennetaan tuotteen tiedot:
- id - uniikki id tuotteen tunnistamiseen
- tuote - tuotteen nimi, joka näytetään verkkokaupassa
- kuvaus- tuotteen lyhyt kuvaus
- hinta - tuotteen hinta euroina
- määrä - kpl määrä tuotteita
- alennus - mahdollinen kampanja alennus tuotteessa

```
CREATE TABLE Tuotteet (
    tuoteId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuote TEXT NOT NULL,
    kuvaus TEXT,
    hinta FLOAT,
    maara INT,
    alennus FLOAT
);
```

**Käyttäjä pystyy etsimään tuotteita ja hänellä on ostoskori, johon voi lisätä ja poistaa tuotteita.**

Tehdään *Ostoskori* taulu, johon tallennetaan käyttäjän ostokset:
- Id - uniikki id 
- kayttajaId - 
- 

```
CREATE TABLE Ostoskori (
    ostoskoriID INT PRIMARY KEY AUTO_INCREMENT,
    kayttajaId INT FOREIGN KEY,
    sessioId VARCHAR(100),
    ;
)
```

**Tuotteita voidaan luokitella tuoteryhmiin. Sama tuote voi kuulua useaan tuoteryhmään.**

Tehdään *Tuoteryhmä* taulu, johon tallennetaan tuotteiden kategoriat:
- id - uniikki id ryhmän tunnistamiseen
- tuoteId - uniikki id tunnistamaan tuotte (viittaus)
- otsikko - tuoteryhmän nimi
- sisalto - tarkemmat tiedot, mitä kuuluu tuoteryhmään

```
CREATE TABLE Tuoteryhma (
    tuoteryhmaId PRIMARY KEY,
    tuoteId INT FOREIGN KEY REFERENCE Tuote(tuoteid),
    otsikko VARCHAR(25),
    sisalto VARCHAR(100)
);
```

**Kun tilaus on valmis, käyttäjä pystyy antamaan yhteystietonsa ja pankkikorttinsa tiedot, minkä jälkeen tilaus siirtyy käsittelyyn.**
```

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
CREATE TABLE tuoteArvostelut (
    tuoteArvosteluId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tuoteId INT FOREIGN KEY REFERENCE Tuote(tuoteID),
    otsikko VARCHAR(25) NOT NULL,
    sisalto VARCHAR(500),
    arvostelu INT(6) NOT NULL DEFAULT 0,
    paivamaara DATETIME NOT NULL
);
```

*Tuotteista voidaan muodostaa tarjouspaketteja, joissa tietyt tuotteet saa tiettyyn hintaan pakettina.*

Tehdään **

```
CREATE TABLE toimipaikat (
    toimipaikka VARCHAR(25) PRIMARY KEY NOT NULL,

)
```

*Käyttäjä näkee tuotteen kuvauksen yhteydessä, paljonko tuotetta on jäljellä missäkin verkkokaupan varastossa.*
```

```

*Käyttäjä voi saada alennuskoodin, jonka voi syöttää tilauksen yhteydessä. Alennuskoodin voi käyttää vain kerran.*
```

```

*Käyttäjä näkee tuotteen yhteydessä esimerkkejä, mitä tuotteita muut tämän tuotteen ostaneen asiakkaat ovat ostaneet.*
```

```
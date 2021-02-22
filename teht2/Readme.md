# SQL Skeema

*Käyttäjä*

```
CREATE TABLE Kayttaja (
    kayttajaId INT PRIMARY KEY AUTO_INCREMENT,
    etunimi VARCHAR(50),
    sukunimi VARCHAR(50),
    puhelin VARCHAR(12)
    email VARCHAR(50),
    osoite1 VARCHAR(50),
    osoite2 VARCHAR(50),
    kaupunki VARCHAR(50);
)
```

*Verkkokaupassa on tuotteita, joilla on nimi, kuvaus ja hinta.*
```
CREATE TABLE Tuotteet (
    tuoteId INT PRIMARY KEY AUTO_INCREMENT,
    KayttajaId INT FOREIGN KEY,
    tuote TEXT,
    kuvaus TEXT,
    hinta INT; // FLOAT better?
);
```

*Käyttäjä pystyy etsimään tuotteita ja hänellä on ostoskori, johon voi lisätä ja poistaa tuotteita.*
```
CREATE TABLE ostoskori (
    ostoskoriID INT PRIMARY KEY AUTO_INCREMENT,
    kayttajaId INT FOREIGN KEY,
    sessioId VARCHAR(100),
    ;
)
```

*Tuotteita voidaan luokitella tuoteryhmiin. Sama tuote voi kuulua useaan tuoteryhmään.*
```
CREATE TABLE tuoteryhma (
    tuoteryhmaId PRIMARY KEY,
    otsikko VARCHAR(25)
    sisalto VARCHAR(100);
)
```

*Kun tilaus on valmis, käyttäjä pystyy antamaan yhteystietonsa ja pankkikorttinsa tiedot, minkä jälkeen tilaus siirtyy käsittelyyn.*
```

```

*Käyttäjä pystyy arvostelemaan tuotteita ja lukemaan muiden käyttäjien antamia arvosteluja.*
```
CREATE TABLE tuoteArvostelut (
    tuoteArvosteluId INT PRIMARY KEY AUTO_INCREMENT,
    tuoteId INT FOREIGN KEY,
    otsikko VARCHAR(25),
    sisalto VARCHAR(500),
    arvostelu INT,
    paivamaara DATETIME;
)
```

*Tuotteista voidaan muodostaa tarjouspaketteja, joissa tietyt tuotteet saa tiettyyn hintaan pakettina.*
```

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
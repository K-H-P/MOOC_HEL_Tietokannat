# Tietokantakaavio

Kopio alla oleva [dbdiagram.io](dbdiagram.io) syötteeseen.

//// -- LEVEL 1
//// -- Tables and References

// Creating tables
Table Kayttaja as K {
  kayttajaId int [pk, increment] // auto-increment
  etunimi varchar [not null]
  sukunimi varchar [not null]
  puhelin varchar [not null, unique]
  email varchar [not null]
  osoite1 varchar [not null]
  osoite2 varchar
  kaupunki varchar [not null]
  }

Table Tuotteet as T {
  tuoteId INT [pk, increment]
  tuote TEXT [not null]
  kuvaus TEXT 
  hinta FLOAT 
  tuotteenMaara INT 
  alennus FLOAT
  }
 
Table Toimipaikat as P {
  toimipaikatId int [pk, increment]
  toimipaikka varchar [not null]
  nimi varchar
  }

Table Ostoskori as O{
  ostoskoriId INT [pk, increment]
  kayttajaId INT
  sessioId VARCHAR
  tuoteId INT
  tuote TEXT
  hinta FLOAT
  alennus FLOAT
  ostoMaara INT
  }

Table Tuoteryhma as TR{
  tuoteryhmaId INT [pk, increment]
  tuoteId INT 
  otsikko VARCHAR [not null]
  sisalto VARCHAR 
  }

Table Tilaus as TO {
  tilausId INT [pk, increment]
  ostoskoriId INT
  kayttajaId INT
  etunimi VARCHAR
  sukunimi VARCHAR
  puhelin VARCHAR
  email VARCHAR
  osoite1 VARCHAR
  osoite2 VARCHAR
  kaupunki VARCHAR
  maksutapa INT [not null]
  tila INT (5) [not null]
  paivamaara DATETIME [not null]
  muokkausPVM DATETIME [not null]
  personalAlennus FLOAT [not null]
  }

Table TuoteArvostelut as TA{
  tuoteArvosteluId INT [pk, increment]
  tuoteId INT
  otsikko VARCHAR(25) [not null]
  sisalto VARCHAR 
  arvostelu INT(6) [not null]
  paivamaara DATETIME [not null]
  }

Table Tarjoukset as B {
  tarjouksetId INT [pk, increment]
  tuoteId INT
  otsikko VARCHAR [not null]
  tuote TEXT
  hinta FLOAT [not null]
  yhteisAlennus FLOAT [not null]
  }

Table Ehdotukset as E{
  ehdotuksetId INT [pk, increment]
  tuoteId INT
  otsikko VARCHAR [not null]
  tuote TEXT
  }


// Creating references
// You can also define relaionship separately
// > many-to-one; < one-to-many; - one-to-one
Ref: K.kayttajaId < T.tuoteId
Ref: T.tuoteId > P.toimipaikatId
Ref: K.kayttajaId < O.kayttajaId
Ref: TR.tuoteryhmaId > T.tuoteId
Ref: K.kayttajaId < TO.tilausId
Ref: TO.tilausId < O.ostoskoriId
Ref: TA.tuoteArvosteluId > T.tuoteId
Ref: B.tarjouksetId > T.tuoteId
Ref: E.ehdotuksetId > T.tuoteId
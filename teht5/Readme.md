# Tehtävä 5:  Normaalimuodot

## Tehtävä 1

> Mitä hyötyä normaalimuodoista on? Miten ne liittyvät kurssimateriaalin luvun 6 periaatteisiin?

Relaatiotietokannassa normaalimuodot edustavat suuntaviivoja tietokannan tietueiden suunnittelulle. Normalisointisäännöt on suunniteltu estämään päivityspoikkeamat ja tietojen epäjohdonmukaisuudet. Sen tavoitteena on vähentää tietokantatauluissa esiintyvää toisteista tietoa ja normalisointi tehdään jo olemassa olevalle tietokannalle. Normalisointi etsii tunnettuja epäkohtia tietokannasta vertaamalla "säännöstöihin" eli normaalimuotoja seuraamalla. Annetun materiaalin luvun kohdassa 6 käydään läpi tietokannan suunnittelua. Tietokannan suunnittelu ja normaalimuodot liittyvät toisiinsa siinä, että suunnittelussa on hyvä huomioida, ettei tietoa toisteta. Tietokannan suunnittelussa olisi hyvä jo huomioida, mihin tietokannan normalisointi pyrkii: relaatioon tallennetaan vain siihen liittyvää dataa ja tieto on yhdessä paikassa sekä päivitykset kohdistuvat yhteen paikkaan.

## Tehtävä 2

> Kent määrittelee 1. normaalimuodon näin: "Under first normal form, all occurrences of a record type must contain the same number of fields."
> Mitä tarkoittavat "record type" ja "fields"?

Suora käännös:
> Ensimmäisen normaalimuodon periaatteen mukaan kaikki esiintyvät tietueiden tyypit (tietuetyypit) on sisällettävä sama määrä arvoja (kenttiä).

Tarkoittaen, että tiedon on oltava atomista. Yhdessä tietueessa ei saa olla useita arvoja. Esim. yhteistietotaulukossa henkilön puhelinnumeron kohdalla on vain yksi puhelinnumero. Jos niitä on useampi, ne tulisi eriyttää omiin tietueisiin (puh1, puh2). 

## Tehtävä 3

> Kent mainitsee 2. normaalimuodosta: "It is only relevant when the key is composite, i.e., consists of several fields."
Anna esimerkki tilanteesta, jossa ehto "key is composite" ei pidä paikkaansa, ja perustele asia.

Toisen normaalimuodon mukaan, tietueet eivät saa riippua, kuin perusavaimesta. Eli jos jokainen tietokannan taulu sisältää vain yhden avaimen se täyttää normaalimuodon kaksi. Esim. verkkokauppa käyttää osoitetta mm. tilauksessa ja toimituksessa. Jos osoite on tallennettu em. tauluihin ja vaikkapa ”asiakas” tauluun, niin syntyy ongelmia. Osoitteen tallennus tulee tehdä yhteen tauluun, joko em. tai omaansa. 

## Tehtävä 4

> Mitkä seuraavista ovat funktionaalisia riippuvuuksia?
> 1. elokuvan nimi → elokuvan julkaisuvuosi
> 2. elokuvan julkaisuvuosi → elokuvan nimi
> 3. opiskelijanumero → opiskelijan nimi
> 4. opiskelijan nimi → opiskelijanumero
> 5. käyttäjän sähköpostiosoite → käyttäjän nimi
> 6. käyttäjän nimi → käyttäjän sähköpostiosoite
> Perustele joka kohdasta lyhyesti, miksi se on tai ei ole funktionaalinen riippuvuus.

| Kohta | Funktionaalinen riippuvuus | Perustelu |
--------|---------------------------|-----------|
| 1. | Ei | Elokuvan nimestä ei voi päätellä sen julkaisuvuotta (pl. joku yksittäinen) |
| 2. | Ei | Elokuvan julkaisuvuodesta ei voi päätellä sen nimeä (pl. joku yksittäinen) |
| 3. | Ehkä | Ainakin Suomessa opiskelijanumero on uniikki ja näin ollen yhdellä henkilöllä on yksi numero, mutta muualla tilanne voi olla toisin |
| 4. | Ehkä | Em. |
| 5. | Ehkä | Sähköposti saattaa olla muotoa etunimi.sukunimi@xxxx.xx |
| 6. | Ehkä | Sähköposti voidaan, ja muodostetaankin, osassa organisaatioissa em. tyylisesti tai muulla logiikalla, esim. etunimen kaksi ensimäistä ja sukunimen kaksi ensimäistä kirjainta @xxxxx.xx |


## Tehtävä 5

> Kent mainitsee 4. normaalimuodosta: "The main problem with violating fourth normal form is that it leads to uncertainties in the maintenance policies."
> Mitä tarkoittaa tässä "maintenance policy"?

Neljännessä normaalimuodossa ongelmaksi muodostuu, kun tietuetyyppi sisältää kahta tai useampaa riippumatonta moniarvoista tosiasiaa. Huoltokäytänteet tässä tapauksessa viittaavat siis ongelmaan, joka tulee joko:
 1. Joko-tai -tilanne
 2. Mix, kolmella eri variaatiolla
   a) Min. määrä tietoja toistolla
   b) Min. määrä tietoja null -arvoilla
   c) Rajoittamaton (em. yhdistelmät)
 3. Ristiin vertailu, eli kaikki tiedot mahdollisilla variaatioilla

## Tehtävä 6

> Kent mainitsee 5. normaalimuodosta: "Fifth normal form does not differ from fourth normal form unless there exists a symmetric constraint --"
> Mihin sana "symmetric" viittaa tässä?

Mikäli ei ole olemassa mitään rajoitusta tietueiden välillä; kuten aineiston esim. agentti, yritys ja tuote, niin viides normaalimuoto on aina neljännessä normaalimuodossa. Tässä tapauksessa symmetria viittaa siihen, että tietueiden on oltava kokonaisuuden eri osien välistä yhdenmukaisuutta. 

## Lähteet

- https://docs.microsoft.com/en-us/office/troubleshoot/access/database-normalization-description
- https://fi.wikipedia.org/wiki/Tietokannan_normalisointi
- https://www.bkent.net/Doc/simple5.htm
- https://tietokantojen-perusteet-19.mooc.fi/osa-4/1-tietokannan-normalisointi

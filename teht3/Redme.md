
# Testi 1

Lisäämisessä tai haussa ei ole käytetty indeksiä apuna.

Rivien lisäämiseen kuluva aika: 30.914 sekuntia
Kyselyiden suoritukseen kuluva aika: 11.4300 sekuntia
Tietokantatiedoston koko testin lopuksi: 35.7227 megatavua

# Testi 2

Lisäämisessä käytettiin indeksiä apuna, mutta haussa ei.

Rivien lisäämiseen kuluva aika: 17.277 sekuntia
Kyselyiden suoritukseen kuluva aika: 11.0795 sekuntia
Tietokantatiedoston koko testin lopuksi: 47.4844 megatavua

# Testi 3

Lisäämisessä ei käytetty indeksiä apuna, mutta haussa käytettiin.

Rivien lisäämiseen kuluva aika: 42.684 sekuntia
Kyselyiden suoritukseen kuluva aika: 4.447 sekuntia
Tietokantatiedoston koko testin lopuksi: 47.4844 megatavua

# Miten selität testin tulokset?

Hakemistoa (index) käytetään nopeuttamaan hakuja tietokannasta. Hakemistolla voidaan löytää kaikki rivit, jotka vastaavat kyselyn saraketta, ja siten käydä läpi vain kyseisen taulukon osajoukko täsmällisen vastaavuuden löytämiseksi. Jos ei käytetä WHERE-lauseketta, joudutaan käymään koko taulukko läpi ja tarkistamaan jokainen rivi täsmällisen vastaavuuden löytämiseksi. Tämä "ongelma" korostuu, mitä isompi taulukko (data) on kyseessä. Oikean elämän esim. voidaan pitää kirjaa. Ilman hakemistoa, joudutaan käymään jokainen kirjan sivu läpi, kun haetaan jotain tiettyä sanaa. Hakemiston kanssa voidaan käydä hakemisto läpi ja näin löytää oikea vastaavuus. Tästä syystä myös tietokannan koko kasvaa, koska siihen lisätään tietoa - hakemisto.

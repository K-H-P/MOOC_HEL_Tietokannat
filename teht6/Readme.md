
# MongoDB Good and bad

"Miten MongoDB eroaa SQL -tietokannasta? Mitä hyvää ja huonoa siinä on?"

MongoDB määrittää sivuillaan sen parhaimmiksi puoliksi kyselyiden nopeuden, järjestelmän skaalautuvuuden, ketterät muutokset sekä yksinkertainen koodi kehittäjille opetella. Sivuilla myös määritetään relaatiotietokantojen keskittyvän data duplikaattien vähentämiseen ja tyypinen SQL -tietokanta on jäykkä, niissä on monimutkaiset skeemat ja ne niiden skaalaaminen on kallista. Hyvän ja huonon määrittäminen tulee olemaan haasteellista, koska se vaatii yleensä kontekstin. Uskallan väittää, ilman kokemusta, että Ferrari on hyvä tien päällä, mutta vedessä se ei pärjää edes soutuveneellä. NoSQL on varmasti hyvä tämänpäivän järjestelmissä ja kehityksessä, mutta soveltuuko se valtion olemassa oleviin järjestelmiin? Hyvä ja huono jääköön lukijan itsensä määrittämiseksi tarkemmin, pyrin esittämään vain faktoja.

MongoDB on useilla alustoilla toimiva NoSQL tietokanta järjestelmä. Se käyttää JSON tyyppistä dokumenttia ja se poikkeaa perinteisistä relaatiomallin tietokannoista, sillä siinä on samantyyppinen ajatus kuin olio-ohjelmoinnissa. Se on dokumentti-orientoitunut ja sen "asiakirjat" eli dokumentit ovat JSON ja BSON -tiedostoja. Se on tehokas, koska sitä voi ihminen lukea, jäsenneltyjä ja jäsentämättömiä tietoja voidaan tallentaa samaan asiakirjaan. JSON voidaan sisällyttä toiseen JSON -tiedostoon (nesting) ja JSNO:lla on joustava sekä dynaaminen skeema. Tärkeimpänä ominaisuutena on, että kehittäjät voivat valvoa tiedon rakennetta ja Näin he voivat tarvittaessa säätää sekä muotoilla sovelluksen kehityksen edetessä tarpeidensa mukaan. Tämän lisäksi MongoDB:llä on vahva ja tehokas hakutoiminto, koska se tallentaa sitä RAM -muistiin. MongoDB on skaalattavissa helposti suuremmalle datalle tarpeen vaatiessa käyttäen sirpaletoimintoa. (shards... I do not know how to translate this correctyl). MongoDB etuus voi olla myös sen heikkous. Tietokannan määrittely jää kehittäjän vastuulle ja mikäli siitä ei pidetä huolta voi tietokannasta tulle nopeasti sekava ja tehoton. On elintärkeää, että sen määrittelystä huolehtii, varmistaa ja pävittää joku/jotkut, jotta sen eheys pysyy. MongoDB:stä puuttuu täysin tietokannan hallintajärjestelmä, joka on ominaista perinteiselle SQL -tietokannalle. Tilan vaativuus on myös MongoDB haaste, kun tietokanta ei pudista levytilaa automaattisesti. Haku ominaisuuden suhteen MongoDB tarvitsee myös muistia sekä tilaa, joka voi jossain tapauksissa ola myös haaste. SQL -tietokannat, ainakin vanhaan aikaan kun tila maksoi, pyrkivät minimoimaan tilan käytön. Siinä missä MongoDB on ketterä eli sen määrritelystä vastaa ohjelmoija, on SQL -tietokanta tuttu ja turvallinen. Riippuen käyttöpaikasta tai -kohteesta tämä voi olla etuus, haaste tai este. 

Yhteenvetona em. esttely kiteyttää erot; huonot ja hyvät. Toki muitakin eroja löytyy, ja loppupeleissä hyvästä ja huonosta voidaan kiistellä jossain määrin, ainakin käyttökohteiden mukaan. MongoDB:n pääkohdat ovat nopeus, skaalautuvuus, nopeat muutokset sekä yksinkertaisempia koodi kehittäjille, kun taas relaatiotietokannan SQL -kieli on tunnettu, "standartoitu" ja vähän tilaa vievä. 

Lähteet:
- https://en.wikipedia.org/wiki/MongoDB
- https://www.mongodb.com/why-use-mongodb
- https://www.mongodb.com/nosql-explained/nosql-vs-sql
- https://en.wikipedia.org/wiki/Object%E2%80%93relational_mapping
- https://en.wikipedia.org/wiki/SQL

###

# MongoDB usage

// https://docs.mongodb.com/manual/reference/method/db.createCollection/
db.createCollection("Tyontekijat")

db.Tyontekijat.insertMany(
    {
        "nimi": 'Maija', "yritys": 'Google', "palkaa": 8000,
    },

)
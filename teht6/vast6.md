
# MongoDB Good and bad

"Miten MongoDB eroaa SQL -tietokannasta? Mitä hyvää ja huonoa siinä on?"


MongoDB on useilla alustoilla toimiva NoSQL tietokanta järjestelmä. Se käyttää JSON tyyppistä dokumenttia. MongoDB poikkeaa perinteisistä relaatiomallin tietokannoista, sillä siinä on samantyyppinen ajatus kuin olio-ohjelmoinnissa. Se on dokumentti-orientoitunut ja sen "asiakirjat" eli dokumentit ovat JSON ja BSON -tiedostoja. Se on tehokas, koska sitä voi ihminen lukea, jäsenneltyjä ja jäsentämättömiä tietoja voidaan tallentaa samaan asiakirjaan, JSON voidaan sisällyttä toiseen JSON -tiedostoon (nesting), JSNO:lla on joustava ja dynaaminen skeema. Tärkeimpänä ominaisuutena on, että kehittäjät voivat valvoa tiedon rakennetta. Näin ollen he voivat tarvittaessa säätää ja muotoilla sovelluksen kehityksen edetessä tarpeidensa mukaan. Tämän lisäksi MongoDB:llä on vahva ja tehokas hakutoiminto, koska se tallentaa sitä RAM -muistiin sekä MongoDB on skaalattavissa helposti suuremmalle datalle tarpeen vaatiessa käyttäen sirpaletoimintoa? (shards... I do not know how to translate this correctyl).

MongoDB etuus on myös sen heikkous. Tietokannan määrittely jää kehittäjän vastuulle ja mikäli siitä ei pidetä huolta voi tietokannasta tulle nopeasti sekava ja tehoton. On tärkeää, että sen määrittelystä huolehtii joku/jotkut, jotta sen eheys pysyy. MongoDB:stä puuttuu täysin tietokannan hallintajärjestelmä, joka on ominaista perinteiselle SQL -tietokannalle. Tilan vaativuus on myös MongoDB haaste, kun tietokanta ei pudista levytilaa automaattisesti.

Lähteet:
- https://en.wikipedia.org/wiki/MongoDB
- https://www.mongodb.com/why-use-mongodb
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
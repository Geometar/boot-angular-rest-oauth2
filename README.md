Tekst zadatka 

Napraviti Spring Boot Java web aplikaciju koja omogucava administraciju racunarskih komponenti i sastavljanje konfiguracije.

 Funkcionalnosti koje aplikacija treba da podrži: 

1. Ucitavanje šifarnika komponenti i upis u bazu podataka. Šifarnik komponenti sadrži vrste komponenti kao što su maticna ploca, procesor, kucište, štampac itd. Za svaku vrstu komponente definisana je vrednost koliko komponenti te vrste korisnik može da izabere u konfiguratoru. Ta vrednost može da bude: 
• 0 – komponenta je opciona i korisnik može da izabere samo jednu. 
• 1 – komponenta je obavezna i korisnik može da izabere samo jednu. 
• 0-n – komponenta je opciona, a korisnik može da izabere više od jedne. 
• 1-n – komponenta je obavezna, a korisnik može da izabere više od jedne. 

U import.sql scriptu se nalazi skup podataka koje je potrebno ucitati u bazu prilikom inicijalizovanja aplikacije. 

2. Napraviti REST endpointe za unos novih komponenti u sistem. Prilikom unosa nove komponente potrebno je uneti naziv komponente, šifru, vrstu komponente, kolicinu komponente i cenu po komadu. Prilikom unosa nove komponente u sistem sva polja moraju biti popunjena. 

3. Omoguciti pregled stanja “na lageru” svih komponeti i filtriranje po vrsti komponente. Za svaku komponentu potrebno je omoguciti opcije Izmeni i Obriši. 

4. Izborom opcije Izmeni, moguce je ažurirati kolicinu komponente i cenu, dok ostale atribute nije moguce menjati. 

5. Moguce je obrisati samo onu komponentu za koju je kolicina na lageru jednaka nuli. U suprotnom, javiti poruku da se komponenta ne može obrisati. 
# DiscordBotJava

https://github.com/DV8FromTheWorld/JDA/wiki/8%29-List-of-Events

https://github.com/DV8FromTheWorld/JDA

Iustina:
Pentru realizarea acestui bot am folosit JDA (Java Discord API) https://github.com/DV8FromTheWorld/JDA
Pentru a putea dezvolta acest  bot, am creat un server pe discord si de pe siteul discord in sectiunea developer am creat un bot pe care l-am adaugat la server, iar pentru a putea adauga functionalitati botului am utilizat un proiect de tip Maven caruia i-am adaugat depedentele precum dependenta JPA.

Proiectul este impartit pe pachete :
-	Pachetul commands contine mai multe clase, fiecare dintre aceste clase implementeaza o comanda care poate fi data botului
-	Pachetul music contine mai multe clase care contribuie la comanda care ii permite botului sa puna muzica in voice chat
-	Pachetul rss care contine mai multe clase care implementeaza diferite comenzi ce utilizeaza RSS pentru a prelua continut

Clasa Bot contine functia main iar aici se configureaza botul si i se adauga comenzile create.
O parte din aceasta configuratie consta in a seta prefixul, anume “-“, astfel comenzile vor fi apelate sub forma – numecomanda. De asemenea am adaugat si un HelpWord ( anume -helpme) care atunci cand este apelat se va trimite un mesaj in privat cu detalii despre comenzi.
Eu si Rares ne-am impartit sarcinile in mod egal astfel ca eu m-am ocupat de:
-	Comanda Hello
-	Comanda Image
-	Comanda Meme
-	Comanda ServerInfo
-	Pachetul RSS impreuna cu clasele din el

Pentru comenzile (clasele) QuestionCommand si ShowQuestions din pachetul commands am lucrat impreuna unde eu am adaugat 10 intrebari  + raspunsuri gandite si extrase din primele 5 cursuri ale cursului de Programare Avansata, iar Rares a facut alte 20 de intrebari si raspunsuri din urmatoarele cursuri de PA.

Pentru comanda Hello care extinde clasa Command am folosit un waiter, astfel ca in momentul in care in chatul severului se trimite mesajul -hello, botul va raspunde cu un mesaj in care va saluta inapoi si va cere numele. Utilizatorul va trebui sa raspunda cu un nume care este preluat prin acest waiter iar botul va raspunde cu un salut in formula completa (Hello Iustina! I am JavaBot!). De asemenea daca utilizatorul nu raspunda cu un nume timp de 1 minut, botul va trimite mesajul “Sorry, you took too long”.
In contructorul acestei clase am adaugat cateva specificatii precum numele comenzii (adica cu ce nume va putea fi apelata comanda), un alias (adica cu ce alte nume poate fi apelata comanda), textul pentru help, si categoria din care face parte.
Partea cu help si category folosesc in momentul in care utilizatorul introduce comanda -helpme intrucat in acel moment acesta va primi un mesaj PRIVAT de la bot in care se specifica folosul fiecarei comenzi implemetate, comenzile fiind impartite pe categorii.
Impartirea pe categorii a facut facuta de catre Rares si sunt urmtoarele:
-	Categoria mambers unde se afla comenzile hello, invite si image
-	Categoria about server and users unde se afla comenzile serverinfo si userinfo
-	Categoria news unde se afla comenzile java,python, cloudcomputing, gamedev, ios, programming, softeng si web
-	Categoria playing music unde se afla comenzile join si play
-	Categoria learning java unde se afla comenzile javaq&a si q.


 Comanda Image poate fi apelata astfel: -image si in plus fata de comanda hello are 4 argumente (latime, inaltime, urlul imaginii, si optional unghiul de rotatie), si are setat si un cooldown de 10 adica comanda poate fi apelata din nou dupa 10 secunde. Practic aceasta comanda preia imaginea din acel url si o redimensioneaza dupa argumentele date si o trimite in chat modificata.

Comanda ServerInfo poate fi apelata folosind -serverinfo si va returna o caseta in care se afla informatii despre server precum numele proprietarului, numarul de membrii, un link de invitatie.

Clasa Meme este o comanda insa are o abordare diferita fata de celelalte comenzi intrucat nu extinde clasa Command, ci clasa ListenerAdapter adica este un event. Cand comanda este apelata cu cu -meme, botul trimite un meme (o poza amuzanta – gluma ) in chat. Aceste poze sunt extrase de pe un meme api iar mesajul (poza) este afisata intr-o caseta impreuna cu titlu acesteia. Aceste date sunt preluate si parsate folosind JSON.

Pachetul rss contine 8 clase care reprezinta comenzi ce returneaza mesaje preluate prin rss. Asadar cand utilizatorul introduce una dintre comenzile:
-	-java
-	-Python
-	-CloudComputing
-	-GameDev
-	-iOS
-	-Programming
-	-SoftEng
-	-Web
acesta va primi ultimele 5 postari de pe site-ul corespunzator comenzii.
Fiecare din toate aceste comenzi reprezinta o clasa care extinde clasa Command si are constructor asemantor comenzilor descrise mai sus.  Fiecare clasa foloseste biblioteca ROME pentru a putea extrage postarile din linkul dat.  In acest fel, pentru fiecare postare gasita creez un EmbedBuilder (o casuta) in care introduce titlul postarii si linkul postarii extrase din feedul RSS, topicul postarii si setez si un thumbnail corespunzator topicului. Linkul feedului reprezinta linkul feedului rss corespunzator cate unui site popular cu postari despre topicul corespunzator. 
Am ales cele mai interesante subiecte din IT la momentul actual (dupa parerea mea) astfel un utilizator pasionat de IT va putea folosi una dintre comenzi pentru a se putea informa despre subiectul ales (Java, Python, Cloud Computing, Game Development, iOS, Programming, Software Engineering, Web Development) si pentru a citi diferite Tips & Tricks de programare din acel domeniu.

Comanda Show Questions care se apeleaza prin -JavaQ&A afiseaza in 3 casete cate 10 intrebari la care botul poate raspunde. Intrebarile sunt bazate pe cursurile de Programare Avansata. 
Comanda QuestionCommand raspunde la intrebarea aleasa si se apleaza cu -q nr, unde nr reprezinta numarul intrebari din casetele cu intrebari de mai sus.




RARES:

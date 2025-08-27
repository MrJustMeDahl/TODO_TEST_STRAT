# Instructions and answers:

## 1. Develop a simple to-do list application where users can:
### - Add, update, delete and mark tasks as completed.
### - Categorize tasks into different lists.
### - Set deadlines for tasks.
### - Key components for testing.

## 2. Test Strategy Design:
### - Create a test strategy that includes unit tests, integration tests and specification-based tests.
### - Discuss how each type of test contributes to the overall quality of the software.

## 3. Implementation:
### - Implement the test strategy using one of the frameworks (NUnit, XUnit, MSTest) or equivalent in your chosen language.

Til denne implementation bruges JUnit 5 som test framework.

### - Write a minimum of 5 unit tests, 2 integration tests and 1 specification-based tests.

Unit tests:

Findes i src/test/java/org/example/unit/TaskTest.java

Integrations tests:

Findes i src/test/java/org/example/integration/ToDoIntegrationTest.java

Specification-based tests:

Findes i src/test/Test case.pdf og src/test/java/org/example/unit/TaskTest.java

## 4. Use of Test Doubles:
### - Incorporate test doubles where necessary, based on the principles discussed by Martin Fowler.
### - Clearly explain why and how you used each type of test double.

Test doubles benyttes til at erstatte produktions objekter med henblik på test. Det gøres for at testene bliver pålidelige og robuste, ved at man får mulighed for at udelade produktionsdata af testene.

Implementationen her gør brug af test doubles stub og spy i integrationstestene. Det gøres her for at kunne simulere brugerinput og for at kunne teste om brugeren får de rigtige output via konsollen.

Stub (System.in): Simulerer brugerinput i CLI-integrationstests, med henblik på at få et forventeligt programflow.

Spy (System.out): Opfanger konsoloutput og asserter at brugeren får vist de forventede linjer.

Eftersom domænet i denne case er relativt simpelt gør vi ikke brug af test doubles i andre test, da det ikke giver udfordringer at bruge produktionsobjekterne direkte i test. Havde implementeringen derimod gjort brug af en database, kunne det have været en ide at benytte test doublen fake, ved eksempelvis at benytte en in memory test database, i stedet for produktionen.


## 5. Validation through Mutation Testing:
### - Apply mutation testing to validate the effectiveness of your test suite.
### - Provide a detailed analysis of the mutation testing results and how they informed you testing process.
<img width="1630" height="525" alt="image" src="https://github.com/user-attachments/assets/e8c399c6-8292-44d0-b04a-a6705b090adb" />
Samlet: Line 77% (33/43), Mutation 65% (22/34), Test strength 69% (22/32).

Per klasse: Task 100% mutation coverage (8/8) → stærke asserts; ToDoList 54% (14/26) → tests kører koden men fanger ikke alle fejl.

Vi tilføjer målrettede tests til tom liste (forventer “No tasks found.” + null) og out-of-range indeks for update/delete/complete, samt eksplicit før/efter-asserts på liste-størrelse og felter. De tester netop de steder, hvor mutanter overlevede.

<img width="1703" height="317" alt="image" src="https://github.com/user-attachments/assets/1b954ef2-690d-4501-a9cd-331a3e2ad389" />

Fra vores mutation test på klasseniveau, der kan vi se at Task klassen dræber alle mutanter, hvilket betyder at vi har stærke asserts i vores unittests.

ToDoList klassen har høj line coverage, men lav mutation coverage. Den fanger altså ikke fail-injections fra mutation testen godt nok.

## 6. Verification vs. Validation:
### - Reflect on the destinction between verification and validation as outlined in the Plutora article.

Verification:  Unit- og integrationstests verificerer, at implementeringen opfører sig i henhold til specifikationen (fx at updateTask rent faktisk opdaterer alle felter, og at flows gennem Main udskriver korrekte linjer).

Validation: Specification-baserede scenarier fra brugerperspektiv (CLI-flows) bekræfter, at løsningen leverer den tilsigtede værdi for brugeren (man kan tilføje, se, slette, fuldføre, og konsollen viser det korrekt).

### - Ensure your tests address both aspects, and document how each is covered.

## 7. Software Quality Reflection:
### - Read the article by Peter Morlion and evaluate your test strategy in the context of software quality.
### - Reflect on how your testing approach could be improved to better ensure quality.

Peter Morlion taler i sin artikel om load testing og performance testing. Eftersom applikationen for nuværende ikke er en webapplikation ville det umiddelbart ikke give mening at implementere load testing, men man kunne med fordel undersøge om performance testing skulle bruges til at sikre den eksterne kvalitet på lang sigt. Eksempelvis kunne performance testing benyttes til at vurdere, hvornår løsningen ikke længere lever op til brugerens krav om at være responsiv. Eftersom applikationen tillader uendeligt mange tasks at blive opbevaret, kan performance testing altså bruges til at vurdere om det er nødvendigt at opgradere lagringen af data.

## 8. Discussion on Test Categories:
### - Briefly discuss the test categories as outlined by Martin Fowler and classify the tests you have implemented accordingly.

Der bliver benyttet 3 af de test kategorier der nævnes i Martin Fowlers artikel.
Unit tests tester applikationens domænelag. De er små, hurtige og sikrer høj intern kvalitet. Derudover benytter vi os af integrationstests, som i dette tilfælde bliver kørt som broad stack. Dette sker da flowet er således: 
Scanner Tjekker input -> Main køres -> TodoList/Task -> System.out
Her bliver tastaturet simuleret, og outputtet fra terminalen bliver verificeret, så vi kan bekræfte, at komponenterne fungerer korrekt sammen.
Vores Specification based test kan godt betegnes som en Business Facing Test, da testen foregår i normalt sprog, og bliver løst uden kode, for at teste funktionaliteten.
Det kan også klassificeres som en user journey test, da vi tester brugerens navigation igennem systemet.
Vi kunne godt have indført threshold testing nemt ved vores mutation testing. Dette kunne gøres ved at ændre på "mutation threshold" i PIT fx 80 %. Threshold Testen vil så fejle når vi rammer under grænsen på 80%. Testen ville køre i en CI Pipeline for automatisk testing.



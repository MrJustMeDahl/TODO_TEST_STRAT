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



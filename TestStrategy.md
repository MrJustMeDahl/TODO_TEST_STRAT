# Test Strategy End-to-End

##### Pelle og Nicolai - Software kvalitet - Assignment 2

## 1. Test scope

#### 1.1. Overview of solution to be implemented

En simpel terminalbaseret todo applikation. Applikationen har følgende funktionalitet:

- Tilføje, opdatere, slette og markere tasks som færdige
- Kategorisere opgaver
- Sætte deadlines for opgaver
- Interaktionen med applikationen vil ske i terminalen

#### 1.2 In scope

- Alle Java klasser, herunder Main, Task og ToDoList.

#### 1.3 Out of scope

- Brugerfladen (GUI / Terminal)

## 2. Testing objectives & approach

- Det skal sikres at metoderne som håndterer kernefunktionaliteten af applikationen virker efter hensigten. (Metoderne i Task og ToDoList klasserne.) For at opnå dette benyttes Unit test via JUnit frameworket.

- Der testes for at applikationen ikke crasher på baggrund af illegalt brugerinput. Her udføres integrationstest for at teste interaktionerne mellem UI og applikation.
- Der laves test, som bekræfter, at kravspecifikationerne opfyldes. Denne specifikation baserede test laves på baggrund af begrænsningerne ved et konsolbaseret UI, manuelt og ikke automatiseret.

## 3. Test environment, infrastructure and tools

#### 3.1 Facilities and infrastructure requirements

- None required.

#### 3.2 Test environment and tools

- JDK: Microsoft OpenJDK 21.0.8
- OS: Windows
- IDE: Intellij
- Test tools: JUnit5

## 4. Assumptions and constraints

#### 4.1 Assumptions

- Alle udviklere gør brug af det definerede test environment.
- Kravspecifikationerne forbliver konstante.

#### 4.2 Constraints

- Konsolbaseret UI kan være vanskeligt at teste automatisk.

#### 4.3 Dependencies

- Java
- JUnit5

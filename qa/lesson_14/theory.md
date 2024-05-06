## Cucumber

**TDD** - подход с основным упором на имплементацию фичи.

**BDD** - подход, основанный на поведении системы.

**ATDD** - подход, основанный на разработке посредством приемочных тестов.

**Gherkin**
Business Readable, Domain Specific Language (DSL) - язык, позволяющий описать поведение программного обеспечения без раскрытия деталей имплементации. Gherkin служит двум целям — документация и автоматизирование

**Ключевые слова Gherkin-языка**

Feature file keywords

Feature

Background

Scenario

Scenario Outline

Examples

Scenario Keywords

Given

When

Then

And

But

More Keywords

“”” - Doc Strings

| - Data Tables

@ - Tags

`# - Comments`

[Презентация](https://docs.google.com/presentation/d/1Mf6uIdjQJRRPtp8azC6oDh3pu2kcPDK4/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

**navigate.feature**

Feature: Home Page

@navigate

Scenario: Verify HomePage title is displayed

Given User launches Chrome browser

When User opens ilCarro HomePage

Then User verifies HomePage title is displayed

And User quites browser

**login.feature**

Feature: Login

@validData

Scenario: Login with valid data

Given User launches Chrome browser

When User opens ilCarro HomePage

And User clicks on Login link

And User enters valid data

And User clicks on Yalla button

Then User verifies Success Message is displayed

And User quites browser




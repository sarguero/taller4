Feature: Login

  Background:
  tengo acceso a facebook

  Scenario: test
    When seteo mi email: "sary"
    And seteo mi password: 123456
    And hago click en el botón login
    Then yo deberia inciar sesison

  Scenario: test
    And hago click en el botón login
    Then yo deberia inciar sesison

  Scenario: mi ejmplo 3.3
    And seteo mi password: 123456
    And hago click en el botón login
    Then yo deberia inciar sesison
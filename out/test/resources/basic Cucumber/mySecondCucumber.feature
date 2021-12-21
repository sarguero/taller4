Feature: Login

  Scenario Outline: ejemplo segundo test
    Given tengo acceso a <application>
    When seteo mi email: <email>
    And seteo mi password: <password>
    And hago click en el botón login
    Then <verificacion>
    Examples:
      | email   | password | application | verificacion                 |
      | "sary"  | 123456   | facebook    | yo deberia iniciar sesion    |
      | "edgar" | 123456   | instagram   | yo deberia iniciar sesion    |
      | "mary"  | 123456   | gmail       | yo deberia iniciar sesion    |
      | "danny" | 123456   | facebook    | yo no deberia iniciar sesion |
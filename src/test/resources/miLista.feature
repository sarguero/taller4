Feature: miLista
  Scenario: Agregar

    Given la aplicacion mi Lista esta abierta
    When presiono el boton agregar
      |titulo  |nota |
      |Nota1   | Descripcion |
    Then se deberia mostrar titulo "Nota1" should be created

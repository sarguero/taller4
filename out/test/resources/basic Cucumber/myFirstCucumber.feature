Feature: Login
 #Esto es un comentario
  Scenario: como usuario comun
    quiero usar mis credenciales
    para poder ingresar a la aplicacion
  Given yo tengo acceso a facebook
  When seteo mi email: "sary"
    And seteo mi password: 123456
  And hago click en el botón login
  Then yo deberia inciar sesison


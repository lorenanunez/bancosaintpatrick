![ID for Ideas Logo](https://idforideas.com/logo_web.webp)
# Banco Saint Patrick

Desarrolla un sistema de home banking que permita a los usuarios realizar transacciones bancarias, gestionar sus cuentas, pagar servicios y administrar tarjetas de crédito.

### :bulb: Descripción del proyecto
- En el home banking vamos a poder ingresar con seguridad por usuario y visualizar
  nuestro saldo.
- También vamos a poder realizar transacciones a otras tarjetas.

### :rocket: Objetivos:
- Con tarjetas predefinidas para usuarios ya creados, vamos a poder transferir plata de
  cuenta a cuenta con la seguridad y validaciones suficientes para que no haya pérdidas
  de dinero en transacciones.

### :computer: Requisitos:
- Los usuarios ya están creados, no hay registro, sólo login con numero de tarjeta y pin.
- El usuario puede visualizar su saldo actual, un listado de últimas transacciones del mes,
y podrá realizar nuevas transacciones.
- El usuario podrá tener más de una tarjeta,
- Para realizar una transacción se pedirá número de tarjeta del otro usuario y monto.
- Al cerrar la ventana, se cierra la sesión.
- Al pasar 15 segundos sin actividad se cierra la sesión.

### Recursos del proyecto
#### Listado de tarjetas:

| Tarjeta| Pin|Saldo inicial|
|--------------|:----:|--------------:|
|4546-8574-1856-5565| 4345 |$40555 |
|5595-3458-9989-7125| 1595 |$3566 |
|4858-6696-5887-1578| 1234 |$23 |
|5854-6656-2587-1547| 4345 |$300 |
|4546-9896-2357-1478| 0023 |$300 |

## :space_invader: Ejecutar este proyecto en local:
### Requisitos:
- Java 21+
- Apache Maven 3+
- MySQL 8 o posterior

1. Clonar el repositorio con `git clone`
2. Navegar hasta la carpeta mediante el comando ``CD``
3. Crear la base de datos ``bancosaintpatrick`` y establecer las variables de entorno ``${dbuser}`` y ``${dbpass}`` con el correspondiente usuario y contraseña de la base de datos
   - ``CREATE DATABASE 'bancosaintpatrick'``
4. Ejecutar el comando ``mvn spring-boot:run``
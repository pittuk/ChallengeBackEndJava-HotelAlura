<h1>ChallengeBackEndJava Hotel Alura</h1>
Proyecto básico tipo desafío de de creación de un sistema de reserva para el Hotel Alura, impartido por el Programa Oracle One en coordinación con Alura Latinoamérica.

<h2>Tecnologías Utilizadas:</h2>
<ul>
  <li>Java SE</li>
  <li>NetBeans</li>
  <li>Swing</li>
  <li>Biblioteca JCalendar</li>
  <li>Maven</li>
  <li>MySql</li>
  <li>JPA: Hibernate</li>
  <li>Bcrypt</li>
</ul>

<h2>Reglas a cumplir</h2>
<ul>
  <li>Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema;</li>
  <li>Permitir crear, editar y eliminar una reserva para los clientes;</li>
  <li>Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas;</li>
  <li>Registrar, editar y eliminar datos de los huéspedes;</li>
  <li>Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria, lo que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva;</li>
  <li>Base de datos para almacenar todos los datos pedidos anteriormente.</li>
</ul>

<h2>Diagrama de la base de datos</h2>
<img src="https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/9b2581d7-a5be-4bb0-8d62-0e7b42b72137">

<h2>Pantalla de Login</h2>
Esta ventana se permitir al usuario ingresar su usuario y contraseña. Por detrás de la cortina se verifica si los datos ingresados son correctos o incorrectos y se notifica al usuario de este estatus, por ejemplo si los datos son incorrectos se muestra un mensaje al usuario diciendo "Usuario y Contraseña inválidos".

<img src="https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/33fd89dc-03b5-4a4b-a139-56f6f8649bca">

<h2>Pantalla de Reservas y Registro de Huésped</h2>
<h3>Reservas</h3>
En laa ventana de Reservas se permite al usuário registrar los siguientes datos:
<ul>
<li>Día de Entrada</li>
<li>Día de Salida</li>
<li>Valor de la reserva, que se calcula en base a un valor de diaria fijado de 20.000 pesos chilenos.</li>
<li>Forma de Pago </li>
</ul>
Al momento de guardar los datos se genera un número de reserva que será utilizado en la sección de registro de huéspedes de forma automática, este es un campo que el usuário no podrá manipular.

<h3>Huésped</h3>
En esta sección se registran los personales de los huéspedes con los siguientes campos:
<ul>
<li>Nombre</li>
<li>Apellido</li>
<li>Fecha de Nacimiento</li>
<li>Nacionalidad</li>
<li>Teléfono</li>
<li>Número de reserva que fue generada anteriormente.</li>
</ul>
También se le notifica al usuário tanto para registro satisfactorio de los datos como si ocurrió algún error.

<img src="https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/f35e6de1-7e72-4ca6-98b3-510abd059adf">


![pantalla-edicion-y-eliminacion](https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/4820ef05-c6d2-488c-b51e-4c066140d166)
![pantalla-de-reservas](https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/f35e6de1-7e72-4ca6-98b3-510abd059adf)

![pantalla-de-busqueda](https://github.com/pittuk/ChallengeBackEndJava-HotelAlura/assets/31288202/59468aec-010d-4fbe-8c6b-243d1e440819)

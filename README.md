<h1>Airport Management System</h1>

<p>Este proyecto es una aplicación de escritorio construida en Java para la gestión general de un aeropuerto, utilizando el framework <strong>Java Swing</strong> para la interfaz gráfica de usuario. La aplicación permite gestionar roles, aerolíneas, vuelos, y solicitudes de mantenimiento, garantizando la persistencia de datos y utilizando excepciones personalizadas para el manejo de errores.</p>

<h2>Requisitos</h2>
<ul>
    <li>Java 11 o superior.</li>
    <li>Maven para gestionar las dependencias del proyecto.</li>
</ul>

<h2>Funcionalidades</h2>

<h3>Roles:</h3>
<ul>
    <li><strong>Administrador General:</strong>
        <ul>
            <li>Gestión de empleados del aeropuerto (administradores de aerolíneas y gestores de mantenimiento).</li>
            <li>Gestión de las aerolíneas registradas en el aeropuerto.</li>
            <li>Responder a solicitudes de mantenimiento de los aviones.</li>
        </ul>
    </li>
    <li><strong>Administrador de Aerolínea:</strong>
        <ul>
            <li>Gestión de empleados de la aerolínea (empleados de logística y capitanes de vuelo).</li>
            <li>Gestión de aviones, incluyendo su capacidad.</li>
            <li>Visualización del historial de vuelos realizados.</li>
        </ul>
    </li>
    <li><strong>Empleado de Logística:</strong>
        <ul>
            <li>Gestión de vuelos, asignación de aviones y capitanes.</li>
            <li>Solicitud de mantenimiento para aviones.</li>
        </ul>
    </li>
    <li><strong>Viajero:</strong>
        <ul>
            <li>Registro de cuentas.</li>
            <li>Filtrado de vuelos por fecha, ciudad de origen y destino.</li>
            <li>Realización y gestión de reservas (máximo dos activas).</li>
        </ul>
    </li>
</ul>

<h3>Funcionalidades Clave:</h3>
<ul>
    <li><strong>Gestión de Vuelos:</strong>
        <ul>
            <li>Creación, asignación y visualización de vuelos.</li>
            <li>Restricciones en base a la disponibilidad del avión y del capitán.</li>
        </ul>
    </li>
    <li><strong>Solicitudes de Mantenimiento:</strong>
        <ul>
            <li>Creación de solicitudes, actualización del estado y asignación de tiempos estimados para el mantenimiento.</li>
            <li>Comunicación en tiempo real entre el administrador del aeropuerto y los empleados de logística.</li>
        </ul>
    </li>
    <li><strong>Reservas:</strong>
        <ul>
            <li>Los viajeros pueden realizar reservas si hay cupos disponibles y gestionar hasta 2 reservas activas a su nombre.</li>
            <li>Visualización de vuelos y reservas con filtros personalizados.</li>
        </ul>
    </li>
    <li><strong>Persistencia de Datos:</strong> La información se almacena en una base de datos para asegurar que los datos se mantengan incluso después de cerrar la aplicación.</li>
    <li><strong>Excepciones Personalizadas:</strong> Manejo de errores y validaciones, como el número máximo de reservas, disponibilidad de aviones, etc.</li>
</ul>

<h2>Estructura del Proyecto</h2>
<ul>
    <li><strong>src/main/java:</strong> Contiene la lógica del negocio, modelos, controladores, y excepciones personalizadas.</li>
    <li><strong>src/main/resources:</strong> Archivos de configuración, incluyendo la base de datos y propiedades.</li>
    <li><strong>src/main/ui:</strong> Interfaces gráficas construidas con Java Swing.</li>
</ul>

<h2>Reglas y Validaciones</h2>
<ul>
    <li><strong>Restricciones de vuelos y mantenimiento:</strong> No se pueden asignar aviones a vuelos si están en mantenimiento activo.</li>
    <li><strong>Capacidad de aviones:</strong> Los viajeros no podrán ver vuelos si los cupos han sido llenados.</li>
    <li><strong>Solicitudes de mantenimiento:</strong> Solo puede haber una solicitud activa por aerolínea a la vez.</li>
</ul>

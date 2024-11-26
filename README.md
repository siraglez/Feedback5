# Feedback5
 
Link al repositorio: https://github.com/siraglez/Feedback5.git

# Gestión De Novelas

Este proyecto es una aplicación Android para gestionar novelas, permitiendo a los usuarios registrar, ver detalles, marcar como favoritas y reseñar novelas. La aplicación soporta temas claro y oscuro, que pueden ser configurados por el usuario.

## Estructura y Componentes Principales
### Actividades
1. **LoginActivity**: Permite a los usuarios iniciar sesión o registrarse. Ahora utiliza `UsuarioDao` (implementado con Room) para verificar credenciales y registrar nuevos usuarios.
2. **MainActivity**: Es la actividad principal que muestra una lista de novelas. Aquí, el usuario puede cambiar entre temas, acceder a la configuración y navegar entre fragmentos. Ahora usa `NovelaDao` para gestionar los datos de las novelas.
3. **ConfiguracionActivity**: Proporciona opciones para cambiar el tema, realizar copias de seguridad y restaurar datos. También incluye la opción de cerrar sesión. Ahora las copias de seguridad se realizan en formato JSON, mejorando la portabilidad de los datos.

### Fragments
1. **ListaNovelasFragment**: Muestra la lista de novelas, permitiendo a los usuarios seleccionar una para ver sus detalles. Los datos se obtienen de `NovelaDao`, optimizando la carga y el manejo de la lista.
2. **DetallesNovelaFragment**: Muestra los detalles de una novela seleccionada. Permite marcarla como favorita, agregar reseñas y eliminarla. Utiliza `NovelaDao` para las operaciones de base de datos y `ResenaDao` para gestionar las reseñas.
3. **AgregarNovelaFragment**: Permite al usuario agregar una nueva novela ingresando título, autor, año de publicación y sinopsis. La inserción se realiza mediante `NovelaDao`.
4. **AgregarResenaFragment**: Facilita la adición de una reseña a una novela seleccionada. Las reseñas ahora se gestionan con `ResenaDao`.

### Base De Datos
La aplicación ha sido migrada a Room, reemplazando las clases `NovelaDatabaseHelper` y `UsuarioDatabaseHelper` con las siguientes implementaciones más eficientes:
1. **UsuarioDao**: Gestiona las operaciones relacionadas con los usuarios, como el registro, inicio de sesión y actualización de preferencias de tema.
2. **NovelaDao**: Maneja las operaciones CRUD de las novelas, incluyendo la gestión de favoritos.
3. **ResenaDao**: Gestiona las reseñas asociadas a las novelas.

### Adaptadores y Widgets
1. **NovelaAdapter**: Presenta cada novela en la lista con su título, autor y una indicación si es favorita.
2. **NovelasFavoritasWidget**: Muestra las novelas marcadas como favoritas en un widget de la pantalla de inicio. La lista de novelas favoritas ahora se obtiene directamente de NovelaDao mediante una consulta optimizada.

## Funcionalidades Clave
- **Gestión de Novelas**: Los usuarios pueden agregar, ver detalles, reseñar y eliminar novelas. Las operaciones con datos se gestionan eficientemente mediante Room.
- **Favoritos**: Cada novela puede marcarse como favorita, y estas se reflejan en el widget.
- **Reseñas**: Posibilidad de agregar múltiples reseñas a cada novela. Las reseñas ahora se almacenan en una tabla independiente para un manejo más estructurado.
- **Optimización de Base de Datos**: Migración a Room, que mejora el manejo de datos, reduce código redundante y optimiza las operaciones de lectura/escritura.
- **Copia de Seguridad**: Las copias de seguridad de los datos de usuario ahora se realizan en formato JSON, facilitando la restauración y portabilidad.
- **Uso de Gson**: Integración con Gson para convertir los datos a JSON durante las copias de seguridad.
- **Temas**: Soporte para tema claro y oscuro, configurable desde ConfiguracionActivity.

## Configuración De Tema
La aplicación soporta temas claro y oscuro, que se almacenan en las preferencias del usuario y se aplican en todas las pantallas.

## Gestión De Usuarios
La funcionalidad de registro y autenticación permite a los usuarios mantener sus preferencias y temas almacenados individualmente. El uso de Room simplifica la verificación de credenciales y el almacenamiento de datos.

## Optimización De Recursos
1. **Base de Datos Optimizada**: Uso de Room para una mejor gestión de los ciclos de vida y operaciones de base de datos.
2. **Eficiencia en Consultas**: Consultas específicas en DAOs para reducir el uso de recursos y mejorar la velocidad de respuesta.
3. **Copias de Seguridad Robustas**: Datos almacenados en formato JSON para mayor flexibilidad y portabilidad.
4. **Separación de Resposabilidades**: Uso de DAOs específicos para cada tipo de datos (usuarios, novelas y reseñas).

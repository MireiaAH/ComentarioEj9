# comentarioej9
# Encriptador de Mensajes

## Descripción
Un encriptador es una aplicación que transforma un texto haciéndolo ilegible para aquellos que desconocen el código. Este programa en Java lee un archivo de texto, lo codifica y crea un nuevo archivo con el mensaje cifrado. El alfabeto de codificación se encuentra en el archivo `codec.txt`.

## Funcionamiento del Programa

### Instrucciones de Uso
1. Coloca el archivo de texto original (`mensaje.txt`) y el archivo de codificación (`codec.txt`) en el directorio del proyecto.
2. Ejecuta el programa.
3. El programa leerá el archivo de codificación y creará un nuevo archivo llamado `mensaje_cifrado.txt` con el mensaje codificado.

## Detalles del Código

El programa consta de dos funciones principales:

### `leerCodificacion`
Esta función lee el archivo de codificación y devuelve un mapa que contiene la codificación.

### `codificarMensaje`
Esta función codifica el mensaje utilizando el mapa de codificación proporcionado y escribe el mensaje codificado en un nuevo archivo.

El código Java correspondiente se encuentra en el archivo `Ej9.java`.



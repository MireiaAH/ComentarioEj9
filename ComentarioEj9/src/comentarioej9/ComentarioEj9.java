
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comentarioej9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Un encriptador es una aplicación que transforma un texto haciéndolo ilegible para aquellos
 * que desconocen el código. Este programa lee un archivo de texto, lo codifica y
 * crea un nuevo archivo con el mensaje cifrado. El alfabeto de codificación se encuentra en el
 * archivo codec.txt.
 * 
 * Este programa consta de dos funciones principales: leerCodificacion y codificarMensaje.
 * 
 * @author Mireia
 * @version 1.0
 */
public class ComentarioEj9 {

/**
     * Función principal del programa.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Definir los nombres de los archivos de entrada y salida
        String archivoOriginal = "mensaje.txt";
        String archivoCodec = "codec.txt";
        String archivoCifrado = "mensaje_cifrado.txt";

        // Leer el archivo de codificación
        Map<Character, Character> codificacion = leerCodificacion(archivoCodec);
        if (codificacion == null) {
            System.err.println("No se pudo leer el archivo de codificación.");
            return;
        }

        // Codificar el mensaje
        codificarMensaje(archivoOriginal, archivoCifrado, codificacion);
    }

    /**
     * Lee el archivo de codificación y devuelve un mapa que contiene la codificación.
     * 
     * @param archivoCodec nombre del archivo que contiene la codificación.
     * @return mapa que contiene la codificación.
     */
    public static Map<Character, Character> leerCodificacion(String archivoCodec) {
        Map<Character, Character> codificacion = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCodec))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Dividir la línea en partes separadas por ":"
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    // Añadir la codificación al mapa
                    codificacion.put(partes[0].charAt(0), partes[1].charAt(0));
                }
            }
        } catch (IOException e) {
            // Capturar y manejar cualquier error de lectura del archivo
            System.err.println("Error al leer el archivo de codificación: " + e.getMessage());
            return null;
        }
        return codificacion;
    }

    /**
     * Codifica el mensaje utilizando el mapa de codificación proporcionado y escribe el mensaje
     * codificado en un nuevo archivo.
     * 
     * @param archivoOriginal nombre del archivo de texto original.
     * @param archivoCifrado nombre del archivo donde se escribirá el mensaje cifrado.
     * @param codificacion mapa que contiene la codificación.
     */
    public static void codificarMensaje(String archivoOriginal, String archivoCifrado, Map<Character, Character> codificacion) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCifrado))) {
            int caracter;
            while ((caracter = lector.read()) != -1) {
                // Leer cada carácter del archivo original
                char caracterOriginal = (char) caracter;
                // Obtener el carácter codificado
                char caracterCifrado = codificacion.getOrDefault(caracterOriginal, caracterOriginal);
                // Escribir el carácter codificado en el archivo cifrado
                escritor.write(caracterCifrado);
            }
            // Imprimir un mensaje indicando que el mensaje cifrado se ha creado correctamente
            System.out.println("Mensaje cifrado creado en el archivo: " + archivoCifrado);
        } catch (IOException e) {
            // Capturar y manejar cualquier error durante el proceso de codificación
            System.err.println("Error al codificar el mensaje: " + e.getMessage());
        }
    }
}
package PP2;

import java.io.*;
import java.util.Stack;

public class Revert {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        Stack<Character> stack = new Stack<>();

        // Leer el archivo de entrada
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                stack.push((char) c);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Escribir el archivo de salida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!stack.isEmpty()) {
                writer.write(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            return;
        }

        System.out.println("✅ Archivo invertido correctamente en " + outputFile);
    }
}

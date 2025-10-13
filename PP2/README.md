# PP2: Programa Revert (Inversión de Archivos con Pila) 

Este documento describe la implementación del programa `Revert`, el cual lee un archivo de texto, invierte su contenido utilizando la estructura de datos Pila (Stack) y lo escribe en un nuevo archivo de salida.

---

## 1. Información Personal y Técnica

| **Nombre** | [Anthony Gomez Garcia] |
| **Carné** | [FI24039489] |
| **IDE/Editor Utilizado** | [ Visual Studio Code, ] |
| **Versión de Java** | Java SE 21 & JDK 21 |



## 2. Recursos y Asistencia

### A. Referencias Web y Snippets

Se utilizaron las siguientes referencias para la manipulación de archivos (`java.io`) y la gestión de la Pila en Java:

* **[Vínculo de la página 1]** (Ej: `https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/FileReader.html` para `FileReader`)
* **[Vínculo de la página 2]** (Ej: `https://www.baeldung.com/java-try-with-resources` para el manejo de recursos)
* **[Vínculo de la página 3]** (Ej: `https://stackoverflow.com/...` para consultas específicas de `Stack<Character>`)

### B. Asistencia de Chatbots (IA)

Se utilizó el asistente de IA **Gemini** para validar la lógica del programa, asegurar el cumplimiento de las especificaciones técnicas (uso de `Character` en el Stack) y estructurar esta documentación.



    1.  **Consulta:** "Especificaciones funcionales Se debe crear un programa llamado Revert que, al ejecutarse, lea un archivo de texto, invierta su contenido y escriba dicha versión invertida en otro archivo de texto. [...] necesito hacer este ejercicio ayudame paso a paso"
        * **Respuesta del Chatbot:** [Describir brevemente, Ej: "El chatbot proporcionó la estructura de código Java completa usando `Stack<Character>`, `FileReader` y `FileWriter`, detallando la lógica LIFO."]

    2.  **Consulta:** "cuando lo ejecuto que tengo que hacer ??"
        * **Respuesta del Chatbot:** [Describir brevemente, Ej: "El chatbot explicó el proceso de compilación (`javac PP2/Revert.java`) y ejecución (`java PP2.Revert`) desde la línea de comandos."]

    3.  **Consulta:** "y como tiene que ser en markdown" / "pero me lo haces todo completo de nuevo"
        * **Respuesta del Chatbot:** [Describir brevemente, Ej: "El chatbot estructuró y revisó el archivo `README.md` final, incluyendo la analogía creativa para la pregunta 2."]

---

## 3. Preguntas de Reflexión

### 1. ¿Cree que exista otra forma de efectuar la inversión del contenido de un archivo sin necesidad de usar una pila? Si sí, indique cómo (sin necesidad de código).

Sí, existe una forma eficiente de invertir el contenido sin usar la estructura de datos Pila explícitamente.

**Mecanismo de Inversión sin Pila:**

1.  **Lectura Completa en Memoria:** Se lee el contenido completo del archivo de entrada (`input.txt`) y se almacena en una estructura de datos secuencial simple, como un **Arreglo de Caracteres (`char[]`)** o una **Lista de Caracteres (`List<Character>`)**.
2.  **Iteración Inversa:** Se utiliza un ciclo de iteración (`for` o `while`) que comienza desde el **último índice** de la estructura almacenada (el último carácter) y avanza hacia atrás hasta llegar al primer índice (índice 0).
3.  **Escritura Directa:** En cada paso del ciclo, el carácter obtenido se escribe directamente en el archivo de salida (`output.txt`).

Este enfoque logra la inversión mediante la manipulación de índices, replicando la inversión sin requerir las operaciones dobles de `push` y `pop` de la pila.

### 2. ¿En qué ejemplo de la vida real (no informático) se puede ver reflejado el uso de una pila?

Un ejemplo cotidiano que refleja el principio **LIFO (Last In, First Out)** es el manejo de las **cargas y descargas de un muelle logístico o *dock* de camiones**, específicamente en la preparación de las mercancías.

* **Entrada (Push):** El operario de logística coloca la caja más reciente o la que debe cargarse al final del camión **en la parte superior de la pila** temporal.
* **Salida (Pop):** Cuando se inicia la carga, el operario siempre toma la caja que está en la **cima de la pila** (la última que se colocó).

El principio LIFO se respeta porque la **última caja en ser apilada** en el muelle es la **primera en ser utilizada** para el proceso de carga, lo que es esencial para la eficiencia en la logística y el transporte.
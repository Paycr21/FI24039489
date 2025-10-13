# PP2: Programa Revert (Inversión de Archivos con Pila) 🔄

## 1. Información Personal y Técnica

| Rubro | Detalle |
| :--- | :--- |
| **Nombre** | [Tu Nombre Completo] |
| **Carné** | [Tu Número de Carné] |
| **IDE/Editor Utilizado** | [Ejemplo: Visual Studio Code, IntelliJ IDEA, Eclipse] |
| **Versión de Java** | Java SE 21 & JDK 21 |

---

## 2. Recursos y Asistencia

### A. Referencias Web y Snippets

Se utilizaron las siguientes referencias para comprender la manipulación de archivos y la gestión de excepciones en Java I/O:

* **[Vínculo de la página 1]** (Ej: `https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/FileReader.html` para `FileReader`)
* **[Vínculo de la página 2]** (Ej: `https://www.baeldung.com/java-try-with-resources` para `try-with-resources`)
* **[Vínculo de la página 3]** (Ej: `https://stackoverflow.com/...` para manejo de `IOException`)

### B. Asistencia de Chatbots (IA)

Se utilizó un asistente de IA (Gemini) para validar la lógica del programa, revisar las especificaciones técnicas (uso de `Character` y `Stack`), y estructurar la documentación (este `README.md`).

* **Vínculo a la Conversación Compartida (Opcional):** [Pegar aquí el vínculo compartido de la conversación]
* **Prompts (Consultas y Respuestas Relevantes):**

    1.  **Consulta:** "Especificaciones funcionales Se debe crear un programa llamado Revert que, al ejecutarse, lea un archivo de texto, invierta su contenido y escriba dicha versión invertida en otro archivo de texto. [...] necesito hacer este ejercicio ayudame paso a paso"
        * **Respuesta del Chatbot:** [Pegar un resumen o el fragmento más relevante de la respuesta, por ejemplo: "El chatbot proporcionó la estructura de código Java usando `Stack<Character>` y `FileReader`/`FileWriter`, detallando los métodos `readAndPush` y `popAndWrite`."]

    2.  **Consulta:** "cuando lo ejecuto que tengo que hacer ??"
        * **Respuesta del Chatbot:** [Pegar un resumen de la respuesta, por ejemplo: "El chatbot describió el proceso de compilación (`javac`) y ejecución (`java PP2.Revert`) desde la terminal."]

    3.  **Consulta:** "[La consulta que generó esta sección del README, por ejemplo: 'tengo que hacer un archivo README.md con estas secciones...']"
        * **Respuesta del Chatbot:** [Pegar el fragmento relevante sobre la estructura del README.]

---

## 3. Preguntas de Reflexión

### 1. ¿Cree que exista otra forma de efectuar la inversión del contenido de un archivo sin necesidad de usar una pila? Si sí, indique cómo (sin necesidad de código).

Sí, **existe al menos otra forma** de invertir el contenido de un archivo sin usar explícitamente una Pila (`Stack`).

**Mecanismo alternativo:**

1.  **Lectura Completa:** Leer el contenido completo del archivo de entrada (`input.txt`) y almacenarlo en una única estructura de datos secuencial, como un **Arreglo de Caracteres (`char[]`)** o una **Cadena de Caracteres (`String`)** o una **Lista (`List<Character>`)** en memoria.

2.  **Iteración Inversa:** Una vez que todo el contenido está en la memoria:
    * Se iniciaría un ciclo de iteración desde el **último** carácter de esa estructura hasta el **primer** carácter.
    * En cada paso, se tomaría el carácter y se escribiría directamente en el archivo de salida (`output.txt`).

Este método logra la inversión de manera eficiente en memoria (si el archivo no es excesivamente grande), ya que la inversión se realiza mediante un índice descendente ($i = longitud - 1$ a $i = 0$), sin la necesidad de la doble operación de `push` y `pop` de la pila.

### 2. ¿En qué ejemplo de la vida real (no informático) se puede ver reflejado el uso de una pila?

Un ejemplo cotidiano perfecto que refleja la estructura de una Pila (LIFO: Último en Entrar, Primero en Salir) es una **pila de bandejas en un dispensador de cafetería**.

* **Entrada (Push):** Cuando un empleado coloca una bandeja limpia en la parte superior del dispensador, esta es la **última** en entrar.
* **Salida (Pop):** Cuando un cliente toma una bandeja, siempre toma la que está hasta arriba, que es precisamente la **última** que se colocó.

El principio es idéntico: la primera bandeja que se colocó en la pila es la última que será utilizada.
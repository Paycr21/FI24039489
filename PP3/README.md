# 🧾 Proyecto PP3 – Lista Circular Doblemente Enlazada



## Información del estudiante

**Nombre:** Anthony Gómez  
**Carné:** FI24039489 
**Curso:** Estructuras de Datos  
**Profesor:** Ing. Luis Andrés Rojas Matey  
**Universidad:** Fidélitas – Costa Rica  

---

## Descripción del proyecto

El propósito de este proyecto fue implementar una **lista circular doblemente enlazada** en el lenguaje Java, capaz de insertar y eliminar elementos desde ambos extremos.  
Cada nodo almacena un número aleatorio entre 0 y 9, y la aplicación permite visualizar el comportamiento de la estructura en distintas etapas.

El programa realiza las siguientes operaciones:

1. Agrega nodos al inicio y al final de la lista.  
2. Elimina elementos desde el inicio y desde el final.  
3. Muestra la lista en orden normal y en orden inverso.  
4. Verifica el funcionamiento cuando se intenta eliminar más nodos de los que existen, asegurando que la lista devuelva `null` de forma segura.

Este trabajo refuerza el conocimiento de **estructuras dinámicas**, el manejo de punteros (`next` y `prev`), y la comprensión del flujo circular de datos.


## Entorno de desarrollo

| Elemento | Detalle |
|-----------|----------|
| **IDE utilizado** | Visual Studio Code (VS Code) |
| **Versión de Java** | OpenJDK 21 (LTS) |
| **Sistema operativo** | Windows 10 (64 bits) |
| **Compilador** | `javac` |
| **Ejecución** | `java ListDoublyCircular n` |

>  Donde `n` es un número natural que define cuántos grupos de elementos se agregan y eliminan.  
> Por ejemplo, con `n = 3` el programa genera 12 nodos (`n * 4`) y luego los elimina progresivamente.

---

## Páginas consultadas

Para el desarrollo de esta práctica se consultaron fuentes teóricas y ejemplos prácticos de referencia:

- [Oracle Java SE Documentation](https://docs.oracle.com/javase/21/docs/api/)  
- [GeeksforGeeks – Doubly Circular Linked List](https://www.geeksforgeeks.org/doubly-circular-linked-list/)  


## Uso de inteligencia artificial

Durante la práctica utilicé **ChatGPT (modelo GPT-5)** como **herramienta de apoyo conceptual**, principalmente para aclarar dudas sobre:
- El comportamiento de los punteros `next` y `prev` en una estructura circular.  
- Las diferencias entre listas simples, dobles y circulares.  
- Cómo estructurar correctamente un archivo `README.md` en formato Markdown.

No copié código directamente. Las explicaciones sirvieron únicamente como **referencia teórica**, y toda la implementación fue elaborada manualmente y probada de forma independiente.  


## Preguntas y respuestas


### 1️ Si tuviera que implementar una estructura tipo **Cola (Queue)**, ¿qué tipo de lista utilizaría y por qué? ¿Y para una estructura tipo **Pila (Stack)?**

#### Cola (Queue)
Para una cola implementaría una **lista circular doblemente enlazada**, porque permite insertar al final (`enqueue`) y eliminar desde el inicio (`dequeue`) de manera eficiente.  
El uso de punteros dobles (`prev` y `next`) permite recorrer la lista en ambos sentidos, manteniendo las operaciones con una complejidad **O(1)**.  
Además, al ser circular, evita referencias nulas y mantiene el flujo continuo de elementos, lo cual es ideal para estructuras **FIFO (First In, First Out)**.

#### Pila (Stack)
Para una pila utilizaría una **lista simplemente enlazada**, ya que en este tipo de estructura solo se manipula un extremo: la cima.  
Las operaciones `push` y `pop` se pueden realizar directamente sobre el primer nodo, también con complejidad **O(1)**.  
Su diseño es más simple y ocupa menos memoria, lo que la hace perfecta para el comportamiento **LIFO (Last In, First Out)**.



### 2️ ¿Cuál sería una **ventaja** y una **desventaja** de implementar una lista propia en lugar de usar las estructuras incluidas en Java (como `List` o `LinkedList`)?

#### Ventajas:
- Permite **comprender mejor el funcionamiento interno** de las estructuras de datos.  
- Da **mayor control** sobre la lógica, pudiendo personalizar el comportamiento según las necesidades.  
- Fomenta el aprendizaje sobre **punteros, referencias y manejo de memoria dinámica**.  
- Refuerza la capacidad de **analizar y resolver errores lógicos** en estructuras complejas.

#### Desventajas:
- Implementar una estructura desde cero **consume más tiempo** y es más propenso a errores.  
- Puede ser menos eficiente que las versiones optimizadas incluidas en el API estándar de Java.  
- Aumenta la complejidad de mantenimiento en programas grandes.  
- Las estructuras estándar (`ArrayList`, `LinkedList`, etc.) ya son más estables y están ampliamente probadas.


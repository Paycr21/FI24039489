# 📘 PP4 — Árbol Binario con Arreglo Fijo

##  Estudiante  
**Nombre:** Anthony Bryan Gómez García**  
**Carné:** FI24039489 

---

## Curso  
**Estructuras de Datos — SC-304**  
**Profesor:** Luis Andrés Rojas Matey  
**Universidad Fidélitas**

---

#  Descripción del Proyecto

Este proyecto implementa un **árbol binario ordenado** utilizando un **arreglo de tamaño fijo (`Integer[]`)**.  
El objetivo es comprender cómo funcionan las estructuras de datos tipo árbol utilizando únicamente **índices matemáticos** en lugar de punteros.

Para determinar posiciones dentro del arreglo se usan las fórmulas:

- **Hijo izquierdo:** `2 * i + 1`  
- **Hijo derecho:** `2 * i + 2`

El profesor indicó que únicamente se podían actualizar los métodos marcados como:

```java
// Actualizar


#  Tecnologías Utilizadas

- **Lenguaje:** Java SE 21  
- **JDK:** OpenJDK 21 / Oracle JDK 21  
- **IDE utilizado:** *[VS Code, IntelliJ, NetBeans, Notepad++ — especificar]*  
- **Sistema Operativo:** Windows 10 / Windows 11  

---

#  Detalles de Implementación

### ✔ `insert()`
Implementa la inserción en un **árbol binario ordenado** utilizando únicamente métodos iterativos y las fórmulas `2*i+1` y `2*i+2`.

### ✔ `preOrderTraversal()`
Realiza un recorrido **preorden** (root → left → right) utilizando una **pila manual (Stack)**.

### ✔ `postOrderTraversal()`
Implementado utilizando **dos pilas**, dado que el uso de recursividad estaba prohibido por las instrucciones.

### ✔ Restricciones Cumplidas

- No se modificaron firmas de métodos  
- No se cambió el constructor  
- No se cambió `_tree`  
- No se agregó código fuera de zonas permitidas (`// Actualizar`)  
- Se respetó el texto exacto de las impresiones  
- No se agregaron try/catch  
- Se utilizó exclusivamente iteración, no recursión  

---

#  Ejecución del Programa

### Compilar:
cd PP4
javac BinTreeIntArray.java
java BinTreeIntArray

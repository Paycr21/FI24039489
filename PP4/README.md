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



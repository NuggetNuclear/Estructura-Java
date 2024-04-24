# Estructuras Básicas

## Introducción

Las estructuras de datos básicas en Java son fundamentales para organizar y manipular datos de manera eficiente. Estas estructuras proporcionan diferentes formas de almacenar y acceder a los datos, dependiendo de las necesidades del programa.

## Explicación

A continuación están las estructuras básicas de Java:

1. **Arreglos (Arrays):** Los arreglos son estructuras de datos que almacenan elementos del mismo tipo en una secuencia contigua de memoria. Se accede a los elementos mediante un índice y ofrecen un acceso rápido a los datos. Algunos métodos comunes son: `length` para obtener la longitud del arreglo y `clone` para crear una copia del arreglo.

2. **Listas (Lists):** Las listas son estructuras de datos que almacenan elementos en una secuencia ordenada. En Java, la implementación más común es `ArrayList`. Algunos métodos comunes son: `add` para agregar elementos, `get` para obtener un elemento en una posición específica y `size` para obtener el tamaño de la lista.

3. **Pilas (Stacks):** Las pilas son estructuras de datos que siguen el principio LIFO (Last In, First Out). En Java, su implementación se hace con `Stack`. Algunos métodos comunes son: `push` para agregar elementos, `pop` para eliminar el elemento superior y `isEmpty` para verificar si la pila está vacía.

4. **Colas (Queues):** Las colas son estructuras de datos que siguen el principio FIFO (First In, First Out). En Java, la implementación más común es `LinkedList`. Algunos métodos comunes son: `offer` para agregar elementos, `poll` para eliminar el elemento frontal y `isEmpty` para verificar si la cola está vacía.

5. **Conjuntos (Sets):** Los conjuntos son estructuras de datos que almacenan elementos únicos sin un orden específico. En Java, la implementación más común es `HashSet`. Algunos métodos comunes son: `add` para agregar elementos, `contains` para verificar si un elemento está presente y `size` para obtener el tamaño del conjunto.

6. **Mapas (Maps):** Los mapas son estructuras de datos que almacenan pares clave-valor, donde cada clave es única. En Java, la implementación más común es `HashMap`. Algunos métodos comunes son: `put` para agregar un par clave-valor, `get` para obtener el valor asociado a una clave y `containsKey` para verificar si una clave está presente.

7. **Listas enlazadas (Linked Lists):** Las listas enlazadas son estructuras de datos que consisten en nodos enlazados entre sí. Cada nodo contiene un elemento y una referencia al siguiente nodo. En Java, la implementación más común es `LinkedList`. Algunos métodos comunes son: `add` para agregar elementos, `get` para obtener un elemento en una posición específica y `remove` para eliminar un elemento.

8. **Colas dobles (Deques):** Las colas dobles son estructuras de datos que permiten agregar y eliminar elementos tanto por el frente como por el final de la cola. En Java, la implementación más común es `ArrayDeque`. Algunos métodos comunes son: `addFirst` para agregar un elemento al frente, `addLast` para agregar un elemento al final y `removeFirst` para eliminar el elemento del frente.

En términos de eficiencia, tenemos que considerar lo siguiente:

- Los arreglos (Arrays) ofrecen un acceso rápido a los datos mediante un índice, pero tienen un tamaño fijo y requieren mover elementos si se necesita más espacio.
- Las listas (Lists), pilas (Stacks) y colas (Queues) ofrecen un acceso secuencial a los datos y permiten agregar y eliminar elementos de manera eficiente, pero tienen peor rendimiento en operaciones de búsqueda y eliminación en posiciones intermedias.

La elección de la estructura de datos adecuada depende del caso de uso específico y de los requisitos de rendimiento y eficiencia del programa.

Para utilizar cada estructura las podemos importar o implementar nosotros mismos a partir de los códigos de este repositorio:

import java.util.Arrays; // Para arreglos
import java.util.ArrayList; // Para listas
import java.util.Stack; // Para pilas
import java.util.LinkedList; // Para colas
import java.util.HashSet; // Para conjuntos
import java.util.HashMap; // Para mapas
import java.util.LinkedList; // Para listas enlazadas
import java.util.ArrayDeque; // Para colas dobles
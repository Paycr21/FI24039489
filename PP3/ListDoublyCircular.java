import java.util.ArrayDeque;
import java.util.Random;

/**
 * Clase que implementa una Lista Circular Doblemente Enlazada.
 * 
 * En esta estructura:
 * - Cada nodo tiene un puntero al siguiente (next) y al anterior (prev).
 * - El último nodo apunta al primero, y el primero apunta al último.
 * - Se mantiene referencia al inicio (head/first) y al final (tail/last).
 * 
 * Solo se debían implementar los métodos:
 *  addFirst, addLast, removeFirst y removeLast.
 */
public class ListDoublyCircular<T> implements ListInterface<T> {

    private NodeDoubly<T> head = null; // Primer nodo de la lista
    private NodeDoubly<T> tail = null; // Último nodo de la lista

    // Constructor: lista vacía
    public ListDoublyCircular() {
        head = null;
        tail = null;
    }

   
    // MÉTODO: addFirst
    // Agrega un nodo al inicio de la lista
    
    @Override
    public void addFirst(T value) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(value);

        if (head == null) {
            // Caso 1: lista vacía → el nodo se apunta a sí mismo
            head = nuevo;
            tail = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            // Caso 2: lista con elementos
            nuevo.next = head;     // nuevo → apunta al que era primero
            nuevo.prev = tail;     // nuevo → apunta al último
            head.prev = nuevo;     // el primero → apunta atrás al nuevo
            tail.next = nuevo;     // el último → apunta al nuevo
            head = nuevo;          // nuevo pasa a ser el primero
        }
    }

    
    // MÉTODO: addLast
    // Agrega un nodo al final de la lista
    
    @Override
    public void addLast(T value) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(value);

        if (head == null) {
            // Caso 1: lista vacía → el nodo se apunta a sí mismo
            head = nuevo;
            tail = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            // Caso 2: lista con elementos
            nuevo.prev = tail;     // nuevo ← apunta al que era último
            nuevo.next = head;     // nuevo → apunta al primero
            tail.next = nuevo;     // el último → apunta al nuevo
            head.prev = nuevo;     // el primero ← apunta al nuevo
            tail = nuevo;          // nuevo pasa a ser el último
        }
    }

    
    // MÉTODO: removeFirst
    // Elimina el primer nodo y retorna su valor
    
    @Override
    public T removeFirst() {
        if (head == null) return null; // Lista vacía → no hay nada que borrar

        T valor = head.data; // Guardamos el valor a retornar

        if (head == tail) {
            // Caso 1: solo un elemento
            head = null;
            tail = null;
        } else {
            // Caso 2: más de un elemento
            head = head.next;   // Avanzamos el inicio
            head.prev = tail;   // Cerramos la circularidad
            tail.next = head;
        }

        return valor;
    }

    /
    // MÉTODO: removeLast
    // Elimina el último nodo y retorna su valor
    
    @Override
    public T removeLast() {
        if (tail == null) return null; // Lista vacía

        T valor = tail.data; // Guardamos el valor del nodo que se eliminará

        if (head == tail) {
            // Caso 1: solo un elemento
            head = null;
            tail = null;
        } else {
            // Caso 2: más de un elemento
            tail = tail.prev;   // Retrocedemos el final
            tail.next = head;   // Cerramos la circularidad
            head.prev = tail;
        }

        return valor;
    }

    
    // MÉTODOS YA IMPLEMENTADOS (NO MODIFICAR)
    

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public Boolean isEmpty() {
        return head == null;
    }

    @Override
    public Integer getSize() {
        int size = 0;
        if (!isEmpty()) {
            NodeDoubly<T> actual = head;
            do {
                size++;
                actual = actual.next;
            } while (actual != head);
        }
        return size;
    }

    @Override
    public void printList() {
        if (!isEmpty()) {
            NodeDoubly<T> curr = head;
            do {
                System.out.println("\t" + curr.prev.data + " ⇄ | " + curr.data + " | ⇄ " + curr.next.data);
                curr = curr.next;
            } while (curr != head);
        }
    }

    @Override
    public void printListInReverse() {
        if (!isEmpty()) {
            NodeDoubly<T> curr = tail;
            System.out.print("| ");
            do {
                System.out.print(curr.data + " | ");
                curr = curr.prev;
            } while (curr != tail);
            System.out.println();
        }
    }

    
    // MAIN (no modificar)
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ListInterface<Integer> list = new ListDoublyCircular<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Random random = new Random();

        // Agregar elementos (n * 2 al inicio y n * 2 al final)
        for (int i = 0; i < n * 2; i++) {
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            list.addFirst(a);
            list.addLast(b);
            deque.addFirst(a);
            deque.addLast(b);
        }

        System.out.println();
        System.out.println("List {added: n * 4}: " + deque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print:");
        list.printList();

        // Eliminar elementos (n al inicio y n al final)
        for (int i = 0; i < n; i++) {
            list.removeFirst();
            list.removeLast();
            deque.removeFirst();
            deque.removeLast();
        }

        System.out.println();
        System.out.println("List {removed: n * 2}: " + deque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print:");
        list.printList();

        // Vaciar completamente la lista
        while (!list.isEmpty()) {
            list.removeFirst();
            list.removeLast();
        }
        deque.clear();

        System.out.println();
        System.out.println("List {empty}: " + deque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print:");
        list.printList();
    }
}

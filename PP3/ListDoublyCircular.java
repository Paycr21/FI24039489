import java.util.ArrayDeque;
import java.util.Random;

public class ListDoublyCircular<T> implements ListInterface<T> {

    private NodeDoubly<T> first; // Primer nodo
    private NodeDoubly<T> last;  // Último nodo

    public ListDoublyCircular() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void addFirst(T value) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(value);

        if (first == null) { // lista vacía
            first = nuevo;
            last = nuevo;
            first.next = first;
            first.prev = first;
        } else {
            nuevo.next = first;
            nuevo.prev = last;
            last.next = nuevo;
            first.prev = nuevo;
            first = nuevo;
        }
    }

    @Override
    public void addLast(T value) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(value);

        if (first == null) { // lista vacía
            first = nuevo;
            last = nuevo;
            first.next = first;
            first.prev = first;
        } else {
            nuevo.prev = last;
            nuevo.next = first;
            last.next = nuevo;
            first.prev = nuevo;
            last = nuevo;
        }
    }

    @Override
    public T removeFirst() {
        if (first == null) return null;

        T value = first.data;

        if (first == last) { // un solo elemento
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = last;
            last.next = first;
        }

        return value;
    }

    @Override
    public T removeLast() {
        if (last == null) return null;

        T value = last.data;

        if (first == last) { // un solo nodo
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }

        return value;
    }

    public T getFirst() {
        return (first != null) ? first.data : null;
    }

    public T getLast() {
        return (last != null) ? last.data : null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;
        if (!isEmpty()) {
            NodeDoubly<T> current = first;
            do {
                count++;
                current = current.next;
            } while (current != first);
        }
        return count;
    }

    public void printForward() {
        if (!isEmpty()) {
            NodeDoubly<T> current = first;
            do {
                System.out.println("\t" + current.prev.data + " ⇄ | " + current.data + " | ⇄ " + current.next.data);
                current = current.next;
            } while (current != first);
        }
    }

    public void printReverse() {
        if (!isEmpty()) {
            NodeDoubly<T> current = last;
            System.out.print("| ");
            do {
                System.out.print(current.data + " | ");
                current = current.prev;
            } while (current != last);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ListInterface<Integer> lista = new ListDoublyCircular<>();
        ArrayDeque<Integer> cola = new ArrayDeque<>();
        Random random = new Random();

        // Agregar elementos
        for (int i = 0; i < n * 2; i++) {
            int v1 = random.nextInt(10);
            int v2 = random.nextInt(10);
            lista.addFirst(v1);
            lista.addLast(v2);
            cola.addFirst(v1);
            cola.addLast(v2);
        }

        System.out.println();
        System.out.println("List {added: n * 4}: " + cola);
        System.out.println(" ↳ Size: " + ((ListDoublyCircular<?>) lista).size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        System.out.print(" ↳ Reverse: ");
        ((ListDoublyCircular<?>) lista).printReverse();
        System.out.println(" ↳ Print:");
        ((ListDoublyCircular<?>) lista).printForward();

        // Eliminar elementos
        for (int i = 0; i < n; i++) {
            lista.removeFirst();
            lista.removeLast();
            cola.removeFirst();
            cola.removeLast();
        }

        System.out.println();
        System.out.println("List {removed: n * 2}: " + cola);
        System.out.println(" ↳ Size: " + ((ListDoublyCircular<?>) lista).size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        System.out.print(" ↳ Reverse: ");
        ((ListDoublyCircular<?>) lista).printReverse();
        System.out.println(" ↳ Print:");
        ((ListDoublyCircular<?>) lista).printForward();

        // Vaciar completamente
        while (!lista.isEmpty()) {
            lista.removeFirst();
            lista.removeLast();
        }

        cola.clear();
        System.out.println();
        System.out.println("List {empty}: " + cola);
        System.out.println(" ↳ Size: " + ((ListDoublyCircular<?>) lista).size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        System.out.print(" ↳ Reverse: ");
        ((ListDoublyCircular<?>) lista).printReverse();
        System.out.println(" ↳ Print:");
        ((ListDoublyCircular<?>) lista).printForward();
    }
}

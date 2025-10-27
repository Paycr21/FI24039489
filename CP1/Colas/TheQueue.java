// Fuente: ChatGPT 
// Se corrigieron dequeue() y getFront() (sin if, usando pollFirst/peekFirst).
// Se implementó getCodons() para formar tripletas y vaciar la cola.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    @Override
    public void enqueue(Type item) {
        _queue.addLast(item);
    }

    @Override
    public Type dequeue() {
        return _queue.pollFirst(); // null si está vacía
    }

    @Override
    public Type getFront() {
        return _queue.peekFirst(); // null si está vacía
    }

    @Override
    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    @Override
    public int getSize() {
        return _queue.size();
    }

    @Override
    public String[] getCodons() {
        int size = _queue.size();
        String[] codons = new String[size / 3];
        for (int i = 0; i < codons.length; i++) {
            StringBuilder codon = new StringBuilder();
            codon.append(_queue.pollFirst());
            codon.append(_queue.pollFirst());
            codon.append(_queue.pollFirst());
            codons[i] = codon.toString();
        }
        return codons;
    }

    @Override
    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        var amount = Integer.parseInt(args[0]);
        String[] nucleotides = {"A","C","G","T"};

        TheQueueInterface<String> queue = new TheQueue<String>();
        var random = new Random();

        for (; amount > 0; amount--) {
            var index = random.nextInt(4);
            var amino = nucleotides[index];
            queue.enqueue(amino);
        }

        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());

        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));

        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}

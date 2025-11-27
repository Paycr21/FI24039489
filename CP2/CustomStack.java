public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        // Implementación apoyada por ChatGPT
        node.setNext(_head);   // insertar al inicio
        _head = node;
    }

    public String pop() {
        String word = null;

        // Actualizar
        // Implementación apoyada por ChatGPT
        if (_head != null) {
            word = _head.getWord();   // obtenemos la palabra
            _head = _head.getNext();  // avanzamos al siguiente nodo
        }

        return word;
    }

    public int size() {
        var length = 0;

        // Actualizar
        // Implementación apoyada por ChatGPT
        StackNode current = _head;
        while (current != null) {
            length++;
            current = current.getNext();   // usamos getNext()
        }

        return length;
    }

    public String getWords() {
        var builder = new StringBuilder("(" + size() + ") [");
        for (var word = pop(); word != null; word = pop()) {
            builder.append(" " + word);
        }
        builder.append(" ]");
        return builder.toString();
    }
}

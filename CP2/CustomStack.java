public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        // Implementación apoyada por ChatGPT
        node._next = _head;

        _head = node;
    }

    public String pop() {
        String word = null;

        // Actualizar
        // Implementación apoyada por ChatGPT
        if (_head != null) {
            word = _head._value;
            _head = _head._next;
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
            current = current._next;
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

public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);

        // Actualizar
        // Implementación apoyada por ChatGPT
        if (_head == null) {
            _head = node;
        } else {
            QueueNode current = _head;
            while (current._next != null) {
                current = current._next;
            }
            current._next = node;
        }
    }

    public int dequeue() {
        var index = -1;

        // Actualizar
        // Implementación apoyada por ChatGPT
        if (_head != null) {
            index = _head._value;
            _head = _head._next;
        }

        return index;
    }

    public int getSize() {
        var size = 0;

        // Actualizar
        // Implementación apoyada por ChatGPT
        QueueNode current = _head;
        while (current != null) {
            size++;
            current = current._next;
        }

        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}


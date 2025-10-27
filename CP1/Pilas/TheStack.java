// Fuente: ChatGPT 
// Se corrigió el método push() para manejar el límite de la pila
// y se ajustaron los métodos pop() y peek() para retornar null cuando está vacía.

import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;
    private Integer _capacity;

    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    @Override
    public Boolean push(Type item) {
        if (_stack.size() >= _capacity) {
            return false; // overflow
        }
        _stack.push(item);
        return true;
    }

    @Override
    public Type pop() {
        if (_stack.isEmpty()) return null;
        return _stack.pop();
    }

    @Override
    public Type peek() {
        if (_stack.isEmpty()) return null;
        return _stack.peek();
    }

    @Override
    public Boolean empty() {
        return _stack.isEmpty();
    }

    @Override
    public Integer size() {
        return _stack.size();
    }

    @Override
    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        var capacity = Integer.parseInt(args[0]);
        TheStackInterface<Double> stack = new TheStack<Double>(capacity);

        System.out.println("Pushing {capacity + 1}");
        var random = new Random();
        for (var n = 0; n <= capacity; n++) {
            var number = random.nextDouble();
            var pushed = stack.push(number);
            System.out.println(" ↳ push(" + number + ") → " + pushed);
        }

        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());

        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (var n = 0; n <= capacity; n++) {
            var popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }

        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}

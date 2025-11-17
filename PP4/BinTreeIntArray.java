import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    // ========== INSERT ==========
    public void insert(int value) {
        int index = 0;

        while (index < _tree.length) {

            if (_tree[index] == null) {
                _tree[index] = value;
                break;
            }

            if (value < _tree[index]) {
                index = 2 * index + 1;   // left
            } else {
                index = 2 * index + 2;   // right
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    // ========== INORDER (YA VENÍA HECHO) ==========
    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    // ========== PREORDER ==========
    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int index = stack.pop();
            System.out.print(_tree[index] + " ");

            int right = 2 * index + 2;
            int left = 2 * index + 1;

            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }

        System.out.println();
    }

    // ========== POSTORDER ==========
    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(0);

        while (!stack1.isEmpty()) {
            int index = stack1.pop();
            stack2.push(index);

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < _tree.length && _tree[left] != null) {
                stack1.push(left);
            }
            if (right < _tree.length && _tree[right] != null) {
                stack1.push(right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(_tree[stack2.pop()] + " ");
        }

        System.out.println();
    }

    // ========== MAIN (NO TOCAR) ==========
    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal();     
        tree.preOrderTraversal();    
        tree.postOrderTraversal();   
    }
}


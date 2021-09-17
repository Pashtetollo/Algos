import java.util.Scanner;

class Node {
    public Node() {
    }

    public Node(int val, Node next, Node previous) {
        this.value = val;
        this.next = next;
        this.previous = previous;
    }

    int value;
    Node next;
    Node previous;
}

public class Stack {
    Node head;

    public void push(int val) {
        if (this.head == null) {
            this.head = new Node();
            this.head.value = val;
        } else {
            Node temp = new Node(this.head.value, this.head.next, this.head.previous);
            this.head = new Node(val, temp, null);
            temp.previous = this.head;
        }
    }

    public Node pop() throws RuntimeException {
        if (this.head == null) {
            throw new RuntimeException("Your stack is empty");
        }
        Node val = this.head;
        this.head = head.next;
        return val;
    }

    public Node peek() throws RuntimeException {
        if (this.head == null) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.head;
    }

    public Node get(int position) throws RuntimeException{
        Node temp = this.head;
            for (int i = 1; i< position; i++){
                if(temp.next != null) {
                    temp = temp.next;
                }
                else{
                    throw new RuntimeException("Index out of range");
                }
            }
            return temp;
    }
    public void printStack() {
        if (this.head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Elements inside stack:");
            System.out.print("TOP —> ");
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;

            }
            System.out.println("<— BOTTOM");
        }
    }

    public void decider(String input) {
        String[] arr = input.split(" ");
        switch (arr[0]) {
            case ("/push") -> {
                for (int i = 1; i < arr.length; i++) {
                    this.push(Integer.parseInt(arr[i]));
                }
            }
            case ("/pop") -> System.out.println("deleted element: " + this.pop().value);
            case ("/peek") -> System.out.println("value on top of stack: " + this.peek().value);
            case ("/exit") -> System.exit(0);
            case("/get") -> System.out.println(this.get(Integer.parseInt(arr[1])).value);
            case ("/printStack") -> this.printStack();
            case ("/help") -> System.out.println("""
                    /push <num1> <num2> <num...> - add numbers to a stack
                    /peek - get number on top of stack
                    /pop - delete element on top of a stack
                    /exit - exit the program
                    /help - print this window
                    /get <pos> - get value of an element on <pos> position (1st element`s position is 1)
                    /printStack - print inners of a stack.""");
            default -> System.out.println(input + " is not recognized as internal command");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner in = new Scanner(System.in);
        System.out.println("\n\nThis program simulates stack data structure.\nTo see available commands type: /help");
        while (true) {
            stack.decider(in.nextLine());
        }
    }
}

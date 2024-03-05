package demo04_consumerProducer;

public class MyStack {

    private int [] values;
    private int tos = 0; // top of stack, LIFO, tos-1 is the top element

    public MyStack(int size) {
        values = new int[size];
    }

    public boolean isFull() {
        return values.length == tos;
    }

    public boolean isEmpty() {
        return tos == 0;
    }

    public void push(int value) {
        if(this.isFull())
            throw new RuntimeException("Stack is full");
        values[tos++] = value;
    }

    public int pop() {
        if(this.isEmpty())
            throw new RuntimeException("Stack is empty");
        return values[--tos];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < tos; i++) {
            sb.append(values[i] + (i == tos - 1 ? "" : ","));
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
    }
}

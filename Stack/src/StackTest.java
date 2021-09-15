import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class StackTest {
    @Test
    public void peekTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.peek(), 3);
    }

    @Test
    public void popTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.pop(), 3);
        assertEquals(stack.pop(), 5);
    }

    @Test
    public void pushTest (){
        Stack stack = new Stack();
            stack.push(4);
            assertEquals(stack.peek(), 4);
            stack.push(2);
            assertEquals(stack.peek(), 2);
        }
}

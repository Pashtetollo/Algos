import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class StackTest {
    @Test
    public void peekStackTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.peek(), 3);
    }

    @Test
    public void popStackTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.pop(), 3);
        assertEquals(stack.pop(), 5);
    }
}

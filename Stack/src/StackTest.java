import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class StackTest {
    @Test
    public void peekTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.peek().value, 3);
    }

    @Test
    public void popTest (){
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        assertEquals(stack.pop().value, 3);
        assertEquals(stack.pop().value, 5);
    }

    @Test
    public void pushTest (){
        Stack stack = new Stack();
            stack.push(4);
            assertEquals(stack.peek().value, 4);
            stack.push(2);
            assertEquals(stack.peek().value, 2);
        }

    @Test
    public void getTest(){
        Stack stack = new Stack();
        stack.push(5);
        stack.push(7);
        assertEquals(stack.get(2).value, 5);
        stack.push(3);
        assertEquals(stack.get(2).value, 7);
        assertEquals(stack.get(1).value, 3);
    }
}

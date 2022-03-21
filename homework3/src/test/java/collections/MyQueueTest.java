package collections;

import exceptions.EmptyQueueException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyQueue;

public class MyQueueTest {
    private MyQueue<Integer> myQueue;

    @BeforeMethod
    public void initMyDDL() {
        myQueue = new MyQueue<>();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testEnqueueMethodWithNull() {
        myQueue.enqueue(null);
    }

    @Test
    public void testEnqueueMethod() {
        myQueue.enqueue(5);
        Assert.assertEquals(myQueue.size(), 1);
    }

    @Test
    public void testDequeueMethod() {
        myQueue.enqueue(8);
        Assert.assertEquals(myQueue.dequeue(), 8);
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testDequeueMethodWithEmptyQueue() {
        Assert.assertEquals(myQueue.dequeue(), 0);
    }

    @Test
    public void testPeekMethod() {
        myQueue.enqueue(5);
        Assert.assertEquals(myQueue.peek(), 5);
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testPeekMethodWithEmptyQueue() {
        Assert.assertEquals(myQueue.peek(), 5);
    }

    @Test
    public void testMethodDeQueueAll() {
        myQueue.enqueue(5);
        myQueue.enqueue(3);
        myQueue.enqueue(6);
        myQueue.dequeueAll();
        Assert.assertEquals(myQueue.size(), 0);
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testEquals() {
        MyQueue<Integer> elementForCheck = new MyQueue<>();
        elementForCheck.enqueue(5);
        MyQueue<Integer> elementForCheckTwo = new MyQueue<>();
        elementForCheckTwo.enqueue(9);
        myQueue.enqueue(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myQueue.equals(elementForCheck));
        softAssert.assertFalse(myQueue.equals(7));
        softAssert.assertFalse(myQueue.equals(elementForCheckTwo));
        softAssert.assertAll();
    }

    @Test
    public void testToArrayMethod(){
        Integer [] array = new Integer[]{5,8};
        myQueue.enqueue(5);
        myQueue.enqueue(8);
        Assert.assertEquals(myQueue.toArray(),array);
    }
    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayMethodWithParameterNull(){
        Integer [] array = null;
        Assert.assertEquals(myQueue.toArray(null),array);
    }
    @Test
    public void testToArrayMethodWithParameter(){
        Integer [] array = new Integer[]{8,5};
        myQueue.enqueue(8);
        myQueue.enqueue(5);
        Assert.assertEquals(myQueue.toArray(array),array);
    }
    @Test
    public void testIsFullMethod(){
        myQueue.enqueue(2);
        myQueue.enqueue(2);
        Assert.assertFalse(myQueue.isFull());
    }
    @Test
    public void testSizeMethod(){
        myQueue.enqueue(2);
        Assert.assertEquals(myQueue.size(),1);
    }
}



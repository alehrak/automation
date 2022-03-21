package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyStack;

import java.util.EmptyStackException;

public class MyStackTest {

    private MyStack<Integer> testingStack;

    @BeforeMethod
    public void initStack() {
        testingStack = new MyStack<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingStack.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testPush() {
        testingStack.push(6);
        Assert.assertEquals(testingStack.size(), 1);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testPopMethodWithEmptyStack(){
        Assert.assertEquals(testingStack.pop(),3);
    }

    @Test
    public void testPopMethod(){
        testingStack.push(3);
        Assert.assertEquals(testingStack.pop(),3);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testPeekMethodWithEmptyStack(){
        Assert.assertEquals(testingStack.pop(),3);
    }

    @Test
    public void testPeekMethod(){
        testingStack.push(10);
        Assert.assertEquals(testingStack.peek(),10);
    }

    @Test
    public void testClearMethod(){
        testingStack.push(10);
        testingStack.push(3);
        testingStack.clear();
        Assert.assertEquals(testingStack.size(),0);
    }

    @Test
    public void testIsEmptyMethod() {
        Assert.assertTrue(testingStack.isEmpty());
    }
    @Test
    public void testContainsMethod(){
        SoftAssert softAssert = new SoftAssert();
        testingStack.push(3);
        softAssert.assertTrue(testingStack.contains(3));
        softAssert.assertFalse(testingStack.contains(4));
        softAssert.assertAll();
    }
    @Test
    public void testIsSearchMethod() {
        testingStack.push(3);
        testingStack.push(2);
        testingStack.push(1);
        testingStack.push(5);
        Assert.assertEquals(testingStack.search(3),4);
    }
    @Test
    public void testSizeMethod(){
        testingStack.push(3);
        testingStack.push(2);
        testingStack.push(1);
        Assert.assertEquals(testingStack.size(),3);
    }
}

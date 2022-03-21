package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyDLL;

public class MyDDLTest {
    private MyDLL<Integer> myDLL;

    @BeforeMethod
    public void initMyDDL() {
        myDLL = new MyDLL<>();
    }

    @Test
    public void testIsEmptyMethod() {
        Assert.assertTrue(myDLL.isEmpty());
    }

    @Test
    public void testMethodToArrayWithInputParameters() {
        Integer[] array = new Integer[]{1, 2, 3, 4};
        Assert.assertEquals(myDLL.toArray(array), array);
    }

    @Test
    public void testContainsMethod() {
        SoftAssert softAssert = new SoftAssert();
        myDLL.add(7);
        softAssert.assertTrue(myDLL.contains(7));
        softAssert.assertFalse(myDLL.contains(4));
        softAssert.assertAll();
    }

    @Test
    public void testMethodToArray() {
        myDLL.add(3);
        myDLL.add(4);
        Object[] arrayForCheck = new Object[]{3, 4};
        Assert.assertEquals(myDLL.toArray(), arrayForCheck);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMethodAddForNull() {
        Assert.assertEquals(myDLL.add(null), null);
    }

    @Test
    public void testMethodAdd() {
        myDLL.add(5);
        Assert.assertEquals(myDLL.get(0), 5);
    }

    @Test
    public void testMethodAddAll() {
        MyDLL<Integer> myDDLToAdd = new MyDLL<>();
        myDDLToAdd.add(3);
        myDDLToAdd.add(7);
        Assert.assertTrue(myDLL.addAll(myDDLToAdd));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMethodRemoveForNull() {
        Assert.assertEquals(myDLL.remove(null), 5);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testMethodRemoveByIndexNegative() {
        Assert.assertEquals(myDLL.remove(3), 5);
    }

    @Test
    public void testMethodRemoveByIndexPositive() {
        myDLL.add(5);
        Assert.assertEquals(myDLL.remove(0), 5);
    }

    @Test
    public void testMethodRemoveByValue() {
        myDLL.add(5);
        Integer integerToRemove = 5;
        Assert.assertEquals(myDLL.remove(integerToRemove), 5);
    }

    @Test
    public void testMethodClear() {
        myDLL.add(5);
        myDLL.clear();
        Assert.assertEquals(myDLL.size(), 0);
    }

    @Test
    public void testMethodSize() {
        myDLL.add(5);
        Assert.assertEquals(myDLL.size(), 1);
    }

    @Test
    public void testMethodGetByIndex() {
        myDLL.add(5);
        Assert.assertEquals(myDLL.get(0), 5);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testMethodGetByIndexNegative() {
        myDLL.add(5);
        Assert.assertEquals(myDLL.get(3), 5);
    }

    @Test
    public void testSetMethod() {
        myDLL.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myDLL.get(0).intValue(), 5);
        softAssert.assertEquals(myDLL.set(0, 10).intValue(), 5);
        softAssert.assertEquals(myDLL.get(0).intValue(), 10);
        softAssert.assertAll();
    }
}

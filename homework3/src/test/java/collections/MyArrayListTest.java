package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyArrayList;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testDeleteElementByIndex() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test
    public void testDeleteElementByValue() {
        testingArray.add(5);
        testingArray.add(6);
        Integer elementByRemove = 5;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 2);
        testingArray.remove(elementByRemove);
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }

    @Test
    public void testSize() {
        testingArray.add(3);
        testingArray.add(5);
        testingArray.add(7);
        Assert.assertEquals(testingArray.size(), 3);
    }

    @Test
    public void testClearCollection() {
        testingArray.add(3);
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 2);
        testingArray.clear();
        softAssert.assertEquals(testingArray.size(), 0);
        softAssert.assertAll();
    }

    @Test
    public void testAddAndGetElementToIndex() {
        testingArray = new MyArrayList<>(6);
        testingArray.add(5);
        testingArray.add(7);
        testingArray.add(4);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.get(1).intValue(), 7);
        testingArray.add(1, 12);
        softAssert.assertEquals(testingArray.get(1).intValue(), 12);
        softAssert.assertAll();
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckToGet() {
        testingArray.get(10);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckToRemove() {
        testingArray.remove(3);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckToSet() {
        testingArray.set(3, 5);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckForInsertMoreSize() {
        testingArray.add(5, 3);
    }

    @Test
    public void testSetElement() {
        testingArray.add(23);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.get(0).intValue(), 23);
        testingArray.set(0, 90);
        softAssert.assertEquals(testingArray.get(0).intValue(), 90);
        softAssert.assertAll();
    }

    @Test
    public void testAddAllMethod() {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        test.add(3);
        testingArray.addAll(test);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.get(0).intValue(), 1);
        softAssert.assertEquals(testingArray.get(1).intValue(), 3);
        softAssert.assertAll();
    }

    @Test
    public void testIsEmptyMethod() {
        Assert.assertTrue(testingArray.isEmpty());
    }
    @Test
    public void testContainsMethod(){
        testingArray.add(1234);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testingArray.contains(1234));
        softAssert.assertFalse(testingArray.contains(1235));
        softAssert.assertAll();
    }
}

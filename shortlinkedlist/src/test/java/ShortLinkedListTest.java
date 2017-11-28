import generic.ShortLinkedList;
import generic.ShortLinkedListExceptions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class ShortLinkedListTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = NullPointerException.class)
    public void testInitialization() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        Assert.assertNull(shortLinkedList.first());
        Assert.assertNull(shortLinkedList.last());
        Assert.assertEquals(0, shortLinkedList.size());
    }

    @Test
    public void testAdd(){
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(100);
        shortLinkedList.add(101);
        shortLinkedList.add(102);

        short size = shortLinkedList.getSize();
        Assert.assertEquals((long)size, 3);
    }

    @Test
    public void testGetWithNegativeIndex() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage(ShortLinkedListExceptions.EXP_INDEX_NEGATIVE);

        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(15);
        shortLinkedList.add(18);
        shortLinkedList.add(23);

        long var1 = shortLinkedList.get((short) -1);

        Assert.assertEquals((long)var1, 15);
    }

    @Test
    public void testGet() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(15);
        shortLinkedList.add(18);
        shortLinkedList.add(23);

        long var1 = shortLinkedList.get((short) 0);
        long var2 = shortLinkedList.get((short) 1);
        long var3 = shortLinkedList.get((short) 2);

        Assert.assertEquals((long)var1, 15);
        Assert.assertEquals((long)var2, 18);
        Assert.assertEquals((long)var3, 23);
    }

    @Test
    public void testGetWithLargerIndex() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage(ShortLinkedListExceptions.EXP_INDEX_LARGE);

        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(15);
        shortLinkedList.add(18);
        shortLinkedList.add(23);

        long var1 = shortLinkedList.get((short)4);
        Assert.assertEquals((long)var1, 15);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithLargeIndex() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(2);
        shortLinkedList.add(3);
        shortLinkedList.add(5);

        short index2 = 55;
        shortLinkedList.add(index2,4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithSmallIndex() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(2);
        shortLinkedList.add(3);
        shortLinkedList.add(5);

        short index1 = -1;
        shortLinkedList.add(index1,4);
    }

    @Test
    public void testAddWithIndex() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(2);
        shortLinkedList.add(3);
        shortLinkedList.add(42);
        shortLinkedList.add(6);
        shortLinkedList.add(7);
        shortLinkedList.add(9);
        shortLinkedList.add(10);
        shortLinkedList.add(11);

        short index3 = 5;
        shortLinkedList.add(index3, 8);

        short size = shortLinkedList.size();
        Assert.assertEquals((long)shortLinkedList.get(index3), 8);
        Assert.assertEquals((long)size, 9);
    }

    @Test
    public void testAddWithIndexAt0() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(2);
        shortLinkedList.add(3);
        shortLinkedList.add(5);
        shortLinkedList.add(6);
        shortLinkedList.add(8);

        short index3 = 0;
        shortLinkedList.add(index3, 7);

        Assert.assertEquals((long)shortLinkedList.get(index3), 7);
        Assert.assertEquals((long)shortLinkedList.size(), 6);
    }

    @Test
    public void testAddWithIndexAt1() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(2);
        shortLinkedList.add(3);
        shortLinkedList.add(5);
        shortLinkedList.add(6);
        shortLinkedList.add(8);

        short index3 = 1;
        shortLinkedList.add(index3, 7);

        Assert.assertEquals((long)shortLinkedList.get(index3), 7);
        Assert.assertEquals((long)shortLinkedList.size(), 6);
    }


    @Test
    public void testInsertWithLargeIndex(){
        expectedException.expectMessage(ShortLinkedListExceptions.EXP_INDEX_LARGE);
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.add(4);
        integerShortLinkedList.insert((short)1,5);
    }

    @Test()
    public void testInsertWithSmallIndex() {
        expectedException.expectMessage(ShortLinkedListExceptions.EXP_INDEX_NEGATIVE);
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.insert((short)-1,5);
    }

    //    INSERT
    @Test()
    public void testInsertAtIndex0() {
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.add(54);
        integerShortLinkedList.add(3);
        integerShortLinkedList.add(4);
        integerShortLinkedList.add(76);

        short index = 0;
        int value = 19;




        integerShortLinkedList.insert(index,value);
        Assert.assertEquals(value, (long)integerShortLinkedList.get(index));
        Assert.assertEquals(5, integerShortLinkedList.size());

    }

    @Test()
    public void testInsertAtIndex1() {
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.add(54);
        integerShortLinkedList.add(64);
        integerShortLinkedList.add(31);
        integerShortLinkedList.add(76);
        integerShortLinkedList.add(64);
        integerShortLinkedList.add(4);
        integerShortLinkedList.add(76);

        short index = 1;
        int value = 19;
        integerShortLinkedList.insert(index,value);
        Assert.assertEquals(value, (long)integerShortLinkedList.get(index));
        Assert.assertEquals(8, integerShortLinkedList.size());

    }

    @Test()
    public void testInsertAtIndexAnyMiddle() {
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.add(54);
        integerShortLinkedList.add(3876);
        integerShortLinkedList.add(4);
        integerShortLinkedList.add(76);

        short index = 2;
        int value = 19;
        integerShortLinkedList.insert(index,value);

        Assert.assertEquals(value, (long)integerShortLinkedList.get(index));
        Assert.assertEquals(5, integerShortLinkedList.size());
    }

    @Test()
    public void testInsertAtIndexLast() {
        ShortLinkedList<Integer> integerShortLinkedList = new ShortLinkedList<>();
        integerShortLinkedList.add(-1);
        integerShortLinkedList.add(34);
        integerShortLinkedList.add(454);
        integerShortLinkedList.add(76);
        integerShortLinkedList.add(454);

        short index = 4;
        int value = 19;

        integerShortLinkedList.insert(index,value);

        Assert.assertEquals(value, (long)integerShortLinkedList.get(index));
        Assert.assertEquals(6, integerShortLinkedList.size());
    }
}

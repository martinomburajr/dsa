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
        Integer integer = shortLinkedList.root();
        Assert.assertNull(integer);
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

    
}

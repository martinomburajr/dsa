import generic.ShortLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class ShortLinkedListTest {

    @Test
    public void testInitialization() {
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        Integer integer = shortLinkedList.root();
        Assert.assertNull(integer);
    }

    @Test
    public void testGet(){
        ShortLinkedList<Integer> shortLinkedList = new ShortLinkedList<>();
        shortLinkedList.add(100);
        shortLinkedList.add(101);
        shortLinkedList.add(102);

        Integer val = shortLinkedList.get((short) 0);
        Assert.assertEquals((long)val, 100);
    }
}

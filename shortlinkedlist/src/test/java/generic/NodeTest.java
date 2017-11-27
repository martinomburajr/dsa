package generic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void initialization() {
        Node<Integer> node = new Node<>(4,null);
        Assert.assertEquals((long)node.getValue(), 4);
        Assert.assertEquals(node.getNext(), null);
    }

    @Test
    public void propertyMethods() {
        Node<Integer> node = new Node<>(0,null);
        Assert.assertEquals((long)node.getValue(), 0);
        Assert.assertEquals(node.getNext(), null);

        Node newNode = new Node(6, null);
        node.setValue(5);
        node.setNext(newNode);
        Assert.assertEquals((long)node.getValue(), 5);
        Assert.assertEquals(node.getNext(), newNode);
    }
}
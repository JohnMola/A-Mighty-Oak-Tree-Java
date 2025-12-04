package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void testNodeCreation() {
        Squirrel squirrel = new Squirrel("Test Squirrel");
        Node<Squirrel> node = new Node<>(squirrel);
        
        assertEquals(Node.class, node.getClass());
        assertEquals(null, node.left());
        assertEquals(null, node.right());
        assertEquals(squirrel, node.getObj());
    }

    @Test
    public void testSetLeftAndRight() {
        Squirrel leftSquirrel = new Squirrel("Left Squirrel");
        Node<Squirrel> leftNode = new Node<>(leftSquirrel);
        
        Squirrel rightSquirrel = new Squirrel("Right Squirrel");
        Node<Squirrel> rightNode = new Node<>(rightSquirrel);
        
        Squirrel rootSquirrel = new Squirrel("Root Squirrel");
        Node<Squirrel> rootNode = new Node<>(rootSquirrel);
        
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        
        assertEquals(leftNode, rootNode.left());
        assertEquals(rightNode, rootNode.right());
    }

    @Test
    public void testGetObj() {
        Squirrel squirrel = new Squirrel("Test Squirrel");
        Node<Squirrel> node = new Node<>(squirrel);
        
        assertEquals(squirrel, node.getObj());
    }

    @Test
    public void testGetLeftAndRightWhenNull() {
        Squirrel squirrel = new Squirrel("Test Squirrel");
        Node<Squirrel> node = new Node<>(squirrel);
        
        assertEquals(null, node.left());
        assertEquals(null, node.right());
    }
    @Test
    public void testSetRightToNullAfterAssignment() {
        Node<Squirrel> node = new Node<>(new Squirrel("Root"));
        Node<Squirrel> right = new Node<>(new Squirrel("Right"));
        node.setRight(right);
        assertEquals(right, node.right());
        node.setRight(null);
        assertEquals(null, node.right());
    }

    @Test
    public void testDeepTreeStructure() {
        Node<Integer> root = new Node<>(10);
        Node<Integer> left = new Node<>(5);
        Node<Integer> right = new Node<>(15);
        Node<Integer> leftLeft = new Node<>(3);
        Node<Integer> rightRight = new Node<>(20);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        right.setRight(rightRight);

        assertEquals(3, root.left().left().getObj());
        assertEquals(20, root.right().right().getObj());
        assertEquals(null, root.left().right());
        assertEquals(null, root.right().left());
    }

    @Test
    public void testNodeWithNullObject() {
        Node<String> node = new Node<>(null);
        assertEquals(null, node.getObj());
        assertEquals(null, node.left());
        assertEquals(null, node.right());
    }

    @Test
    public void testSetLeftAndRightMultipleTimes() {
        Node<Integer> node = new Node<>(1);
        Node<Integer> left1 = new Node<>(2);
        Node<Integer> left2 = new Node<>(3);
        node.setLeft(left1);
        assertEquals(left1, node.left());
        node.setLeft(left2);
        assertEquals(left2, node.left());

        Node<Integer> right1 = new Node<>(4);
        Node<Integer> right2 = new Node<>(5);
        node.setRight(right1);
        assertEquals(right1, node.right());
        node.setRight(right2);
        assertEquals(right2, node.right());
    }

    @Test
    public void testWithIntegerNode() {
        Node<Integer> intNode = new Node<>(42);

        intNode.setLeft(new Node<>(21));
        intNode.setRight(new Node<>(84));
        
        assertEquals(42, intNode.getObj());
        assertEquals(21, intNode.left().getObj());
        assertEquals(84, intNode.right().getObj());
    }

    @Test
    public void testWithStringNode() {
        Node<String> stringNode = new Node<>("Hello");

        stringNode.setLeft(new Node<>("World"));
        stringNode.setRight(new Node<>("!"));
        
        assertEquals("Hello", stringNode.getObj());
        assertEquals("World", stringNode.left().getObj());
        assertEquals("!", stringNode.right().getObj());
    }
}
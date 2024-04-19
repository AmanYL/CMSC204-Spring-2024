import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MorseCodeTreeTest_Student {

    @Test
    public void testGetRoot() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        TreeNode<String> root = morseCodeTree.getRoot();
        assertEquals("", root.getData());
    }

    @Test
    public void testSetRoot() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        TreeNode<String> newNode = new TreeNode<>("test");
        morseCodeTree.setRoot(newNode);
        assertEquals("New root of the MorseCodeTree should be the test node", newNode, morseCodeTree.getRoot());
    }

    @Test
    public void testInsert() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        morseCodeTree.insert("..", "i");
        morseCodeTree.insert(".-", "a");
        ArrayList<String> morseList = new ArrayList<>();
        morseCodeTree.LNRoutputTraversal(morseCodeTree.getRoot(), morseList);
        assertTrue("Morse code tree should contain 'i' and 'a'", morseList.contains("i") && morseList.contains("a"));
    }

    @Test
    public void testFetch() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        String letter = morseCodeTree.fetch(".");
        assertEquals("Fetching Morse code for letter 'e'", "e", letter);
    }

    @Test
    public void testFetchNode() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        assertEquals(morseCodeTree.fetchNode(morseCodeTree.getRoot(), "-.."), "d");
    }

    @Test
    public void testBuildTree() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        ArrayList<String> morseList = morseCodeTree.toArrayList();
        assertFalse("Morse code tree should not be empty after building", morseList.isEmpty());
    }

    @Test
    public void testToArrayList() {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        ArrayList<String> morseList = morseCodeTree.toArrayList();
        assertNotNull("Morse code tree converted to ArrayList should not be null", morseList);
    }
}

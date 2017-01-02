package AxelMonroy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testHashMap() throws Exception {
        Map map = new HashMap();
        map.put("key", 1);
        map.put("Key2", 2);
        assertEquals(1, map.get("key"));
    }

    public void testInsert() throws Exception {
        Map map = new AxelMap<String, Integer>();
        map.put("key", 1);
        map.put("Key2", 2);
        assertEquals(1, map.get("key"));
        assertEquals(2, map.get("Key2"));
    }

    public void testGetNull() throws Exception {
        AxelMap<Integer, String> map = new AxelMap<Integer, String>();
        assertEquals(null, map.get(42));
    }

    public void testOverride() throws Exception {
        AxelMap<Integer, String> map = new AxelMap<Integer, String>();
        map.put(1, "something");
        assertEquals("something", map.get(1));
        map.put(1, "another thing");
        assertEquals("another thing", map.get(1));
    }

    public void testEmpty() throws Exception {
        Map<Integer, String> map = new AxelMap<Integer, String>();
        assertTrue(map.isEmpty());
        map.put(1, "something");
        assertFalse(map.isEmpty());
    }

    public void testContainsKey() throws Exception {
        Map<Integer, String> map = new AxelMap<Integer, String>();
        map.put(1, "something");
        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(2));
        map.put(3, "hello there");


    }

    public void testContainsValue() throws Exception {
        Map<Integer, String> map = new AxelMap<Integer, String>();
        map.put(1, "something");
        map.put(3, "something3");
        assertTrue(map.containsValue("something"));
        assertFalse(map.containsValue("hello there"));
    }

    public void testRemoveByKey() throws Exception {
        Map<Integer, String> map = new AxelMap<Integer, String>();
        map.put(1, "something");
        assertTrue(map.containsKey(1));

        map.remove(1);
        assertFalse(map.containsKey(1));
        assertTrue(map.isEmpty());

        map = new AxelMap<Integer, String>();
        map.put(1, "something");
        map.put(2, "other");
        map.remove(1);
        assertFalse(map.isEmpty());

    }
}

package AxelMonroy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public void testClear() throws Exception {
        Map<Integer, String> map = new AxelMap<Integer, String>();
        map.put(1, "something");
        map.put(2, "other");
        assertEquals(2, map.size());

        assertFalse(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());

    }

    public void testputAll() throws Exception {
        Map map_1 = new HashMap();
        Map<Integer, String> map_2 = new AxelMap<Integer, String>();
        map_2.putAll(map_1);
        map_1.put(1, "value1");
        map_1.put(2, "value2");
        map_2.putAll(map_1);


        assertEquals("value1", map_2.get(1));
        assertEquals("value2", map_2.get(2));
        assertFalse(map_2.isEmpty());
        assertEquals(2, map_2.size());

    }

    public void testkeySet() throws Exception {
        Set<Integer> expectedSetOfKeys = new HashSet<Integer>();
        expectedSetOfKeys.add(1);
        expectedSetOfKeys.add(2);
        expectedSetOfKeys.add(3);

        Map<Integer, String> map = new AxelMap<Integer, String>();
        assertEquals(new HashSet<Integer>(), map.keySet());
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");
        assertEquals(expectedSetOfKeys, map.keySet());

    }

    public void testValues() throws Exception {
        Set<String> expectedSetOfValues = new HashSet<String>();
        expectedSetOfValues.add("value1");
        expectedSetOfValues.add("value2");
        expectedSetOfValues.add("value3");

        Map<Integer, String> map = new AxelMap<Integer, String>();
        assertEquals(new HashSet<Integer>(), map.keySet());
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");
        map.put(3, "value3");

        assertEquals(expectedSetOfValues, map.values());


    }

    public void testEntrySet() throws Exception {
        Map map = new AxelMap<Integer, String>();

        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");

        HashMap auxExpectedHashMap = new HashMap();

        auxExpectedHashMap.put(1, "value1");
        auxExpectedHashMap.put(2, "value2");
        auxExpectedHashMap.put(3, "value3");
        String expectedSet = auxExpectedHashMap.entrySet().toString();
        assertEquals(expectedSet, map.entrySet().toString());

    }

    public void testInsertMultiple() throws Exception {
        Map map = new AxelMap<String, Integer>();

        for (int i = 0; i < 10000; i++) {
            map.put(i, i);
        }
        assertEquals(300,map.get(300));
        assertTrue(map.containsKey(300));
    }
}

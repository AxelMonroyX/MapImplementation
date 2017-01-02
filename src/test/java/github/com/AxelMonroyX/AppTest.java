package github.com.AxelMonroyX;

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
}
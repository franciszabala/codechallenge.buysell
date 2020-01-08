package com.franciszabala.codechallange.buysell;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLevel1()
    {
    	API.prices = new int[] { 7,12,5,3,11,6,10,2,9 };
    	SolutionInterface si = new Solution();
        assertEquals(3, si.getBuyDay());
        assertEquals(4, si.getSellDay());
        //assertEquals(expected, actual);
    }
    
    public void testLevel2()
    {
    	API.prices = new int[] { 7,1,5,9,2,5,4,8,5,6,9 };
    	SolutionInterface si = new Solution();
        assertEquals(1, si.getBuyDay());
        assertEquals(10, si.getSellDay());
        //assertEquals(expected, actual);
    }
    
    public void testLevel3()
    {
    	API.prices = new int[] { 7,3,8,5,10,10,3,8,1,3,9,3,7,12,10,7,8,10,1,7,5,8 };
    	SolutionInterface si = new Solution();
        assertEquals(8, si.getBuyDay());
        assertEquals(13, si.getSellDay());
        //assertEquals(expected, actual);
    }
    
    public void testLevel4()
    {
    	API.prices = new int[] { 10, 3, 7, 9,2,12,6,2,6,7,9,10,12,8,4,10,1,11,8,7,3,6 };
    	SolutionInterface si = new Solution();
        assertEquals(16, si.getBuyDay());
        assertEquals(17, si.getSellDay());
        //assertEquals(expected, actual);
    }
}

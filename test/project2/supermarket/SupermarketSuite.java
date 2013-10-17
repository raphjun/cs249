/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.supermarket;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jason
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({project2.supermarket.CheckerTest.class, project2.supermarket.SupermarketTest.class})
public class SupermarketSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.primitives;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author nickpeck
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({humble.primitives._NumberTest.class, humble.primitives._BooleanTest.class, humble.primitives._ListTest.class, humble.primitives._StringTest.class})
public class PrimitivesTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
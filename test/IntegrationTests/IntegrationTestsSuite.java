/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

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
@Suite.SuiteClasses({IntegrationTests.CurriedApplicationTest.class, IntegrationTests.CompoundExpressionsTest.class, IntegrationTests.StateMonadTest.class, IntegrationTests.FactorialTest.class, IntegrationTests.WriterMonadTest.class, IntegrationTests.BindTest.class, IntegrationTests.ItteratorTest.class})
public class IntegrationTestsSuite {

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
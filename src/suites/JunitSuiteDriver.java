/*
 * 
 * This is a Junit suite class. It will drive a suite of tests using Junit.
 * 
 * */

package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import testCases.*;

@RunWith(Suite.class)
@SuiteClasses({TC001.class})
public class JunitSuiteDriver {

}

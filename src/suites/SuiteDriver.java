package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import testCases.*;

@RunWith(Suite.class)
@SuiteClasses({TC001.class, TC002.class})
public class SuiteDriver {

}

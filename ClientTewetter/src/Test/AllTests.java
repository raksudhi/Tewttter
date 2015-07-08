package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QueryTest.class, QueryTestMessage.class, MoreCharacters.class })
public class AllTests {

}

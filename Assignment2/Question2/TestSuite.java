/*
 * Suite Class for PyramidMirror Class 
 */

package Question2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Question1.PatternBuilderTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	   NumbersTest.class,
	   SpacesTest.class,
	   PyramidTest.class,
	   PatternBuilderTest.class
	})

public class SuiteTest {

}

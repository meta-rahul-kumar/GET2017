/*
 * Suite Class for PyramidMirror Class 
 */

package Question2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Question1.PatternBuilderTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	   TestNumbers.class,
	   TestSpaces.class,
	   TestPyramid.class,
	   PatternBuilderTest.class
	})

public class TestSuite {

}

package testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * This test suite runs all tests on the application. Tests include ensuring correct calculations, 
 * accurate file parsing, correct semester, class, and GPA information, 
 * and incorrect format detection.
 */
@Suite
@SelectClasses({ TestFileFormatting.class, TestParsing.class })
public class RunAllTests {

}

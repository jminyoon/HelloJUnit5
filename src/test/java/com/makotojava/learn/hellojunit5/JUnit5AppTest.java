package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.fail;

import java.beans.Transient;

import javax.management.DescriptorKey;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
 * report.</li>
 * </ol>
 *
 */
@RunWith(JUnitPlatform.class)
@DisplayName("JUnit Testing")

public class JUnit5AppTest {

  // Create a JDK Logger here
  private static final java.util.logging.Logger logger = LoggerFactory.getLogger(JUnit5AppTest.class);
  // Create a fixture for the class under test
  private App testingApp;
  // Do something before ANY test is run in this class
  @BeforeAll
  public static void init() {
    logger.info("@BeforeAll: init()");
  }

  // Do something after ALL tests in this class are run
  @AfterAll
  public static void done() {
    logger.info("@AfterAll: done()");
  }

  // Create an instance of the test class before each @Test method is executed
  @BeforeEach
  public void instance() {
    logger.info("@BeforeEach: instance()");
    testingApp = new App();
  }
  // Destroy reference to the instance of the test class after each @Test method is executed
  @AfterEach
  public void destroy() {
    logger.info("@AfterEach: destroy()");
    testingApp = null;
  }
  // Disabled test
  @Test
  @Disabled
  @DisplayName("Disabled test")
  void testNotRun() {
    logger.info("Disabled test");
  }

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
   * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
   * </ol>
   */
  @Test
  @DisplayName("Add test")
  public void testAdd() {
    //
    // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see the
    // buttery smooth javadoc above.)
    //
    logger.info("@Test: testAdd()");
    assertNotNull(testingApp);
    assertAll(
      () -> {
        long[] numberList = {1,2,3,4};
        long expectedAnswer = 10;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {20,934,110};
        long expectedAnswer = 1064;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {2,4,6};
        long expectedAnswer = 12;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }
    );
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called <code>setUp()</code> that runs before the test
   * method does (hint: use {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Negative addition test")
  class NegativeNumbersTest {
    private App classUnderTest;
    @BeforeEach void setUp() throws Exception {
      classUnderTest = new App();
    }
    @AfterEach void tearDown() throws Exception {
      classUnderTest = null;
    }
    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Adding negative numbers")
    public void testAdd() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(classUnderTest);
      assertAll(
      () -> {
        long[] numberList = {-1,-2,-3,-4};
        long expectedAnswer = -10;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {-20,-934,-110};
        long expectedAnswer = -1064;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {-2,-4,-6};
        long expectedAnswer = -12;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }
    );
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Adding both negative and positive numbers")
  class PositiveAndNegativeNumbersTest {

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Testing add method with both negative and positive numbers")
    public void testAdd() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertAll(
      () -> {
        long[] numberList = {-1,2,-3,4};
        long expectedAnswer = 2;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {-20,934,-110};
        long expectedAnswer = 804;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {-2,-4,6};
        long expectedAnswer = 0;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }
    );
    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Only works on Fridays")
    public void testAdd_OnlyOnFriday() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      LocalDateTime friday = LocalDateTime.now();
      assumeTrue(friday.getDayOfWeek().getValue() == 5);
      long[] numberList = { 1, 2, 3, 4, 5 };
      long expectedAnswer = 15;
      long actualAnswer = testingApp.add(numberList);
      assertEquals(expectedAnswer, actualAnswer);
    }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Same as Only on Friday test but with Lamda")
    public void testAdd_OnlyOnFriday_WithLambda() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      LocalDateTime friday = LocalDateTime.now();
      assumingThat(friday.getDayOfWeek().getValue() == 5,
        () -> {
          long[] numberList = { 1, 2, 3, 4, 5 };
          long expectedAnswer = 15;
          long actualAnswer = testingApp.add(numberList);
          assertEquals(expectedAnswer, actualAnswer);
        });
    }

  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Single add test")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Single numbers")
    public void testAdd_NumbersGt0() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      assertAll(
      () -> {
        long[] numberList = {1};
        long expectedAnswer = 1;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {0};
        long expectedAnswer = 0;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      });
    }

    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Sinlge negative numbers")
    public void testAdd_NumbersLt0() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      assertAll(
      () -> {
        long[] numberList = {-1};
        long expectedAnswer = -1;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      }, 
      () -> {
        long[] numberList = {-10};
        long expectedAnswer = -10;
        long actualAnswer = testingApp.add(numberList);
        assertEquals(expectedAnswer, actualAnswer);
      });
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Testing for no numbers")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
    @Test
    @DisplayName("Empty list")
    public void testAdd_ZeroOperands_EmptyArgument() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      long[] noNumbers = {};
      assertThrows(IllegalArgumentException.class, () -> testingApp.add(noNumbers));
    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands argument cannot be null".</li>
     * </ol>
     */
    @Test
    @DisplayName("Null list")
    public void testAdd_ZeroOperands_NullArgument() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(testingApp);
      long[] noNumbers = null;
      Throwable exceptionMessage = assertThrows(IllegalArgumentException.class, () -> testingApp.add(noNumbers));
      assertEquals("Operands argument cannot be null", exceptionMessage.getLocalizedMessage());
    }

  }

}

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

public class App {
    public void getGreeting() throws InterruptedException, AWTException, IOException {
        TestCases tests = new TestCases(); // Initialize your test class

        // TODO: call your test case functions one after other here

        tests.testCase01();
        // tests.testCase02();
        // tests.testCase03();
        // tests.testCase04();// link countwith name
        // tests.testCase05();
        // tests.testCase06();
        // tests.testCase07();
        // tests.testCase08();/Alert
        // tests.testCase09();
        // tests.testCase10();
        // tests.testCase11();
        // tests.testcase12();
        // tests.testCase13();
        // tests.testCase14();
        // tests.testCase15();
        // END Tests

        tests.endTest(); // End your test by clearning connections and closing
        // browser
    }

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        new App().getGreeting();
    }
}

/**
 * Created by Anton on 21.11.2017.
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {

        Result result=JUnitCore.runClasses(TestSuiteRefresh.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("refresh test passed:"+result.wasSuccessful());

        Result result1=JUnitCore.runClasses(TestSuitePut.class);
        for (Failure failure: result1.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("put test passed:"+result1.wasSuccessful());

    }

}

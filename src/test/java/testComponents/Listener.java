package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends BrowserTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = Report_Extent.getReports();

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        //test = extent.createTest(result.getMethod().getMethodName());
        test= extent.createTest(result.getMethod().getMethodName());
        // extentTest.set(test);//unique thread id(ErrorValidationTest)->test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.log(Status.PASS,"Test Passed");
        // extentTest.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        test.fail(result.getThrowable());
        //  extentTest.get().fail(result.getThrowable());//

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String filePath = null;

        try {
            filePath = Report_Extent.getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//
//
//        //Screenshot, Attach to report

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub


    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();

    }



}

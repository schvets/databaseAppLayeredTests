package tools;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureOnFailListener implements ITestListener {
    @Override
    public void onTestStart(final ITestResult result) { }

    @Override
    public void onTestSuccess(final ITestResult result) { }

    @Override
    public void onTestFailure(final ITestResult result) {
        new WebDriverUtils().takeAllureScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(final ITestResult result) { }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
        new WebDriverUtils().takeAllureScreenshot(result.getName());
    }

    @Override
    public void onStart(final ITestContext context) { }

    @Override
    public void onFinish(final ITestContext context) { }
}

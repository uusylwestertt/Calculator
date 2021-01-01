package testConfig;

import io.qameta.allure.Attachment;
import logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static config.driverManager.DriverManager.webDriver;

public class TestListener extends TestListenerAdapter {


    private List<ITestNGMethod> failedtests = new ArrayList();
    private List<ITestNGMethod> skippedtests = new ArrayList();
    private List<String> faliedTestsMessages = new ArrayList();
    private List<Throwable> skipExceptionsList = new ArrayList();
    private int numberOfTests;

    private String testMetodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }


    @Attachment(value = "Screenshot", type = "image/jpg")
    public byte[] saveScrenshotJPG() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestStart(ITestResult result) {
        numberOfTests++;
        Log.TEST_MESSAGE_CHECK("\n" +
                "  _______________________   ______________    ____  ________________ \n" +
                " /_  __/ ____/ ___/_  __/  / ___/_  __/   |  / __ \\/_  __/ ____/ __ \\\n" +
                "  / / / __/  \\__ \\ / /     \\__ \\ / / / /| | / /_/ / / / / __/ / / / /\n" +
                " / / / /___ ___/ // /     ___/ // / / ___ |/ _, _/ / / / /___/ /_/ / \n" +
                "/_/ /_____//____//_/     /____//_/ /_/  |_/_/ |_| /_/ /_____/_____/ \n");

        Log.TEST_MESSAGE_CHECK("Test name: " + testMetodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScrenshotJPG();
        Log.TEST_MESSAGE_FAIL("\n" +
                "  _______________________   _________    ______    __________ \n" +
                " /_  __/ ____/ ___/_  __/  / ____/   |  /  _/ /   / ____/ __ \\\n" +
                "  / / / __/  \\__ \\ / /    / /_  / /| |  / // /   / __/ / / / /\n" +
                " / / / /___ ___/ // /    / __/ / ___ |_/ // /___/ /___/ /_/ / \n" +
                "/_/ /_____//____//_/    /_/   /_/  |_/___/_____/_____/_____/  \n");

        Log.TEST_MESSAGE_FAIL("Test name: " + testMetodName(result));
        result.getThrowable().printStackTrace();
        failedtests.add(result.getMethod());
        faliedTestsMessages.add(result.getThrowable().getMessage());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        Log.TEST_MESSAGE_SUCESS("\n" +
                "   _______________________   ____  ___   __________ __________ \n" +
                " /_  __/ ____/ ___/_  __/  / __ \\/   | / ___/ ___// ____/ __ \\\n" +
                "  / / / __/  \\__ \\ / /    / /_/ / /| | \\__ \\\\__ \\/ __/ / / / /\n" +
                " / / / /___ ___/ // /    / ____/ ___ |___/ /__/ / /___/ /_/ / \n" +
                "/_/ /_____//____//_/    /_/   /_/  |_/____/____/_____/_____/  \n");

        Log.TEST_MESSAGE_SUCESS("Test name: " + testMetodName(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedtests.add(result.getMethod());
        skipExceptionsList.add(result.getThrowable());
        Log.TEST_MESSAGE_CHECK("\n" +
                "   _______________________   _____ __ __ ________  ____  __________ \n" +
                " /_  __/ ____/ ___/_  __/  / ___// //_//  _/ __ \\/ __ \\/ ____/ __ \\\n" +
                "  / / / __/  \\__ \\ / /     \\__ \\/ ,<   / // /_/ / /_/ / __/ / / / /\n" +
                " / / / /___ ___/ // /     ___/ / /| |_/ // ____/ ____/ /___/ /_/ / \n" +
                "/_/ /_____//____//_/     /____/_/ |_/___/_/   /_/   /_____/_____/  ");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        printReport(testContext);
    }


    private void printReport(ITestContext testContext) {
        int numberOfFalidedTests = testContext.getFailedTests().size();
        int numberOfPassedTests = testContext.getPassedTests().size();
        int numberofSkippedTests = testContext.getSkippedTests().size();

        Log.TEST_MESSAGE_CHECK("\n" +
                "     ____                        __ \n" +
                "   / __ \\___  ____  ____  _____/ /_\n" +
                "  / /_/ / _ \\/ __ \\/ __ \\/ ___/ __/\n" +
                " / _, _/  __/ /_/ / /_/ / /  / /_  \n" +
                "/_/ |_|\\___/ .___/\\____/_/   \\__/  \n" +
                "          /_/                      ");

        Log.TEST_MESSAGE_CHECK("Number of Runned  tests: " + numberOfTests);
        Log.TEST_MESSAGE_CHECK("Number of Passed  tests: " + numberOfPassedTests);
        Log.TEST_MESSAGE_CHECK("Number of Failed  tests: " + numberOfFalidedTests);
        Log.TEST_MESSAGE_CHECK("Number of Skiped  tests: " + numberofSkippedTests);


        if (skippedtests.size() > 0) {
            Log.TEST_MESSAGE_CHECK("Skipped tests:");
            for (int i = 0; i < skippedtests.size(); i++) {
                Log.TEST_MESSAGE_CHECK("Nr: " + (i + 1) + " " + skippedtests.get(i).getMethodName());
                Log.TEST_MESSAGE_CHECK(skipExceptionsList.get(i).getMessage());
            }
        }


        if (failedtests.size() > 0) {
            Log.TEST_MESSAGE_CHECK("Failed tests:");
            for (int i = 0; i < failedtests.size(); i++) {
                Log.TEST_MESSAGE_CHECK("Nr: " + (i + 1) + " " + failedtests.get(i).getMethodName());
                Log.TEST_MESSAGE_FAIL(faliedTestsMessages.get(i));
            }
        }
    }
}

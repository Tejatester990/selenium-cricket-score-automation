package Cricketapptest;


import cricketappbase.BaseTest;
import cricketappbase.CricketScorePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.CSVUtility;

public class CricketScoreTest extends BaseTest{

    CricketScorePage cricketScorePage;




    @BeforeClass
    public void setUp() {
        setUpDriver();
        String pathurl="C:\\Users\\Public\\Downloads\\CricketScoreAutomationSelenium\\Cricketappscoreapplication\\Index.html";
        driver.get(pathurl); // Replace with your actual file path or deployed URL
        cricketScorePage = new CricketScorePage(driver);
    }
    @Test(priority = 1)
    public void validateTableHeaders() {
        test = extentReports.createTest("Validate Table Headers");
        try {
            Assert.assertEquals(cricketScorePage.getHeaderText(0), "Team");
            Assert.assertEquals(cricketScorePage.getHeaderText(1), "Score");
            Assert.assertEquals(cricketScorePage.getHeaderText(2), "Overs");
            test.pass("Table headers validated successfully.");
        } catch (AssertionError e) {
            test.fail("Table header validation failed: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 2)
    public void validateInitialData() {
        test = extentReports.createTest("Validate Initial Data");
        try {
            Assert.assertFalse(cricketScorePage.getTeam1().isEmpty());
            Assert.assertFalse(cricketScorePage.getTeam2().isEmpty());
            Assert.assertTrue(cricketScorePage.getScore1().matches("\\d+/\\d+"));
            Assert.assertTrue(cricketScorePage.getScore2().matches("\\d+/\\d+"));
            test.pass("Initial team names and scores validated.");
        } catch (AssertionError e) {
            test.fail("Initial data validation failed: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 3)
    public void validateDynamicDataAndLogToCSV() {
        test = extentReports.createTest("Validate Dynamic Score Update and CSV Logging");
        try {
            String beforeScore = cricketScorePage.getScore1();
            cricketScorePage.clickRefresh();
            for (int i = 0; i < 10; i++) {
                if (!cricketScorePage.getScore1().equals(beforeScore)) {
                    break;
                }
            }
            String afterScore = cricketScorePage.getScore1();
            Assert.assertNotEquals(beforeScore, afterScore);

            CSVUtility.logScore(
                    cricketScorePage.getTeam1(),
                    cricketScorePage.getScore1(),
                    cricketScorePage.getOvers1(),
                    cricketScorePage.getTeam2(),
                    cricketScorePage.getScore2(),
                    cricketScorePage.getOvers2(),
                    cricketScorePage.getStatus()
            );
            test.pass("Dynamic score updated and logged to CSV successfully.");
        } catch (AssertionError e) {
            test.fail("Dynamic data update validation failed: " + e.getMessage());
            throw e;
        }
    }
    @AfterClass
    public void tearDown() {
        tearDownDriver();
    }

}
package cricketappbase;

import cricketappbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CricketScorePage extends BasePage {

    private By tableHeaders = By.xpath("//table[@id='scoreTable']//th");
    private By team1 = By.id("team1");
    private By score1 = By.id("score1");
    private By overs1 = By.id("overs1");
    private By team2 = By.id("team2");
    private By score2 = By.id("score2");
    private By overs2 = By.id("overs2");
    private By status = By.id("status");
    private By refreshButton = By.xpath("//button[text()='Refresh Score']");

    public CricketScorePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText(int index) {
        return driver.findElements(tableHeaders).get(index).getText();
    }

    public String getTeam1() {
        return getText(team1);
    }

    public String getScore1() {
        return getText(score1);
    }

    public String getOvers1() {
        return getText(overs1);
    }

    public String getTeam2() {
        return getText(team2);
    }

    public String getScore2() {
        return getText(score2);
    }

    public String getOvers2() {
        return getText(overs2);
    }

    public String getStatus() {
        return getText(status);
    }

    public void clickRefresh() {
        click(refreshButton);
    }
}
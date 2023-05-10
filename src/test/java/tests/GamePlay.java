package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

public class GamePlay extends BaseTest{

    @BeforeMethod
    @Parameters({"browser","env","wait"})
    public void setup(String browser, String env, String wait) throws Exception {
        init(browser,wait);
        openApp(env);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Test(enabled = false)
    public void newGame() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.startNewGame();
        mainPage.checkNewTileCount("2");
        mainPage.startNewGame();
        mainPage.checkNewTileCount("2");
    }

    @Test(enabled = false)
    public void playGame() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.play(10);
    }

    @Test(enabled = false)
    public void fullGame() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.playUntilGameOver();
    }

    @Test(enabled = true)
    public void fullGameWin() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.playUntilGameOver("64");
    }

}

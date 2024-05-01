import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class TrianglePuzzleTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void settingUp() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void testTrianglePuzzle() {
        webDriver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement giveUpButton = webDriver.findElement(By.xpath("//button[text()='Я сдаюсь']"));
        Assert.assertTrue(giveUpButton.isDisplayed(), "Кнопка 'Я сдаюсь' не найдена");
        giveUpButton.click();


        WebElement answersLink = webDriver.findElement(By.linkText("Ссылка на ответы"));
        Assert.assertTrue(answersLink.isDisplayed(), "Ссылка на ответы не найдена");


        WebElement hideAnswersButton = webDriver.findElement(By.xpath("//button[text()='Спрятать ответы']"));
        Assert.assertTrue(hideAnswersButton.isDisplayed(), "Кнопка 'Спрятать ответы' не найдена");

        if (hideAnswersButton.isDisplayed()  &&  answersLink.isDisplayed()) {System.out.println("Успешно выполнено");}
    }

    @AfterMethod
    public void shutDown() {
        if (webDriver != null) webDriver.quit();}
    }
}

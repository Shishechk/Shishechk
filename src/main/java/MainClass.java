import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\TestJob\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".services-new__list-item:nth-child(1) .services-new__icon")).click();
        Thread.sleep(5000);
        for (String tad : driver.getWindowHandles()) {
            driver.switchTo().window(tad);
        }
        driver.findElement(By.xpath("//span[contains(.,\'Электроника\')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[contains(text(),\'Смартфоны\')])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("glpriceto")).sendKeys("20000");
        driver.findElement(By.id("14805766from")).sendKeys("3");
        driver.findElement(By.xpath("//span[contains(.,\'Apple\')]")).click();
        driver.findElement(By.xpath("//span[contains(.,\'HONOR\')]")).click();
        driver.findElement(By.xpath("//span[contains(.,\'HUAWEI\')]")).click();
        driver.findElement(By.xpath("//span[contains(.,\'Samsung\')]")).click();
        driver.findElement(By.xpath("//span[contains(.,\'Xiaomi\')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(.,\'Показывать по 48\')]")).click();
        driver.findElement(By.xpath("//button[contains(.,\'Показывать по 12\')]")).click();
        Thread.sleep(5000);
        WebElement pos1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[5]/div/div[2]/div/div[1]/div/div/div/div/article[1]/div[4]/div[1]/h3/a"));
        String nametelefon = pos1.getAttribute("href");
        System.out.println(nametelefon);
        System.out.println(pos1.getAttribute("title"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[5]/div/div[1]/div/div[1]/button[6]")).click();
        Thread.sleep(5000);

        for (int i=1; i< 5; i++)
        {
            driver.findElement(By.xpath("//a[contains(.,\'Вперёд\')]")).click();
            Thread.sleep(10000);
        }
        /*Boolean ss = Boolean.parseBoolean(nametelefon);
        while (ss == false) {

            if (ss == true) {
                //driver.quit();
                System.out.println("Radotaet");
            } else {
                driver.findElement(By.xpath("//a[contains(.,\'Вперёд\')]")).click();
                Thread.sleep(10000);

            }
        }*/
        driver.get(nametelefon);
        Thread.sleep(5000);
        WebElement rating = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[4]/div/div[1]/div/div/div[3]/div[1]/div[1]/span"));
        System.out.println("Оценка телефона: " + rating.getText());
        driver.quit();
    }
}

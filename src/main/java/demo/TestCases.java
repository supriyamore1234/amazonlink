package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com/");
        // // search for enter tab Using Locator "Name" q));
        WebElement search = driver.findElement(By.name("q"));
        // // // enter name amazon in this tab
        search.sendKeys("amazon");
        // // click enter key
        search.sendKeys(Keys.ENTER);
        // Thread.sleep(5000);
        // // check availability of link amazon.in Using Locator "XPath"
        WebElement link = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));

        boolean status = link.isDisplayed();
        System.out.println("Print status " + status);
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() {

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find all hyper links present on webpage Using Locator "Tag Name" a
        List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));
        // find total count of links
        int countOfHyperlinks = hyperlinks.size();
        System.out.println("Count of hyperlinks on bookmyshow are : " + countOfHyperlinks);
    }

    public void testCase03() throws InterruptedException {
        driver.get("https://www.linkedin.com/feed/");
        // click on sign in Using Locator "XPath" //a[contains(@Class,'nav__button-s')]

        WebElement signin = driver
                .findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        // Enter email
        WebElement email = driver.findElement(By.xpath("//input[@id='username' and @name='session_key']"));
        email.sendKeys("moresupriyasunil@gmail.com");

        // Enter pass word using xpath //input[@id='password' and @type='password']
        WebElement password = driver.findElement(By.xpath("//input[@id='password' and @type='password']"));
        password.sendKeys("heemalaya12");
        // click on sign in button[type="submit"] and click on it
        WebElement sign = driver.findElement(By.cssSelector("button[type='submit']"));
        sign.click();

        // Enter password //input[@id='password']

        // click on Sign in button Using Locator Class =login__form_action_container
        // add implicitly wait to load page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // click on view profile Using Locator "XPath" //div[@id='ember13']///css
        // button[aria-expanded='false']>img
        driver.navigate().to("https://www.linkedin.com/in/supriya-more-0a4a99257/");

        // click on profile views Using Locator "CSS Selector"
        // a[data-field="insights_wvmp"][class*="optio"]>div>span>span
        WebElement profileview = driver
                .findElement(By.cssSelector(" a[data-field='insights_wvmp'][class*='optio']>div>span>span"));
        // get text of above element
        System.out.println("Print count Of Profile Views : " + profileview.getText());
        // come to home page
        driver.navigate().back();
        Thread.sleep(5000);
        // click on post tab
        WebElement testpost = driver
                .findElement(By.xpath("//span[text()='Start a post']"));
        testpost.click();
        Thread.sleep(5000);
        // send test to post
        WebElement textsend = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        textsend.sendKeys("Automation Testing");
        // click on post
        WebElement ToPost = driver
                .findElement(By.xpath("//span[text()='Post']"));
        ToPost.click();
        Thread.sleep(4000);
        WebElement message = driver
                .findElement(By.cssSelector("p[class*='artdeco-toast-item__message'][role='alert']"));
        boolean status = message.isDisplayed();
        if (status == true) {
            System.out.println("Post is posted successfully");
        } else {
            System.out.println("Not posted successfully");
        }

    }

    public void testCase04() throws InterruptedException {
        // navigate google url
        driver.get("https://www.google.com/");
        // go to search tab Using Locator "Name" q
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.name("q"));
        // enter name supriya
        search.sendKeys("supriya");
        // press ENTER key from keyboard supriya
        search.sendKeys(Keys.ENTER);
        // Wait for the search results to load. Thread.sleep(3000)
        Thread.sleep(5000);
        // find all search result links Using Locator "Tag Name" h3
        List<WebElement> resultLinks = driver.findElements(By.tagName("h3"));

        // Iterate through each search result link:
        List<String> ar = new ArrayList<String>();
        for (WebElement iterable_element : resultLinks) {
            String ar_ = iterable_element.getText().toString();
            ar.add(ar_);
        }
        // Check if the link contains your name.
        int count = 0;
        // If it does, increment the count variable.
        for (String ar1 : ar) {
            if (ar1.contains("supriya")) {
                count++;
            }

        }
        // Print the count of links with your name.
        System.out.println("Lint count containing name SUPRIYA is " + count);

        // Close the web browser.
        driver.close();
    }

    // book my show
    public void testCase05() throws InterruptedException {

        // go to book my show
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find list web element for recommended movie limks Using Locator "XPath"
        // div[@class='sc-lnhrs7-2 eQezya']/div/a

        Thread.sleep(5000);
        List<WebElement> recommendedMovieList = driver
                .findElements(By.xpath("//div[contains(@class,'sc-lnhrs7-2 eQezya')]//img"));
        Thread.sleep(4000);

        System.out.println("List Size is :" + recommendedMovieList.size());
        List<String> ss = new ArrayList<>();
        // use for each loop for web elements above list
        for (WebElement iterable_element : recommendedMovieList) {
            String aa = iterable_element.getAttribute("src").toString();
            ss.add(aa);

        }
        for (int i = 0; i < ss.size(); i++) {
            System.out.println("Print urls" + ss.get(i));
        }
        Thread.sleep(3000);
        // Print Name & Language of the 2nd item in the “Premiere” list
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        // js.executeSc.ript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> premiersmovielist = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 fyTNyu')]"));
        Thread.sleep(5000);
        String Secondpremiermovie = premiersmovielist.get(1).getText();
        System.out.println("Name of Second Premium Movie is :" + Secondpremiermovie);

        List<WebElement> language = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 eeVqLW')]"));
        String lanuageMovie = language.get(1).getText();
        System.out.println("Language for econd premier movie is :" + lanuageMovie);
    }

    public void testCase06() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftframe = driver.findElement(By.xpath("//body"));
        System.out.println("Print left frame : " + leftframe.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleframe = driver.findElement(By.tagName("body"));
        System.out.println("Print middle frame name : " + middleframe.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightframe = driver.findElement(By.tagName("body"));
        System.out.println("Print Right frame : " + rightframe);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomframe = driver.findElement(By.tagName("body"));
        System.out.println("Print botto frame : " + bottomframe.getText());
    }

    // pst image on linkdin
    public void testCase07() throws InterruptedException, AWTException {
        driver.get("https://www.linkedin.com/feed/");
        // click on sign in Using Locator "XPath" //a[contains(@Class,'nav__button-s')]

        WebElement signin = driver
                .findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        // Enter email
        WebElement email = driver.findElement(By.xpath("//input[@id='username' and @name='session_key']"));
        email.sendKeys("moresupriyasunil@gmail.com");

        // Enter pass word using xpath //input[@id='password' and @type='password']
        WebElement password = driver.findElement(By.xpath("//input[@id='password' and @type='password']"));
        password.sendKeys("heemalaya12");
        // click on sign in button[type="submit"] and click on it
        WebElement sign = driver.findElement(By.cssSelector("button[type='submit']"));
        sign.click();

        // Enter password //input[@id='password']

        // click on Sign in button Using Locator Class =login__form_action_container
        // add implicitly wait to load page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // click on view profile Using Locator "XPath" //div[@id='ember13']///css
        // button[aria-expanded='false']>img
        // driver.navigate().to("https://www.linkedin.com/in/supriya-more-0a4a99257/");

        // click on profile views Using Locator "CSS Selector"
        // a[data-field="insights_wvmp"][class*="optio"]>div>span>span
        // WebElement profileview = driver
        // .findElement(By.cssSelector("
        // a[data-field='insights_wvmp'][class*='optio']>div>span>span"));
        // get text of above element
        // System.out.println("Print count Of Profile Views : " +
        // profileview.getText());
        // // come to home page
        // driver.navigate().back();
        Thread.sleep(5000);
        // click on post tab
        WebElement testpost = driver
                .findElement(By.xpath("//span[text()='Start a post']"));
        testpost.click();
        Thread.sleep(5000);
        WebElement imagepath = driver.findElement(By.xpath("//button//following::span[text()='Add a photo'][1]"));
        Actions act = new Actions(driver);
        act.moveToElement(imagepath).click().perform();
        // imagepath.click();
        Thread.sleep(4000);

        StringSelection s = new StringSelection("C:\\Users\\EXPERT\\Desktop\\download.png");
        Thread.sleep(5000);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot(); // Robot class throws AWT Exception
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        WebElement ToDone = driver
                .findElement(By.xpath("//span[text()='Done']"));
        act.moveToElement(ToDone).click().perform();
        Thread.sleep(5000);
        WebElement ToPost = driver
                .findElement(By.xpath("//span[text()='Post']"));
        act.moveToElement(ToPost).click().perform();
        WebElement message = driver
                .findElement(By.cssSelector("p[class*='artdeco-toast-item__message'][role='alert']"));
        boolean status = message.isDisplayed();
        if (status == true) {
            System.out.println("Post is posted successfully");
        } else {
            System.out.println("Not posted successfully");
        }

    }

    public void testCase08() {
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
        /*
         * Hey, you can use the above URL only steps you would need to add it click on
         * the add to remarks button then perform the same operation
         * now
         * And then the activity will be same
         */
        WebElement clickbutton = driver.findElement(By.xpath("//div[@class='Alert_section3']//button"));
        System.out.println(clickbutton.isDisplayed());
        Actions act = new Actions(driver);
        act.moveToElement(clickbutton).click().perform();

        driver.switchTo().alert().sendKeys("supriya");
        String s = driver.switchTo().alert().getText();
        System.out.println("Print Text In Alert : " + s);

    }

    public void testCase09() {

        // go to url
        driver.get("https://www.imdb.com/chart/top");
        // select rating
        WebElement sortby = driver.findElement(By.xpath("//select[@class='lister-sort-by']"));
        Select select = new Select(sortby);
        select.selectByVisibleText("IMDb Rating");
        // find list of all movies rating Using Locator "XPath"
        // //td[@class='ratingColumn imdbRating']/strong
        List<WebElement> allmovies = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        // store in list
        List<String> movieslist = new ArrayList<String>();
        for (WebElement allmovies_ : allmovies) {
            String s = allmovies_.getText();
            movieslist.add(s);
        }

        // get first object from list using loop
        // get title of this first object for highest rating movie
        // The Shawshank Redemption//
        String highestratingmovie = movieslist.get(0);
        System.out.println("Highest Rated Movie Is : " + highestratingmovie);
        if (highestratingmovie.contains("The Shawshank Redemption")) {
            System.out.println("FIRST CONDITION IS PASSED FOR HIGHEST RATING MOVIE");

        } else {
            System.out.println("FIRST CONDITION FAIL");
        }
        // count total number of movies Using Locator "XPath" //h1[@class='header']
        WebElement totalMovieCount = driver.findElement(By.xpath("//h1[@class='header']"));
        // get text of this web element
        String CountOfAllMovie = totalMovieCount.getText();
        System.out.println("Total Movie Count Displayed Is " + CountOfAllMovie);
        // get oldest movie
        // select sort by dropdown

        select.selectByVisibleText("Release Date");
        // slect release date
        // find List webElement get title Using Locator "XPath"
        // //td[@class='titleColumn']/a
        // store in list of array
        List<WebElement> allmovies2 = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        List<String> ReleaseDate = new ArrayList<>();
        for (int i = allmovies2.size() - 1; i >= 0; i--) {
            String ss = allmovies2.get(i).getText().toString();
            ReleaseDate.add(ss);

        }
        // reverse array
        // oldest movie
        // The Kid//
        String OldesMovie = ReleaseDate.get(0);

        // get first index
        System.out.println("Oldest Movie Released Is : " + OldesMovie);
        if (OldesMovie.contains("The Kid")) {
            System.out.println("SECOND CONDITION IS PASSED FOR OLDEST MOVIE");

        } else {
            System.out.println("SECOND CONDITION FAIL");
        }
        // to get recent move
        // Guardians of the Galaxy Vol. 3//
        // get title of last index from array list
        String RecentMovie = ReleaseDate.get(allmovies2.size() - 1);
        System.out.println("Recently Released movie Is : " + RecentMovie);
        if (RecentMovie.contains("Guardians of the Galaxy Vol. 3")) {
            System.out.println("THIRD CONDITION IS PASSED LATEST RELEASE MOVIE");

        } else {
            System.out.println("THIRD CONDITION FAIL");
        }
        // Which movie has the most user ratings?
        // select sort by dropdown
        // select RATING
        select.selectByVisibleText("Ranking");
        List<WebElement> allmovies3 = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        // find webelement list Using Locator "XPath" //td[@class='titleColumn']/a
        List<String> userRating = new ArrayList<>();
        for (WebElement userrating : allmovies3) {
            String sss = userrating.getText();
            userRating.add(sss);

        }
        // store in list
        // select first one get title
        // The Shawshank Redemption//
        String mostUSerRating = userRating.get(0);
        System.out.println("Most User Rating : " + mostUSerRating);
        if (mostUSerRating.contains("The Shawshank Redemption")) {
            System.out.println("FOURTH CONDITION IS PASSED MOST USER RATING  MOVIE");

        } else {
            System.out.println("FOURTH CONDITION FAIL");
        }
    }

    public void testCase10() throws InterruptedException, IOException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // switch to frame by name of frame "iframeResult"
        driver.switchTo().frame("iframeResult");
        // click on try it by xpath "//button[text()='Try it']"
        WebElement tryitbutton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryitbutton.click();
        String Parent_id = driver.getWindowHandle();
        Set<String> Child_id = driver.getWindowHandles();

        // Now iterate using Iterator
        for (String a : Child_id) {
            // it will print IDs of both window
            System.out.println(a);

            // condition to change the focus of selenium
            if (Parent_id.equals(a)) {
            } else { // to change focus on new window
                driver.switchTo().window(a);
                Thread.sleep(2000);
                String currenturl = driver.getCurrentUrl();
                System.out.println("CURRENT URL OF PAGE IS : " + currenturl);
                String getText = driver.getTitle();
                System.out.println("Title Of Page is : " + getText);

            }
        }
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "\\src\\main\\Screenshots1.jpg");
        FileUtils.copyFile(src, dest);
    }

    public void testCase11() throws InterruptedException {
        // navigate google url
        driver.get("https://www.google.com/");
        // go to search tab Using Locator "Name" q
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.name("q"));
        // enter name supriya
        search.sendKeys("amazon");
        // press ENTER key from keyboard supriya
        search.sendKeys(Keys.ENTER);

        // find webElement for links by "//a/h3"
        List<WebElement> amazonin = driver.findElements(By.xpath("//a/h3"));
        // create arraylist
        List<String> linksOnPage = new ArrayList<>();
        for (WebElement links : amazonin) {
            String linkname = links.getText();
            linksOnPage.add(linkname);

        }

        // iterate trough arralist and check amazon.in present or not
        // iterate trough arralist and check amazon.com present or not
        for (String iterable_element : linksOnPage) {
            if (iterable_element.contains("Amazon.in")) {
                System.out.println("Amazon.in Link is Present on web page ");
            }
            if (iterable_element.contains("Amazon.com")) {
                System.out.println("Amazon.com Link is present on webpage");
            }
        }

    }

    // book my show link size
    public void testcase12() {
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> hyperlink = driver.findElements(By.xpath("//a"));
        int size = hyperlink.size();
        System.out.println("Count For hyper links on bookmyshow is : " + size);

    }

    // linked in imression on post and views
    public void testCase13() throws InterruptedException {
        driver.get("https://www.linkedin.com/feed/");
        // click on sign in Using Locator "XPath" //a[contains(@Class,'nav__button-s')]

        WebElement signin = driver
                .findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        // Enter email
        WebElement email = driver.findElement(By.xpath("//input[@id='username' and @name='session_key']"));
        email.sendKeys("moresupriyasunil@gmail.com");

        // Enter pass word using xpath //input[@id='password' and @type='password']
        WebElement password = driver.findElement(By.xpath("//input[@id='password' and @type='password']"));
        password.sendKeys("heemalaya12");
        // click on sign in button[type="submit"] and click on it
        WebElement sign = driver.findElement(By.cssSelector("button[type='submit']"));
        sign.click();

        // Enter password //input[@id='password']

        // click on Sign in button Using Locator Class =login__form_action_container
        // add implicitly wait to load page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // click on view profile Using Locator "XPath" //div[@id='ember13']///css
        // button[aria-expanded='false']>img
        driver.navigate().to("https://www.linkedin.com/in/supriya-more-0a4a99257/");

        // click on profile views Using Locator "CSS Selector"
        // a[data-field="insights_wvmp"][class*="optio"]>div>span>span
        WebElement profileview = driver
                .findElement(By.cssSelector(" a[data-field='insights_wvmp'][class*='optio']>div>span>span"));
        // get text of above element
        System.out.println("Print count Of Profile Views : " + profileview.getText());
        // post impression count
        WebElement postimpressioncount = driver.findElement(By.xpath(
                "//li[@class=' pvs-list__item--three-column'][2]//a//span[@class='mr1 hoverable-link-text t-bold']/span[1]"));
        String postimpression = postimpressioncount.getText();
        System.out.println("POST IMPRESSION COUNT  IS : " + postimpression);

    }

    // google user name containing links
    public void testCase14() {
        driver.get("https://www.google.com/");
        WebElement googlesearch = driver.findElement(By.xpath("//input[@name='q']"));
        googlesearch.sendKeys("supriya");
        int count = 0;
        List<WebElement> Links = driver.findElements(By.xpath("//div[@class='MjjYud']//div[@class='yuRUbf']/a"));
        List<String> linksnames = new ArrayList<>();
        for (WebElement string1 : Links) {
            String string111 = string1.getText();
            linksnames.add(string111);
        }
        for (int i = 0; i < linksnames.size(); i++) {

            if (linksnames.get(i).contains("supriya")) {
                count++;

            }
        }
        System.out.println("COUNT OF LINKS CONTAINING NAME ARE : " + count);
    }

    // bookmy show
    public void testCase15() throws InterruptedException {

        // go to book my show
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find list web element for recommended movie limks Using Locator "XPath"
        // div[@class='sc-lnhrs7-2 eQezya']/div/a

        Thread.sleep(5000);
        List<WebElement> recommendedMovieList = driver
                .findElements(By.xpath("//div[contains(@class,'sc-lnhrs7-2 eQezya')]//img"));
        Thread.sleep(4000);

        System.out.println("List Size is :" + recommendedMovieList.size());
        List<String> ss = new ArrayList<>();
        // use for each loop for web elements above list
        for (WebElement iterable_element : recommendedMovieList) {
            String aa = iterable_element.getAttribute("src").toString();
            ss.add(aa);

        }
        for (int i = 0; i < ss.size(); i++) {
            System.out.println("Print urls" + ss.get(i));
        }
        Thread.sleep(3000);
        // Print Name & Language of the 2nd item in the “Premiere” list
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        // js.executeSc.ript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> premiersmovielist = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 fyTNyu')]"));
        Thread.sleep(5000);
        String Secondpremiermovie = premiersmovielist.get(1).getText();
        System.out.println("Name of Second Premium Movie is :" + Secondpremiermovie);

        List<WebElement> language = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 eeVqLW')]"));
        String lanuageMovie = language.get(1).getText();
        System.out.println("Language for econd premier movie is :" + lanuageMovie);
    }
}

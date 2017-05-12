import Pages.MainPage.MainPage;
import Pages.PageUrls;
import Pages.UserTablePage.UserTablePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import specification.Specification;
import tools.WebDriverUtils;

/**
 * Created by 485 on 12.05.2017.
 */
public class ClearUserTableTestCase {
    private Specification specification;

    @BeforeMethod
    public void setUp() {
        new WebDriverUtils().load(new PageUrls().BASE_URL);
        specification = new Specification();
    }

    @AfterMethod
    public void tearDown() {
        new WebDriverUtils().stop();
    }

    @Test
    public void ClearUserTableWOConnectionEmptyUserTable() {
        MainPage mainPage = new MainPage();
        if (mainPage.connectChecker()){
            mainPage.clickConnectButtonOnline();
        }
        double startTableSize = new UserTablePage().getUserList().size();
        mainPage.clickClearButton();
        specification
                .forThe((double) new UserTablePage().getUserList().size())
                .valueMatch
                        (startTableSize)
                .next()
                .check();
    }




}

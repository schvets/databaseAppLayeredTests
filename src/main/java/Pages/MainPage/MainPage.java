package Pages.MainPage;

import Pages.AlertPage.AlertPage;
import Pages.MainPage.uimaps.MainPageUIMap;
import Pages.PromptPage.PromptPage;
import org.openqa.selenium.NoSuchElementException;
import tools.controls.contracts.TextInput;

import java.util.Random;

/**
 * Created by Aleksandr on 12.05.2017.
 */
public class MainPage {
    private MainPageUIMap mainMenuUIMap;

    public MainPage() {
        mainMenuUIMap = new MainPageUIMap();
    }

    public boolean connectChecker() {
        return mainMenuUIMap.getSaveButton().isEnabled();
    }

    public MainPage clickConnectButtonOnline() {
        mainMenuUIMap.getConnectButton().click();
        return new MainPage();
    }

    public PromptPage clickConnectButtonOffline() {
        mainMenuUIMap.getConnectButton().click();
        return new PromptPage();
    }

    public MainPage typeFirstName(String firstName) {
        TextInput firstNameField = mainMenuUIMap.getFirstNameTextInput();
        firstNameField.clear();
        firstNameField.type(firstName);
        return this;
    }

    public MainPage typeLastName(String lastName) {
        TextInput lastNameField = mainMenuUIMap.getLastNameTextInput();
        lastNameField.clear();
        lastNameField.type(lastName);
        return this;
    }

    public MainPage selectRabioButton(String sex) {
        switch (sex) {
            case "Female":
                mainMenuUIMap.getFemaleRadioButton().check();
                break;
            case "Male":
                mainMenuUIMap.getMaleRadioButton().check();
                break;
            default:
                throw new NoSuchElementException(sex);
        }
        return this;
    }

    public MainPage selectCategory(String category) {
        mainMenuUIMap.getCategoryDropDown().contains(category);
        return this;
    }

    public MainPage clickAddButton() {
        mainMenuUIMap.getAddButton().click();
        return new MainPage();
    }

    public MainPage clickDeleteButton() {
        mainMenuUIMap.getDeleteButton().click();
        return new MainPage();
    }

    public MainPage clickLoadButton() {
        mainMenuUIMap.getLoadButton().click();
        return new MainPage();
    }

    public AlertPage clickSaveButtonConnected() {
        mainMenuUIMap.getSaveButton().click();
        return new AlertPage();
    }

    public MainPage clickSaveButtonDisconnected() {
        if (!connectChecker()){
            clickConnectButtonOnline();
        }
        AlertPage alertPage = new AlertPage();
        alertPage.getOkButton().click();
        mainMenuUIMap.getSaveButton().click();
        return new MainPage();
    }

    public void clickSaveButton() {
        mainMenuUIMap.getSaveButton().click();
    }

    public MainPage clickClearButton() {
        mainMenuUIMap.getClearButton().click();
        return new MainPage();
    }

    public String getRandomCategory() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(mainMenuUIMap.getCategoryDropDown().size());
        return mainMenuUIMap.getCategoryDropDown().get(randomInt).getOptions().toString();
    }

    public String getRandomSex() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(mainMenuUIMap.getCategoryDropDown().size());
        return mainMenuUIMap.getGenderList().get(randomInt).getText();
    }

    public String getConnectLabelText() {
        return mainMenuUIMap.getConnectionLabel().getText();
    }

    public String getCountLabelText() {
        return mainMenuUIMap.getCountLabel().getText();
    }
}

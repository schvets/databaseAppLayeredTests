package testdata.user;

import Pages.MainPage.MainPage;
import org.apache.commons.lang3.RandomStringUtils;


public class UserTestData {

    public User getValidUser() {
        return new User().newBuilder()
                .setFirstName(RandomStringUtils.random(5, true, false))
                .setLastName(RandomStringUtils.random(5, true, false))
                .setCategory(new MainPage().getRandomCategory())
                .setSex(new MainPage().getRandomCategory())
                .build();
    }

    public User getInvaldUserNumbers() {
        return new User().newBuilder()
                .setFirstName(RandomStringUtils.random(5, true, true))
                .setLastName(RandomStringUtils.random(5, true, true))
                .setCategory(new MainPage().getRandomCategory())
                .setSex(new MainPage().getRandomCategory())
                .build();
    }

    public User getInvaldUserLongName() {
        return new User().newBuilder()
                .setFirstName(RandomStringUtils.random(50, true, true))
                .setLastName(RandomStringUtils.random(50, true, true))
                .setCategory(new MainPage().getRandomCategory())
                .setSex(new MainPage().getRandomCategory())
                .build();
    }

    public User getInvaldUserAscii(){
        return new User().newBuilder()
                .setFirstName(RandomStringUtils.randomAscii( 10))
                .setLastName(RandomStringUtils.randomAscii(10))
                .setCategory(new MainPage().getRandomCategory())
                .setSex(new MainPage().getRandomCategory())
                .build();
    }

    public User getInvaldBlanc(){
        return new User().newBuilder()
                .setFirstName("")
                .setLastName("")
                .setCategory(new MainPage().getRandomCategory())
                .setSex(new MainPage().getRandomCategory())
                .build();
    }


}
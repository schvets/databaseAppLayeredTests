package testdata.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class represents Team entity as a test data set.
 * Based on Builder pattern.
 *
 * @author Danil Zhyliaiev
 */
public class User {
    private String firstName;
    private String lastName;
    private String category;
    private String sex;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCategory() {
        return category;
    }

    public String getSex() {
        return sex;
    }

    public UserBuilder newBuilder() {
        return this.new UserBuilder();
    }

    public UserBuilder newBuilder(User user){
        return this.new UserBuilder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCategory(user.getCategory())
                .setSex(user.getSex());
    }

    @Override
    public String toString() {
        StringBuilder team = new StringBuilder("User{");

        if ((firstName != null) && (firstName.length() > 0)) {
            team.append("firstName='").append(firstName).append("'");
        }

        if ((lastName != null) && (lastName.length() > 0)) {
            team.append("lastName='").append(lastName).append("'");
        }

        if ((category != null) && (category.length() > 0)) {
            team.append("category='").append(category).append("'");
        }

        if ((sex != null) && (sex.length() > 0)) {
            team.append("sex='").append(sex).append("...'");
        }

        return team.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(category, user.category) &&
                Objects.equals(sex, user.sex)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName,category, sex);
    }

    public class UserBuilder {
        private UserBuilder() { }

        public UserBuilder setFirstName(String firstNameArg) {
            firstName = firstNameArg;
            return this;
        }

        public UserBuilder setLastName(String lastNameArg) {
            lastName = lastNameArg;
            return this;
        }

        public UserBuilder setCategory(String categoryArg) {
            category = categoryArg;
            return this;
        }

        public UserBuilder setSex(String sexArg) {
            sex = sexArg;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}

package testdata.user;

import java.util.Objects;


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
        StringBuilder user = new StringBuilder("User{");

        if ((firstName != null) && (firstName.length() > 0)) {
            user.append("firstName='").append(firstName).append("'");
        }

        if ((lastName != null) && (lastName.length() > 0)) {
            user.append("lastName='").append(lastName).append("'");
        }

        if ((category != null) && (category.length() > 0)) {
            user.append("category='").append(category).append("'");
        }

        if ((sex != null) && (sex.length() > 0)) {
            user.append("sex='").append(sex).append("...'");
        }

        return user.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(category, user.category) &&
                Objects.equals(sex, user.sex);
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

package dal.models;

import java.util.Objects;

/**
 * Created by Aleksandr on 11.05.2017.
 */
public final class UserDal {
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


    private UserDal(UserDal.UserDalBuilder userDalBuilder) {
        firstName = userDalBuilder.firstName;
        lastName = userDalBuilder.lastName;
        category = userDalBuilder.category;
        sex = userDalBuilder.sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDal userDal = (UserDal) o;
        return Objects.equals(firstName, userDal.firstName)
                && Objects.equals(lastName, userDal.lastName) &&
                Objects.equals(category, userDal.category)
                && Objects.equals(sex, userDal.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, category, sex);
    }


    public static class UserDalBuilder {
        private String firstName;
        private String lastName;
        private String category;
        private String sex;

        public UserDalBuilder setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDalBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDalBuilder setCategory(final String category) {
            this.category = category;
            return this;
        }

        public UserDalBuilder setSex(final String cellPhone) {
            this.sex = sex;
            return this;
        }

        public UserDal build() {
            return new UserDal(this);
        }

    }
}

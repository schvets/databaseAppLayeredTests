package testdata.user.mappers;

import dal.models.UserDal;
import testdata.Mapper;
import testdata.user.User;

public class UserToDal implements Mapper<UserDal, User> {
    
    @Override
    public UserDal map(final User source) {
        UserDal.UserDalBuilder builder = UserDal.newBuilder();

        if ((source.getFirstName() != null) && (source.getFirstName().length() > 0)) {
            builder.getFirstName(String.parseInt(source.getFirstName()));
        } else {
            builder.getFirstName(null);
        }

        if ((source.getName() != null) && (source.getName().length() > 0)) {
           builder.setName(source.getName());
        } else {
            builder.setName(null);
        }

        if ((source.getCoach() != null) && (source.getCoach().length() > 0)) {
            builder.setCoach(source.getCoach());
        } else {
            builder.setCoach(null);
        }

        if ((source.getAchievements() != null) && (source.getAchievements().length() > 0)) {
            builder.setAchievements(source.getAchievements());
        } else {
            builder.setAchievements(null);
        }

        if ((source.getCaptain().getId() != null) && (source.getCaptain().getId().length() > 0)) {
            builder.setCaptainId(Integer.parseInt(source.getCaptain().getId()));
        } else {
            builder.setCaptainId(null);
        }

        return builder.build();
    }
}

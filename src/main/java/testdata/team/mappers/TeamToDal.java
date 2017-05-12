package testdata.team.mappers;

import com.softserveinc.volleymanagementtests.dal.models.TeamDal;
import com.softserveinc.volleymanagementtests.testdata.Mapper;
import com.softserveinc.volleymanagementtests.testdata.team.Team;

public class TeamToDal implements Mapper<TeamDal, Team> {



    @Override
    public TeamDal map(final Team source) {
        TeamDal.TeamDalBuilder builder = TeamDal.newBuilder();

        if ((source.getId() != null) && (source.getId().length() > 0)) {
            builder.setId(Integer.parseInt(source.getId()));
        } else {
            builder.setId(null);
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

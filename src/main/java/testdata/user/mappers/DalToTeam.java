package testdata.user.mappers;


import com.softserveinc.volleymanagementtests.dal.models.TeamDal;
import com.softserveinc.volleymanagementtests.dal.repositories.PlayerRepository;
import com.softserveinc.volleymanagementtests.testdata.Mapper;
import com.softserveinc.volleymanagementtests.testdata.player.mappers.DalToPlayer;
import com.softserveinc.volleymanagementtests.testdata.team.Team;

import java.util.ArrayList;

public class DalToTeam implements Mapper<Team, TeamDal> {


    @Override
    public Team map(final TeamDal source)  {
        Team.TeamBuilder builder = new Team().newBuilder();

        if (source.getId() == null) {
            builder.setId("");
        } else {
            builder.setId(source.getId().toString());
        }

        if (source.getName() == null) {
            builder.setName("");
        } else {
            builder.setName(source.getName());
        }

        if (source.getCoach() == null) {
            builder.setCoach("");
        } else {
            builder.setCoach(source.getCoach());
        }

        if (source.getAchievements() == null) {
            builder.setAchievements("");
        } else {
            builder.setAchievements(source.getAchievements());
        }

        if (source.getCaptainId() == null) {
            builder.setCaptain(null);
        } else {
            builder.setCaptain(new DalToPlayer().map(
                    new PlayerRepository().getById(source.getCaptainId())));
        }

        if (source.getId() == null) {
            builder.setRoster(new ArrayList<>());
        } else {
            for (PlayerDal playerDal : new PlayerRepository().getTeamMembers(source.getId())) {
                builder.addPlayer(new DalToPlayer().map(playerDal));
            }
        }

        return builder.build();
    }
}

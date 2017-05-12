package testdata.team;

import com.softserveinc.volleymanagementtests.testdata.player.PlayerTestData;
import com.softserveinc.volleymanagementtests.testdata.player.Violations;
import com.softserveinc.volleymanagementtests.testdata.team.fields.Achievements;
import com.softserveinc.volleymanagementtests.testdata.team.fields.Coach;
import com.softserveinc.volleymanagementtests.testdata.team.fields.Name;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J.Bodnar 22.02.2016.
 */
public class TeamTestData {
    
    private List<User> validUserList;
    
    public TeamTestData() {
    }
    
    {
        validTeamsList = new ArrayList<>();
        validTeamsList.add(new Team().newBuilder()
                .setName("1")
                .setCoach("W")
                .setAchievements("2")
                .setCaptain(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("e")
                .setCaptain(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("AAAЇІЄҐAAASSSSSSSSSSDDDDDDDDDD")
                .setCoach("AAAЇІЄҐAAASSSSSSSSSSDDDDDDDDDDFFFFFFFFFFGGGGGGGGGGHHHHHHHHHH")
                .setAchievements(RandomStringUtils.random(100, true, true))
                .setCaptain(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("1h3456789yjukilokmhnbgfrthygrt")
                .setCaptain(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("Ъ+!)№;%:'?*ff_+=/-)1234")
                .setCoach("Co ac-h")
                .setAchievements("3547u78i9o0:?*'ff_+=/-)12322")
                .setCaptain(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("someName")
                .setCaptain(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer()).build());
        validTeamsList.add(new Team().newBuilder()
                .setName("teamName")
                .setCoach("")
                .setAchievements("")
                .setCaptain(new PlayerTestData().getValidPlayer())
                .build());
    }
    
    public List<Team> getValidTeamsList() {
        return new TeamTestData().validTeamsList;
    }
    
    public Team getValidTeam() {
        return new Team().newBuilder()
                .setName(RandomStringUtils.random(10, true, true))
                .setCoach(RandomStringUtils.random(20, true, false))
                .setAchievements(RandomStringUtils.random(100, true, true))
                .setCaptain(new PlayerTestData().getValidPlayer())
                .addPlayer(new PlayerTestData().getValidPlayer())
                .build();
    }
    
    public List<Team> getValidTeams(int teamCount) {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            teams.add(new TeamTestData().getValidTeam());
        }
        return teams;
    }
    
    public Team getInvalidTeamByName(Violations violation) {
        return new Team().newBuilder(new TeamTestData().getValidTeam())
                .setName(new Name().getInvalidBy(violation)).build();
    }
    
    public Team getInvalidTeamByCoach(Violations violation) {
        return new Team().newBuilder(new TeamTestData().getValidTeam())
                .setCoach(new Coach().getInvalidBy(violation)).build();
    }
    
    public Team getInvalidTeamByAchievements(Violations violation) {
        return new Team().newBuilder(new TeamTestData().getValidTeam())
                .setAchievements(new Achievements().getInvalidBy(violation)).build();
    }
    
    public Team getInvalidTeamWithoutCaptain() {
        return new Team().newBuilder()
                .setName(RandomStringUtils.random(10, true, true))
                .setCoach(RandomStringUtils.random(20, true, false))
                .setAchievements(RandomStringUtils.random(100, true, true))
                .addPlayer(new PlayerTestData().getValidPlayer())
                .build();
    }
    
}
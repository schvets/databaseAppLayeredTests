package testdata.user.fields;

import com.softserveinc.volleymanagementtests.testdata.player.Violations;
import org.apache.commons.lang3.RandomStringUtils;


/**
 * @author J.Bodnar
 */
public class Name {

    private final int maxFieldLength;

    public Name() {
        this.maxFieldLength = 30;
    }

    public String getInvalidBy(Violations violation) {
        switch (violation) {
            case EMPTY_FIELD:
                return "";
            case MAX_LENGTH_VIOLATED:
                return RandomStringUtils.random(maxFieldLength + 1, true, true);
            default:
                throw new RuntimeException(String.format(
                        "%s violation is not available for the %s field",
                        violation.toString(), "team name"));
        }
    }
}

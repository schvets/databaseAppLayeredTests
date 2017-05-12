package testdata.team.fields;

import com.softserveinc.volleymanagementtests.testdata.player.Violations;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * @author  J.Bodnar
 */
public class Coach {

    private final int maxFieldLength;
    private final char[] notAllowedCharacters;

    public Coach() {
        this.maxFieldLength = 60;
        this.notAllowedCharacters = new char[] {'!', '?', '@', '#', '%', '^', '&', '*', '(', ')', ',', '/', '.'};
    }

    public String getInvalidBy(Violations violation) {
        switch (violation) {
            case MAX_LENGTH_VIOLATED:
                return RandomStringUtils.random(this.maxFieldLength + 1, true, false);
            case CONTAINS_NUMBERS:
                return RandomStringUtils.random(new Random().nextInt(this.maxFieldLength), true, true);
            case CONTAIN_NOT_ALLOWED_CHARACTERS:
                return RandomStringUtils
                        .random(new Random().nextInt(this.maxFieldLength), this.notAllowedCharacters);
            default:
                throw new RuntimeException(String.format(
                        "%s violation is not available for the %s field",
                        violation.toString(), "coach"));
        }
    }
}

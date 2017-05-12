package specification.criteria;

import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Alert;
import org.openqa.selenium.NotFoundException;

public class AlertCriteria implements Specifiable {
    private Alert alert;
    private Specification specification;

    public AlertCriteria(Alert alert, Specification specification) {
        if (alert == null) {
            throw new NotFoundException("the income Alert == null");
        }
        this.alert = alert;
        this.specification = specification;
    }

    public AlertCriteria textMatch(final String expectedResult) {
        String actualResult = alert.getText();
        specification.add(actualResult.equals(expectedResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Label text does not match",
                        expectedResult, actualResult));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}

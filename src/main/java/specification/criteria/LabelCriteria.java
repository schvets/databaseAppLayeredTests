package specification.criteria;
/**
 * Author S.Tsiganovskiy
 */

import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Label;

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class LabelCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Label label;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aLabel         control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public LabelCriteria(final Label aLabel,
                         final Specification aSpecification) {

        label = aLabel;
        specification = aSpecification;
    }

    /**
     * verify if the text of the label is as expected.
     *
     * @param expectedResult String to compare with
     * @return LabelCriteria
     */
    public LabelCriteria textMatch(final String expectedResult) {
        if (label.isDisplayed()) {
            String actualResult = label.getText();
            specification.add(actualResult.equals(expectedResult),
                    String.format("%s:%n  expected [%s]%n but found [%s]; ",
                            "The Label text does not match",
                            expectedResult, actualResult));
        } else specification.add(false,
                "The error message is not appeared");
        return this;
    }

    /**
     * verify if the label is visible.
     *
     * @return LabelCriteria
     */
    public LabelCriteria isVisible() {
        specification.add(label.isDisplayed(),
                "The Label is not visible.");
        return this;
    }

    public LabelCriteria isEqvivalent(int roundsCount) {
        boolean result =
                (label.equals(roundsCount));

        if (!result)
            specification.add(result,
                    "Wrong number of rounds. Actual : " + label.equals(roundsCount) + " expected: " +
                            roundsCount);
        return this;
    }


    @Override
    public Specification next() {
        return specification;
    }
}

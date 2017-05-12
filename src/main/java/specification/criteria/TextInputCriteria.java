package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.TextInput;

/**
 * @ J.Bodnar on 12.02.2016.
 */

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class TextInputCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private TextInput textInput;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aTextInput     control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public TextInputCriteria(final TextInput aTextInput,
                             final Specification aSpecification) {
        if (aTextInput == null) {
            throw new NotFoundException("the income TextInput == null");
        }

        textInput = aTextInput;
        specification = aSpecification;
    }

    /**
     * verify if the TextInput is visible.
     *
     * @return TextInputCriteria
     */
    public TextInputCriteria isVisible() {
        specification.add(textInput.isDisplayed(),
                "The TextInput is not visible.");
        return this;
    }

    /**
     * verify if the TextInput is empty.
     *
     * @return TextInputCriteria
     */
    public TextInputCriteria isEmpty() {
        specification.add("".equals(textInput.getText()),
                "The TextInput is not empty.");
        return this;
    }

    /**
     * verify if the text of the field is as expected.
     *
     * @param expectedResult String to compare with
     * @return TextInputCriteria
     */
    public TextInputCriteria textMatch(final String expectedResult) {
        String actualResult = textInput.getText();
        specification.add(expectedResult.equals(actualResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The TextInput text does not match",
                        expectedResult, actualResult));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }

}

package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Dropdown;

import java.util.List;
/**
 * Author S.Tsiganovskiy
 */

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class DropdownCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Dropdown dropdown;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aDropdown      control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public DropdownCriteria(final Dropdown aDropdown,
                            final Specification aSpecification) {
        if (aDropdown == null) {
            throw new NotFoundException("the income Dropdown == null");
        }

        dropdown = aDropdown;
        specification = aSpecification;
    }

    /**
     * Compare visible text (or an option) with the expected string.
     *
     * @param expectedResult String to compare with
     * @return DropdownCriteria
     */
    public DropdownCriteria visibleTextMatch(final String expectedResult) {
        String actualResult = dropdown.getSelectedOptionText();
        specification.add(actualResult.equals(expectedResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Dropdown visible text doesn't match",
                        expectedResult, actualResult));
        return this;
    }

    /**
     * Compare value of an option  with expected string.
     *
     * @param expectedResult String to compare with
     * @return DropdownCriteria
     */
    public DropdownCriteria valueMatch(final String expectedResult) {
        String actualResult = dropdown.getSelectedOptionValue();
        specification.add(actualResult.equals(expectedResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Dropdown selected option value does not match",
                        expectedResult, actualResult));
        return this;
    }

    /**
     * Compare current optionsList with expected one.
     *
     * @param expectedOptionsList List<String> of options the Dropdown should
     *                            contain according to spec
     * @return DropdownCriteria
     */
    public DropdownCriteria optionsListMatch(final
                                             List<String> expectedOptionsList) {
        List<String> actualOptionsList = dropdown.getOptions();
        specification.add(actualOptionsList.equals(expectedOptionsList),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Dropdown options list does not match",
                        expectedOptionsList, actualOptionsList));
        return this;
    }

    /**
     * checks if the dropdown is enabled.
     *
     * @return DropdownCriteria
     */
    public DropdownCriteria isEnabled() {
        specification.add(dropdown.isEnabled(), "The Dropdown is non enabled.");
        return this;
    }

    @Override
    public Specification next() {
        return specification;
    }
}

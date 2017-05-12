package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class StringCriteria implements Specifiable {

    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private String stringInst;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aString        control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    private StringCriteria(final String aString,
                           final Specification aSpecification) {
        if (aString == null) {
            throw new NotFoundException("the income Integer == null");
        }

        stringInst = aString;
        specification = aSpecification;
    }

    /**
     * in order to provide the "fluent api".
     *
     * @param aString        control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     * @return BooleanCriteria
     */
    public static StringCriteria get(final String aString,
                                     final Specification aSpecification) {
        return new StringCriteria(aString, aSpecification);
    }

    /**
     * check if the income boolean is true.
     *
     * @return BooleanCriteria
     */

    /**
     * check if the income digit is not greater than max.
     *
     * @param expectedString the digit to compare with
     * @return StringCriteria
     */
    public StringCriteria valueMatch(final String expectedString) {
        String actualString = this.stringInst;
        specification.add(expectedString.equals(actualString),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The line does not match",
                        expectedString, actualString));
        return this;
    }

    public StringCriteria valueContains(final String expectedString) {
        String actualString = this.stringInst;
        specification.add(actualString.contains(expectedString),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The digit does not match",
                        expectedString, actualString));
        return this;
    }


    @Override
    public Specification next() {
        return this.specification;
    }
}

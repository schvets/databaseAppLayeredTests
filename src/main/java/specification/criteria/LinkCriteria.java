package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Link;

/**
 * Author S.Tsiganovskiy
 */

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class LinkCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Link link;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param alink          control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public LinkCriteria(final Link alink, final Specification aSpecification) {
        if (alink == null) {
            throw new NotFoundException("the income Link == null");
        }
        link = alink;
        specification = aSpecification;
    }

    /**
     * verify if the text of the link is as expected.
     *
     * @param expectedResult String to compare with
     * @return LinkCriteria
     */
    public LinkCriteria textMatch(final String expectedResult) {
        String actualResult = link.getText();
        specification.add(actualResult.equals(expectedResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Link text does not match",
                        expectedResult, actualResult));
        return this;
    }

    /**
     * verify if the href of the link is as expected.
     *
     * @param expectedResult String to compare with
     * @return LinkCriteria
     */
    public LinkCriteria hrefMatch(final String expectedResult) {
        String actualResult = link.getHref();
        specification.add(actualResult.equals(expectedResult),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Link href does not match",
                        expectedResult, actualResult));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}

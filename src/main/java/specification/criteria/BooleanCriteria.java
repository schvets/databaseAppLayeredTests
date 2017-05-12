package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class BooleanCriteria implements Specifiable {

    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Boolean booleanInst;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aBoolean       control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public BooleanCriteria(final Boolean aBoolean,
                           final Specification aSpecification) {
        if (aBoolean == null) {
            throw new NotFoundException("the income Integer == null");
        }

        booleanInst = aBoolean;
        specification = aSpecification;
    }

    /**
     * check if the income boolean is true.
     *
     * @return BooleanCriteria
     */
    public BooleanCriteria isTrue() {
        specification.add(booleanInst,
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "It isn't",
                        "true", "false"));
        return this;
    }

    /**
     * check if the income boolean is false.
     *
     * @return BooleanCriteria
     */
    public BooleanCriteria isFalse() {
        specification.add(!booleanInst,
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "It is",
                        "false", "true"));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}

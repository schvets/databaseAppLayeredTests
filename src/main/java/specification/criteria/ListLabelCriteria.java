package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Label;

import java.util.List;

/**
 * Created by Natalia on 13.03.2017.
 */
public class ListLabelCriteria implements Specifiable{
    private List<Label> label;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param label         control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public ListLabelCriteria(List<Label> label, Specification aSpecification) {
        if ( label == null) {
            throw new NotFoundException("the income List == null");
        }

        this.label = label;
        specification = aSpecification;
    }



    public ListLabelCriteria isEqvivalent(int roundsCount){
        boolean result =
                (label.size() == roundsCount);

            if(!result)
            specification.add(result,
                    "Wrong number of rounds. Actual : " + label.size() + " expected: " + roundsCount);
       return this;
    }

    @Override
    public Specification next() {
        return specification;
    }
}

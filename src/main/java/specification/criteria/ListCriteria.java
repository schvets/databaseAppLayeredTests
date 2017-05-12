package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Label;

import java.util.List;

/**
 * @author Danil Zhyliaiev
 */
public final class ListCriteria implements Specifiable {
    private List list;
    private Specification specification;

    public ListCriteria(final List list,
                        final Specification aSpecification) {
        if (list == null) {
            throw new NotFoundException("the income List == null");
        }

        this.list = list;
        specification = aSpecification;
    }

    public ListCriteria containsAll(final List expectedList) {
        specification.add(list.containsAll(expectedList),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The List does not contain all the elements",
                        expectedList, list));
        return this;
    }

    public ListCriteria contains(final String option) {
        specification.add(list.contains(option),
                String.format("The List does not contain the element - ",
                        option));
        return this;
    }

    public ListCriteria listSizeEquals(final int expectedSize) {
        int actualSize = list.size();
        specification.add(actualSize == expectedSize,
                String.format("%s:%n  expected [%d]%n but found [%d]; ",
                        "The List has wrong size",
                        expectedSize, actualSize));
        return this;
    }

    public ListCriteria labelTextsMatch(String expectedText) {
        for (Object label : list) {
            specification.add(((Label) label).getText().equals(expectedText),
                    String.format("%s:%n  expected [%s]%n but found [%s]; ",
                            "Labels text doesn't match ",
                            expectedText, ((Label) label).getText()));
        }
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}

package specification;

/**
 * @author Danil Zhyliaiev
 */

/**
 * the classes which implements this interface
 * should have a Specification field.
 */
public interface Specifiable {
    /**
     * pass forward the Specification for the further manipulations with it.
     *
     * @return current object's Specification.
     * in order the next(new/another) methods(manipulations)
     * could be applied to the Specification.
     */
    Specification next();


}

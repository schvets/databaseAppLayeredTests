package testdata;

/**
 * Imposes obligation to implement data transfer between Data Access Layer
 * and Test-scripts layer.
 *
 * @param <T>   Type of target object.
 *
 * @param <S>   Type of source object.
 */
public interface Mapper<T, S> {
    T map(S source);
}

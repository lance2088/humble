package humble.runtime;

/**
 * The base class for all entities in the Humble language.
 *
 * @author nickpeck
 */
public interface Callable<T extends Callable> {

    /**
     * Because Humble is concerned with Typed Lambda calculus, all entities must
     * be callable objects returning a defined type. This interface enforces
     * this property.
     *
     * @param args
     * @return
     */
    T call(final Callable... args);


    /**
     * Enforce the behaviour that we can bind callable x to another callable (y),
     * such that x.bindTo(y) is equivalent to y(x());
     *
     * @param a
     * @return
     */
    Callable bindTo(final Callable a);
}

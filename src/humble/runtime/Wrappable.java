package humble.runtime;

/**
 * Describes the behaviour of an entity which wraps a Java Type.
 * @author nickpeck
 */
public interface Wrappable<W> {
     /**
     * Unwrap, to yield the Java type within. This is usually called at the end
     * of an evaluation, or when interfacing with external java code.
     * @return - the unwrapped object.
     */
    public W unwrap();
}

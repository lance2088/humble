package humble.runtime;

/**
 * Abstract blueprint for providing a functional context for a Java type W, so it
 * can be used in Humble as Type T.
 * @author nickpeck
 */
public abstract class Primitive <W> implements Callable, Wrappable<W> {

    private W value;
    
    public Primitive(W value){
        this.value = value;
    }
    
    /**
     * A call method is provided for sematic purposes only. In reality, all this does
     * is to return the wrapper class instance when invoked.
     * @param args
     * @return 
     */
    @Override
    public Callable call(final Callable... args) {
        return this;
    }
    
    
    /**
     * Unwrap, to yield the Java type within. This is usually called at the end
     * of an evaluation, or when interfacing with external java code.
     * @return - the unwrapped object.
     */
    @Override
    public final W unwrap() {
        return value;
    }

    @Override
    public Callable bindTo(final Callable a) {
        return a.call(this);
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
}

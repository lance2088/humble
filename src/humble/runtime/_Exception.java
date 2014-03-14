package humble.runtime;

/**
 *
 * @author nickpeck
 */
public class _Exception extends Primitive<Exception> {

    private Callable callable;
    private Callable[] args;

    /**
     * 
     * @param e
     * @param callable
     * @param args 
     */
    public _Exception(final Exception e, Callable callable, Callable[] args) {
        super(e);
        this.callable = callable;
        this.args = args;
    }

    public Callable getCallable() {
        return callable;
    }

    public Callable[] getArgs() {
        return args;
    }
    
}

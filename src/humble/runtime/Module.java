package humble.runtime;

/**
 *
 * @author nickpeck
 */
public abstract class Module extends StdLib implements Callable {

    @Override
    public Callable bindTo(Callable a) {
        return a.call(this.call());
    }

    /**
     * If c is a FuturePromise, force its immediate evaluation. The blocks until
     * a result can be returned.
     *
     * @param c
     * @return
     */
    protected static Callable yield(final Callable c) throws HumbleRuntimeException {
        Callable result = c;
        while (result instanceof FuturePromise) {
            result = c.call();
            if (result instanceof _Exception) {
                throw new HumbleRuntimeException( ((_Exception) result).unwrap());
            }
        }
        return result;
    }
}

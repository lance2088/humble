package humble.runtime;

/**
 * Abstract blueprint for a lambda, or anonymous function.
 *
 * @author nickpeck
 */
public abstract class Lambda<T extends Callable> implements Callable {

    /**
     * Call the lambda with a specific set of args. These will be evaluated
     * according to the logic defined in boolean validateArgs(Callable... args).
     * Because Humble uses lazy evaluation, the evaluate() function is not
     * directly invoked. Rather, a FuturePromise object is returned, which can
     * be used to call the evaluation at a later point in time.
     *
     * @param args
     * @return
     */
    @Override
    public FuturePromise<T> call(final Callable... args) {
        if (!validateArgs(args)) {
            //TODO, throw an exception or system.exit()???
        }
        return new FuturePromise(this, args);
    }

    /**
     * Called to validate the arguments supplied to the Lambda.
     *
     * @param args - the args supplied through the call(Callable... args)
     * method.
     * @return
     */
    protected boolean validateArgs(final Callable... args) {
        return true;
    }

    /**
     * Carry out the actual computation expressed by the Lambda function.
     *
     * @param args
     * @return
     */
    protected abstract Callable<T> evaluate(final Callable... args) throws Exception;

    /**
     * delay the evaluation, allowing the lambda to be passed back up to the
     * callee, then the result is bound to Callable a.
     *
     * @param a
     * @return
     */
    @Override
    public Callable bindTo(final Callable a) {
        //return a.call(this.call());
        final Lambda parent = this;
        return new Lambda() {
            @Override
            protected Callable evaluate(Callable... args) {
                //nb args, in this context are those passed back from the callee
                //at this point, the lambda has been passed BACK up to the 
                //calling function. 'args' are those passed back into this lambda
                Callable result = parent.call(args);

                //Now, we call the bound function (Callable a), passing the result
                //of the previous computation.
                return a.call(result);
            }
        };
    }
}

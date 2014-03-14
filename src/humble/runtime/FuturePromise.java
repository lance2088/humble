package humble.runtime;

/**
 * Provides a promise that a given lambda function will be evaluated using a
 * specific set of arguments at an indeterminate point in the future.
 *
 * @author nickpeck
 */
public class FuturePromise<T extends Callable> implements Callable {

    private Callable callable;
    private Callable[] callableArgs;

    /**
     *
     * @param c - the Lambda function to be evaluated.
     * @param args - the arguments to evaluate callable with.
     */
    public FuturePromise(final Callable c, final Callable[] args) {
        this.callable = c;
        this.callableArgs = args;
    }

    /**
     * Force the evaluation to occur. This call will block until a result of
     * type T can be returned.
     * The process is stackless and allows for infinite recursion in most cases.
     * @param callableArgs usually empty, but an exception to this case is when
     * a series of closures takes 'curried' args such as a(b)(c)(d) ...
     * @return
     */
    @Override
    public synchronized T call(final Callable... args) {
        //in line with functional prinicples, we should be able to invoke call
        //multiple times and always yield the same result.
        //to do this, we create a memento of the object, which we will restore at the end.
        FuturePromise memento = new FuturePromise(this.callable, this.callableArgs);
        //preserve the internal volatile state.
        
        boolean keep_evaluating = true;
        T result = null;
        while (keep_evaluating) {
            //itterate through the args and evaluate any which are FuturePromise instances
            for (int i = 0; i < this.callableArgs.length; i++) {
                Callable arg = this.callableArgs[i];
                while (this.callableArgs[i] instanceof FuturePromise) {
                    this.callableArgs[i] = arg.call();
                }
            }
            //having evaluated the arguments, now try to evaluate the callable with the args
            if (callable instanceof Lambda) {
                try {
                    result = (T) ((Lambda) callable).evaluate(this.callableArgs);
                } catch (Exception e) {
                    result = (T) new _Exception(e, callable, this.callableArgs);
                }
                callable = result;//this will, by definition return a FuturePromise
                //we have to loop again to evaluate this.
            } 
            if (!(callable instanceof FuturePromise)) {
                //process stops when callable is no longer a FuturePromise
                keep_evaluating = false;
            } else {
                //loop again, delving one level deeper into the virtual stack.
                this.callable= ((FuturePromise) result).callable;
                this.callableArgs = ((FuturePromise) result).callableArgs;
            }
        }

        //restore the state prior to invokation
        this.callable = memento.callable;
        this.callableArgs = memento.callableArgs;
        //in this case, result is a closure, and takes further args:
        if(args.length > 0) {
            return (T)result.call(args);
        }
        //otherwise, just return the result
        return result;
    }

    @Override
    public Callable bindTo(final Callable a) {
        T result = this.call();
        return new FuturePromise(a, new Callable[]{result});
    }
}

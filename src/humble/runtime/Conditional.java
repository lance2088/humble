package humble.runtime;

import humble.primitives._Boolean;

/**
 * Blueprint for a conditional statement
 *
 * @author nickpeck
 */
public abstract class Conditional extends Lambda {

    /**
     * Conditional statement that will be executed at runtime to determine which
     * branch to evaluate.
     *
     * @return
     */
    protected abstract _Boolean condition() throws HumbleRuntimeException;

    /**
     * Code to be executed if conditional() validates to _Boolean(true)
     *
     * @return Callable representing the result of the computation.
     */
    protected abstract Callable onIf();

    /**
     * Code to be executed if conditional() validates to _Boolean(false)
     *
     * @return Callable representing the result of the computation.
     */
    protected abstract Callable onElse();

    /**
     * Method called when the conditional statement is called at runtime
     *
     * @param args (are discarded for the purposes of this computation)
     * @return
     */

    @Override
    protected Callable evaluate(Callable... args) throws Exception {
        _Boolean conditionalRes = condition();
        if (conditionalRes.unwrap()) {
            return onIf();
        }
        return onElse();
    }
}

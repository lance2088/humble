package humble.primitives;

import humble.runtime.Callable;
import humble.runtime.Primitive;

/**
 * Functional wrapper for a Java String type.
 *
 * @author nickpeck
 */
public class _String extends Primitive<String> {

    public _String(final String s) {
        super(s);
    }

    public _String(final Callable c) {
        super(c.toString());
    }
}

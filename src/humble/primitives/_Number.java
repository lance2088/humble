package humble.primitives;

import humble.runtime.Primitive;

/**
 * Functional wrapper for a Java numeric type.
 * All numeric types are converted to Double internally
 * @author nickpeck
 */
public class _Number extends Primitive<Double> {

    public _Number(final Double d) {
        super(d);
    }

    public _Number(final Float f) {
        super(f.doubleValue());
    }

    public _Number(final Integer i) {
        super(i.doubleValue());
    }

    public _Number(final Long l) {
        super(l.doubleValue());
    }
}

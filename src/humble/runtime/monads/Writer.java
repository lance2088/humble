package humble.runtime.monads;


import humble.primitives._List;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;

/**
 *
 * @author nickpeck
 */
public class Writer extends Module {

    public final static Lambda raise = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable value = args[0];
            return new _List(value, new _List());
        }

        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 1) {
                return false;
            }
            return true;
        }
    };
    public final static Lambda call = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) throws HumbleRuntimeException {
            final Callable value = ((_List) args[0]).get(0);
            final Callable log = ((_List) args[0]).get(1);
            final Callable modifier = args[1];
            final Callable log_msg = args[2];
            return new _List(modifier.call(value), append.call(log, log_msg));
        }

        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 3) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }
    };
    public final static Lambda get_log = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable log = ((_List) args[0]).get(1);
            return log;
        }

        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 3) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }
    };
    public final static Lambda get_value = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable value = ((_List) args[0]).get(0);
            return value;
        }

        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 3) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }
}

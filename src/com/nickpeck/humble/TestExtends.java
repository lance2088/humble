package com.nickpeck.humble;

import humble.runtime.*;
import humble.primitives.*;
import humble.runtime.HumbleRuntimeException;
import humble.libs.IO;
import humble.libs.Yield;

public class TestExtends extends Module {

    public final static Lambda long_process = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(equals.call(x, new _Number(1000)));
                }

                @Override
                public final Callable onIf() {
                    return x;
                }

                @Override
                public final Callable onElse() {
                    return long_process.call(plus.call(x, new _Number(1)));
                }
            }.call();
        }
    };
    public final static Lambda print = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return x.bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    return new IO() {
                        @Override
                        public Callable call(final Callable... args) {
                            return (new Lambda() {
                                @Override
                                protected final Callable evaluate(Callable... args) {
                                    final Callable x = args[0];
                                    return print_out.call(x);
                                }
                            }).call(args);
                        }
                    }.call(args);
                }
            });
        }
    };
    public final static Lambda itter = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = ((_List) args[0]);
            final Callable H = list_head.call(((_List) args[0]));
            final Callable T = list_tail.call(((_List) args[0]));
            final Callable l = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(equals.call(length.call(x), new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return l;
                }

                @Override
                public final Callable onElse() {
                    return new Yield() {
                        @Override
                        public Callable call(final Callable... args) {
                            return (new Lambda() {
                                @Override
                                protected final Callable evaluate(Callable... args) {
                                    return attempt.call(H);
                                }
                            }).call(args);
                        }
                    };
                }
            }.call().bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable x = args[0];
                    return append.call(x, l);
                }
            }).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable new_l = args[0];
                    return itter.call(T, new_l);
                }
            });
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }

    public static void main(String[] args) throws HumbleRuntimeException {
        itter.call(new _List(plus.call(new _Number(1), new _Number(1)), plus.call(new _Number(2), new _Number(2)), plus.call(new _Number(3), new _Number(3)), plus.call(new _Number(4), new _Number(4)), plus.call(new _Number(5), new _Number(5))), new _List()).bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                return print.call(args);
            }
        }).call();
    }
}
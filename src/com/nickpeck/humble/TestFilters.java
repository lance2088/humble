package com.nickpeck.humble;

import humble.runtime.*;
import humble.primitives.*;
import humble.runtime.HumbleRuntimeException;
import humble.libs.IO;

public class TestFilters extends Module {

    public final static Lambda itterPrint = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable list = ((_List) args[0]);
            final Callable H = list_head.call(((_List) args[0]));
            final Callable T = list_tail.call(((_List) args[0]));
            final Callable str_result = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(equals.call(length.call(list), new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return str_cat.call(str_result, new _String("]"));
                }

                @Override
                public final Callable onElse() {
                    return new Conditional() {
                        @Override
                        public final _Boolean condition() throws HumbleRuntimeException {
                            return (_Boolean) yield(equals.call(str_result, new _String("")));
                        }

                        @Override
                        public final Callable onIf() {
                            return itterPrint.call(T, str_cat.call(new _String("["), H));
                        }

                        @Override
                        public final Callable onElse() {
                            return itterPrint.call(T, str_cat.call(str_result, new _String(","), H));
                        }
                    }.call();
                }
            }.call();
        }
    };
    public final static Lambda validation_chain = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            final Callable filters = ((_List) args[1]);
            final Callable Head = list_head.call(((_List) args[1]));
            final Callable Tail = list_tail.call(((_List) args[1]));
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(equals.call(length.call(filters), new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return new _Boolean(true);
                }

                @Override
                public final Callable onElse() {
                    return new Conditional() {
                        @Override
                        public final _Boolean condition() throws HumbleRuntimeException {
                            return (_Boolean) yield(Head.call(n));
                        }

                        @Override
                        public final Callable onIf() {
                            return validation_chain.call(n, Tail);
                        }

                        @Override
                        public final Callable onElse() {
                            return new _Boolean(false);
                        }
                    }.call();
                }
            }.call();
        }
    };
    public final static Lambda test_upr_boundary = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return less_than.call(n, new _Number(100));
        }
    };
    public final static Lambda test_lwr_boundary = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return gtr_than.call(n, new _Number(20));
        }
    };
    public final static Lambda test_equ_50 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return equals.call(n, new _Number(50));
        }
    };
    public final static Lambda test1 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(validation_chain.call(new _Number(50), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };
    public final static Lambda test2 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(validation_chain.call(new _Number(101), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };
    public final static Lambda test3 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(validation_chain.call(new _Number(19), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }

    public static void main(String[] args) {
        new _List(test1.call(), test2.call(), test3.call()).bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable x = args[0];
                return itterPrint.call(x, new _String(""));
            }
        }).bindTo(new Lambda() {
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
        }).call();
    }
}

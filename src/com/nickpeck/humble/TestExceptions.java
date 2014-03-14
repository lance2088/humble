package com.nickpeck.humble;

import humble.runtime.*;
import humble.primitives.*;
import humble.runtime.HumbleRuntimeException;
import humble.libs.IO;
import humble.libs.Yield;

public class TestExceptions extends Module {

    public final static Lambda unsafeMethod = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return plus.call(new _Number(2), x);
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
                                    return print_out.call(x);
                                }
                            }).call(args);
                        }
                    }.call(args);
                }
            });
        }
    };
    public final static Lambda dodgyConditional = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(gtr_than.call(new _String("hello"), new _Number(5)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("got if");
                }

                @Override
                public final Callable onElse() {
                    return new _String("got else");
                }
            }.call();
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }

    public static void main(String[] args) throws HumbleRuntimeException {
        new Yield() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return attempt.call(unsafeMethod.call(new _String("Hello!")));
                    }
                }.bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable outcome = args[0];
                        return grab.call(new _Class(humble.runtime._Exception.class), outcome, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable e = args[0];
                                return str_cat.call(new _String("there was a runtime error : "), e);
                            }
                        });
                    }
                })).call(args);
            }
        }.bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable e = args[0];
                return print.call(e);
            }
        }).call();
        new Yield() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return attempt.call(unsafeMethod.call(new _Number(2)));
                    }
                }.bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable outcome = args[0];
                        return grab.call(new _Class(humble.runtime._Exception.class), outcome, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable e = args[0];
                                return str_cat.call(new _String("there was a runtime error : "), e);
                            }
                        });
                    }
                })).call(args);
            }
        }.bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable e = args[0];
                return print.call(e);
            }
        }).call();
        new Yield() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return attempt.call(dodgyConditional.call());
                    }
                }.bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable outcome = args[0];
                        return grab.call(new _Class(humble.runtime._Exception.class), outcome, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable e = args[0];
                                return str_cat.call(new _String("there was a runtime error : "), e);
                            }
                        });
                    }
                })).call(args);
            }
        }.bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable e = args[0];
                return print.call(e);
            }
        }).call();
        new Yield() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return attempt.call(dodgyConditional.call());
                    }
                }).call(args);
            }
        }.bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable e = args[0];
                return print.call(e);
            }
        }).call();
    }
}
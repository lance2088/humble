package com.nickpeck.humble;

import humble.runtime.*;
import humble.primitives.*;
import humble.libs.IO;

public class Test extends Module {

    public final static Lambda f = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new _String("Hello, world 3!");
        }
    };
    public final static Lambda iterator = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            final Callable y = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(equals.call(x, y));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Values are equal!!!");
                }

                @Override
                public final Callable onElse() {
                    return iterator.call(plus.call(x, new _Number(1)), y);
                }
            }.call();
        }
    };
    public final static Lambda itterPrint = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable list = ((_List) args[0]);
            final Callable H = list_head.call(((_List) args[0]));
            final Callable T = list_tail.call(((_List) args[0]));
            final Callable str_result = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
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
                        public final _Boolean condition() throws HumbleRuntimeException{
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
    public final static Lambda _factorial = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            final Callable accumulator = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(equals.call(n, new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return accumulator;
                }

                @Override
                public final Callable onElse() {
                    return _factorial.call(minus.call(n, new _Number(1)), multiply.call(n, accumulator));
                }
            }.call();
        }
    };
    public final static Lambda factorial = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return _factorial.call(n, new _Number(1));
        }
    };
    public final static Lambda curry = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return new Lambda() {
                        @Override
                        protected final Callable evaluate(Callable... args) {
                            final Callable z = args[0];
                            return str_cat.call(x, y, z);
                        }
                    };
                }
            };
        }
    };
    public final static Lambda curry2 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return plus.call(x, new _Number(2)).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return plus.call(y, new _Number(2));
                }
            }).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable z = args[0];
                    return plus.call(z, new _Number(2));
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
            });
        }
    };
    public final static Lambda curry3 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return plus.call(y, new _Number(2));
                }
            }.bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    return (new Lambda() {
                        @Override
                        protected final Callable evaluate(Callable... args) {
                            final Callable e = args[0];
                            return plus.call(e, x);
                        }
                    }).call(args);
                }
            });
        }
    };
    public final static Lambda bank = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable initial_amount = args[0];
            return new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable modifier = args[0];
                    return modifier.call(initial_amount);
                }
            }.bindTo(new Lambda() {
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
            }).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    return bank.call(args);
                }
            });
        }
    };
    public final static Lambda add10 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable i = args[0];
            return plus.call(i, new _Number(10));
        }
    };
    public final static Lambda sub10 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable i = args[0];
            return minus.call(i, new _Number(10));
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }

    public static void main(String[] args) {
        new IO() {
            @Override
            public Callable call(final Callable... args) {
                return (print_out.call(new _String("Hello world 1!"))).call(args);
            }
        }.call();
        new _String("Hello world 2!").bindTo(new Lambda() {
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
        new IO() {
            @Override
            public Callable call(final Callable... args) {
                return (print_out.call(f.call())).call(args);
            }
        }.call();
        map.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return plus.call(a, new _Number(1));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(5), new _Number(6))).bindTo(new Lambda() {
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
        map.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return plus.call(a, new _Number(1));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(5), new _Number(6))).bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                return new IO() {
                    @Override
                    public Callable call(final Callable... args) {
                        return (new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return print_out.call(get.call(x, new _Number(0)));
                            }
                        }).call(args);
                    }
                }.call(args);
            }
        }).call();
        /*iterator.call(new _Number(11), new _Number(200000)).bindTo(new Lambda() {
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
        }).call();*/
        /*itterPrint.call(new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(5)), new _String("")).bindTo(new Lambda() {
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
        }).call();*/
        /*filter.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return equals.call(a, new _Number(2));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(2), new _Number(6))).bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                return new IO() {
                    @Override
                    public Callable call(final Callable... args) {
                        return (new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return print_out.call(itterPrint.call(x, new _String("")));
                            }
                        }).call(args);
                    }
                }.call(args);
            }
        }).call();*/
        map.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return plus.call(a, new _Number(1));
            }
        }, filter.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return equals.call(a, new _Number(2));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(2), new _Number(6)))).bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                return new IO() {
                    @Override
                    public Callable call(final Callable... args) {
                        return (new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return print_out.call(itterPrint.call(x, new _String("")));
                            }
                        }).call(args);
                    }
                }.call(args);
            }
        }).call();
        new IO() {
            @Override
            public Callable call(final Callable... args) {
                return (print_out.call(range.call(new _Number(0), new _Number(20)))).call(args);
            }
        }.call();
        glue.call(new _String(" "), new _List(new _String("I"), new _String("like"), new _String("2"), new _String("boogie"))).bindTo(new Lambda() {
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
        new IO() {
            @Override
            public Callable call(final Callable... args) {
                return (print_out.call(itterPrint.call(new _List(plus.call(new _Number(5), multiply.call(new _Number(6), new _Number(4))), plus.call(multiply.call(new _Number(7), new _Number(8)), (multiply.call(new _Number(3), new _Number(3)))), minus.call(plus.call(new _Number(9), new _Number(16)), new _Number(15)), plus.call(divide.call(new _Number(12), new _Number(6)), new _Number(10)), plus.call(new _Number(6), (divide.call(new _Number(9), new _Number(3)))), multiply.call((multiply.call(multiply.call(new _Number(2), new _Number(2)), new _Number(2))), (plus.call(new _Number(3), new _Number(7)))), and.call(new _Boolean(true), new _Boolean(true)), and.call(new _Boolean(true), new _Boolean(false)), and.call(new _Boolean(false), new _Boolean(false)), or.call(new _Boolean(true), new _Boolean(true)), or.call(new _Boolean(true), new _Boolean(false)), or.call(new _Boolean(false), new _Boolean(false)), not.call(new _Boolean(true)), not.call(new _Boolean(false))), new _String("")))).call(args);
            }
        }.call();
        /*factorial.call(new _Number(100)).bindTo(new Lambda() {
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
        }).call();*/
        curry.call(new _String("hello")).call(new _String("-")).call(new _String("world")).bindTo(new Lambda() {
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
        curry2.call(new _Number(1)).call();
        curry3.call(new _Number(1)).call(new _Number(2)).bindTo(new Lambda() {
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
        bank.call(new _Number(10)).call(add10).call(add10).call();
    }
}
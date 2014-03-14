package humble.runtime;

import static com.nickpeck.humble.Test.itterPrint;
import humble.primitives._Boolean;
import humble.primitives._List;
import humble.primitives._Number;
import humble.primitives._String;
import java.util.Iterator;

/**
 * Built-in functions extended by all modules. These take the form of Lambdas,
 * so should be invoked by calling their respective call() method. eg.
 * plus.call(new _Int(2), new _Int(4));
 *
 * @author nickpeck
 */
public class StdLib {

    /**
     * If c is a FuturePromise, force its immediate evaluation. The blocks until
     * a result can be returned.
     *
     * (This can't be called from user-level code)
     * @param c
     * @return
     */
    private static Callable yield(final Callable c) throws HumbleRuntimeException{
        Callable result = c;
        while (result instanceof FuturePromise) {
            result = c.call();
            if(result instanceof _Exception) {
                //throw new HumbleRuntimeException((_Exception)result);
            }
        }
        return result;
    }
    /**
     * (x,y) :: x+y Return a Lambda function to sum two _Int values.
     */
    protected static final Lambda<_Number> plus = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Number)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Number evaluate(final Callable... args) {
            final Double x = ((_Number) args[0]).unwrap();
            final Double y = ((_Number) args[1]).unwrap();
            return new _Number(x + y);
        }
    };
    /**
     * (x,y) :: x+y Return a Lambda function to sum two _Int values.
     */
    protected static final Lambda<_Number> minus = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Number)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Number evaluate(final Callable... args) {
            final Double x = ((_Number) args[0]).unwrap();
            final Double y = ((_Number) args[1]).unwrap();
            return new _Number(x - y);
        }
    };
    /**
     * (x,y) :: x+y Return a Lambda function to sum two _Int values.
     */
    protected static final Lambda<_Number> divide = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Number)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            if (((_Number) args[0]).unwrap() == 0) {
                return false;
            }
            return true;
        }

        @Override
        protected _Number evaluate(final Callable... args) {
            final Double x = ((_Number) args[0]).unwrap();
            final Double y = ((_Number) args[1]).unwrap();
            return new _Number(x / y);
        }
    };
    /**
     * (x,y) :: x+y Return a Lambda function to sum two _Int values.
     */
    protected static final Lambda<_Number> multiply = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Number)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Number evaluate(final Callable... args) {
            final Double x = ((_Number) args[0]).unwrap();
            final Double y = ((_Number) args[1]).unwrap();
            return new _Number(x * y);
        }
    };
    /**
     * Force the evaluation of the given argument (a FuturePromise)
     */
    /*protected static final Lambda<Callable> yield = new Lambda() {
        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length == 0) {
                return false;
            }
            if (!(args[1] instanceof FuturePromise)) {
                return false;
            }
            return true;
        }

        @Override
        protected Callable evaluate(Callable... args) {
            return args[0].call();
        }
    };*/
    /**
     * (x,y...) :: x+y+... Return a Lambda function to join any number of
     * _String objects.
     */
    protected static final Lambda<_String> str_cat = new Lambda() {
        @Override
        protected final _String evaluate(final Callable... args) {
            StringBuilder sb = new StringBuilder();
            for (Callable c : args) {
                if (c instanceof Wrappable) {
                    sb.append(((Wrappable) c).unwrap().toString());
                } else {
                    sb.append(c.toString());
                }
            }
            return new _String(sb.toString());
        }

        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length == 0) {
                return false;
            }
            return true;
        }
    };
    /**
     * (a, [b,c...]) :: a + b + c ... Return a Lambda function to join a list of
     * _String objects represented by the 2nd arg with a_String separator given
     * by the first arg.
     */
    protected static final Lambda<_String> glue = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _String)) {
                return false;
            }
            if (!(args[1] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected _String evaluate(final Callable... args) {
            final _String glue = (_String) args[0];
            final _List t = (_List) args[1];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < t.size(); i++) {
                if (t.get(i) instanceof Wrappable) {
                    sb.append(((Wrappable) t.get(i)).unwrap().toString());
                } else {
                    sb.append(t.get(i).toString());
                }
                if (i < t.size() - 1) {
                    sb.append(glue);
                }
            }
            return new _String(sb.toString());
        }
    };
    /**
     * (x,y) :: x==y Return a _Boolean value to assert the equality of any 2
     * objects passed to it.
     */
    protected static final Lambda<_Boolean> equals = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length < 2) {
                return false;
            }
            if (!(args[0] instanceof Wrappable)) {
                return false;
            }
            if (!(args[1] instanceof Wrappable)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Boolean evaluate(final Callable... args) {
            boolean result = ((Wrappable) args[0]).unwrap()
                    .equals(((Wrappable) args[1]).unwrap());
            return new _Boolean(result);
        }
    };
    /**
     * (callable,[a,b...]) :: [callable(a), callable(b)...] Apply the Lambda function
     * given by the first arg to each element in the list given as the second
     * arg.
     */
    protected static final Lambda<_List> map = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[1] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected _List evaluate(final Callable... args) {
            final Callable l = args[0];
            final _List t = (_List) args[1];
            Iterator<Callable> i = t.iterator();
            int index = 0;
            while (i.hasNext()) {
                final Callable c = i.next();
                t.set(index, l.call(c));
                index++;
            }

            return t;
        }
    };
    /**
     * Return a list that is the filtered set of the 2nd arg, where each element
     * is tested against the lambda given by the first arg.
     */
    protected static final Lambda<_List> filter = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof Lambda)) {
                return false;
            }
            if (!(args[1] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected _List evaluate(final Callable... args) {
            final Lambda l = (Lambda) args[0];
            final _List t = (_List) args[1];
            Iterator<Callable> i = t.iterator();
            while (i.hasNext()) {
                Callable c = i.next();
                _Boolean result = (_Boolean) l.call(c).call();//has to yeild here
                if (!result.unwrap()) {
                    i.remove();
                }
            }
            return t;
        }
    };
    protected static final Lambda<Callable> list_head = new Lambda() {
        @Override
        protected Callable evaluate(final Callable... args) {
            _List l = (_List) args[0];
            if (l.size() == 0) {
                return l;
            }
            return l.get(0);
        }

        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 1) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }
    };
    protected static final Lambda<Callable> list_tail = new Lambda() {
        @Override
        protected Callable evaluate(final Callable... args) {
            _List l = (_List) args[0];
            if (l.size() == 0) {
                return l;
            }
            return new _List(l.subList(1, l.size()));
        }

        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 1) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }
    };
    /**
     * sub_list(list, start, end) return a sublist of 'list' from the given
     * start and end indices.
     */
    protected static final Lambda<_List> sub_list = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 3) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            if (!(args[2] instanceof _Number)) {
                return false;
            }
            return true;
        }

        @Override
        protected _List evaluate(final Callable... args) {
            final _List l = (_List) args[0];
            final Integer leftIndex = ((_Number) args[1]).unwrap().intValue();
            final Integer rightIndex = ((_Number) args[2]).unwrap().intValue();
            return new _List(l.subList(leftIndex, rightIndex));
        }
    };
    /**
     * append(list, a) append Callable a to a 'list'.
     */
    protected static final Lambda<_List> append = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected Callable evaluate(final Callable... args) {
            final _List l = (_List) args[0];
            final Callable c = args[1];
            _List newList = new _List(l);
            newList.add(c);
            return newList;
        }
    };
    /**
     * push(list, a) push atom a to the left of list
     */
    protected static final Lambda<_List> push = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected _List evaluate(final Callable... args) {
            final _List l = (_List) args[0];
            final Callable c = args[1];
            _List newList = new _List(l);
            //System.out.println("pushing " + c + " onto " + newList);
            newList.push(c);
            return newList;
        }
    };
    /**
     * get(list, i) get the item at index i
     */
    protected static final Lambda<Callable> get = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            return true;
        }

        @Override
        protected Callable evaluate(final Callable... args) {
            final _List l = (_List) args[0];
            final _Number i = (_Number) args[1];
            return l.get(i.unwrap().intValue());
        }
    };
    /**
     * thread(statement, callback) start a new thread-the result of statement
     * will be passed to lambda callback
     */
    protected static final Lambda<Callable> thread = new Lambda() {
        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length > 2) {
                return false;
            }
            return true;
        }

        @Override
        protected Callable evaluate(Callable... args) {
            if (args.length == 2) {
                final Callable expression = args[0];
                final Callable callback = args[1];

                return new GuardianProxy(new RunnableResult() {
                    @Override
                    public void run() {
                        result = expression.call();
                        callback.call(result);
                    }
                }).start();
            } else {
                final Callable expression = args[0];

                return new GuardianProxy(new RunnableResult() {
                    @Override
                    public void run() {
                        result = expression.call();
                    }
                }).start();
            }
        }
    };
    /**
     * range(x,y) : [x...y] generate a list that is the range of values between
     * x and y (nb these indices are inclusive, so range(1,5) == [1,2,3,4,5])
     */
    protected static final Lambda<_List> range = new Lambda() {
        @Override
        protected _List evaluate(final Callable... args) {

            final _Number start = (_Number) args[0];
            final _Number end = (_Number) args[1];
            _List l = new _List();
            if (start.unwrap() < end.unwrap()) {
                //ascending list
                for (int i = start.unwrap().intValue(); i <= end.unwrap().intValue(); i++) {
                    l.add(new _Number(i));
                }
            } else {
                //descending list
                for (int i = start.unwrap().intValue(); i >= end.unwrap().intValue(); i--) {
                    l.add(new _Number(i));
                }
            }
            return l;

        }

        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Number)) {
                return false;
            }
            if (!(args[1] instanceof _Number)) {
                return false;
            }
            return true;
        }
    };
    /**
     * (value. modifier)::(modified_value, lambda) Where lambda will return
     * generator(modified_value, modifier)
     */
    protected static final Lambda<_List> generator = new Lambda() {
        @Override
        protected _List evaluate(final Callable... args) {
            final Callable initial_value = args[0];
            final Lambda modifier = (Lambda) args[1];
            final Callable new_value = modifier.call(initial_value);
            return new _List(
                    new_value,
                    new Lambda<_List>() {
                @Override
                protected boolean validateArgs(final Callable... args) {
                    if (args.length != 2) {
                        return false;
                    }
                    if (!(args[1] instanceof Lambda)) {
                        return false;
                    }
                    return true;
                }

                @Override
                protected _List evaluate(final Callable... args) {
                    return generator.call(new_value, modifier).call();
                }
            });
        }

        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[1] instanceof Lambda)) {
                return false;
            }
            return true;
        }
    };
    /**
     * length(list) return the length of a list
     */
    protected static final Lambda<_Number> length = new Lambda() {
        @Override
        protected boolean validateArgs(final Callable... args) {
            if (args.length != 1) {
                return false;
            }
            if (!(args[0] instanceof _List)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Number evaluate(final Callable... args) {
            final _List l = (_List) args[0];
            return new _Number(l.size());
        }
    };
    protected static final Lambda<_Boolean> and = new Lambda() {
        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Boolean)) {
                return false;
            }
            if (!(args[1] instanceof _Boolean)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Boolean evaluate(Callable... args) {
            final _Boolean b1 = (_Boolean) args[0];
            final _Boolean b2 = (_Boolean) args[1];
            return new _Boolean(b1.unwrap() && b2.unwrap());
        }
    };
    protected static final Lambda<_Boolean> or = new Lambda() {
        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Boolean)) {
                return false;
            }
            if (!(args[1] instanceof _Boolean)) {
                return false;
            }
            return true;
        }

        @Override
        protected _Boolean evaluate(Callable... args) {
            final _Boolean b1 = (_Boolean) args[0];
            final _Boolean b2 = (_Boolean) args[1];
            return new _Boolean(b1.unwrap() || b2.unwrap());
        }
    };
    protected static final Lambda<_Boolean> not = new Lambda() {
        @Override
        protected boolean validateArgs(Callable... args) {
            if (args.length != 2) {
                return false;
            }
            if (!(args[0] instanceof _Boolean)) {
                return false;
            }
            return true;
        }

        @Override
        protected Callable evaluate(Callable... args) {
            final _Boolean b1 = (_Boolean) args[0];
            return new _Boolean(!b1.unwrap());
        }
    };
    /**
     * (x,y) :: x>y Return a _Boolean value to assert if the first arg is
     * numerically higher than the second.
     */
    protected static final Lambda gtr_than = new Lambda() {
        @Override
        protected final Callable evaluate(final Callable... args) {

                return new _Boolean(((_Number) args[0]).unwrap() > ((_Number) args[1]).unwrap());

        }
    };
    /**
     * (x,y) :: x<y Return a _Boolean value to assert if the first arg is
     * numerically lower than the second.
     */
    protected static final Lambda less_than = new Lambda() {
        @Override
        protected final Callable evaluate(final Callable... args) {
                return new _Boolean(((_Number) args[0]).unwrap() < ((_Number) args[1]).unwrap());
        }
    };
    
    /**
     * Given (List, initialString), return a string representation of the evaluated list.
     * This blocks until ready.
     */
    public final static Lambda listToStr = new Lambda() {
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
                            return listToStr.call(T, str_cat.call(new _String("["), H));
                        }

                        @Override
                        public final Callable onElse() {
                            return listToStr.call(T, str_cat.call(str_result, new _String(","), H));
                        }
                    }.call();
                }
            }.call();
        }
    };
    
}

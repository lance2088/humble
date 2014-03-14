package humble.runtime.monads;

import humble.primitives._List;
import humble.runtime.Callable;
import humble.runtime.Lambda;
import humble.runtime.Module;


/**
 * A generic library implementation of the state monad
 *
 * @author nickpeck
 */
public class State extends Module {

    public final static Lambda raise = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
        
                final Callable value = args[0];
                return new _List(value, new _List());

        }
    };
    public final static Lambda call = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
        
                final Callable value = ((_List) args[0]).get(0);
                final Callable states = ((_List) args[0]).get(1);
                //System.out.println("-------------------");
                //System.out.println("states = " + yield(states));
                final Callable modifier = args[1];
                //System.out.println("modifier = " + modifier);
                Callable newValue = modifier.call(value);
                //System.out.println("newvalue = " + yield(newValue));
                //System.out.println("newvalue = " + yield(newValue));
                Callable newStates = push.call(states, value);
                //System.out.println("newstates = " + yield(newStates));
                _List result = new _List(newValue, newStates);
                //System.out.println("result = " + result);
                return result;
   
        }
    };
    public final static Lambda rollback = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
          
                //final Callable value = ((_List) args[0]).get(0);
                final Callable states = ((_List) args[0]).get(1);
                return new _List(list_head.call(states), list_tail.call(states));
  
        }
    };
    public final static Lambda get_value = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
         
                final Callable value = ((_List) args[0]).get(0);
                //final Callable states = ((_List) args[0]).get(1);
                return value;
    
        }
    };

    @Override
    public Callable call(Callable... args) {
        return this;
    }
}
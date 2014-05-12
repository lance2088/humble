package humble.primitives;

import humble.runtime.Callable;
import humble.runtime.Wrappable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Functional wrapper for a typed List
 * @author nickpeck
 */
public class _List extends LinkedList<Callable> 
    implements Callable, Wrappable<LinkedList<Callable>> {
   
    public _List(final Callable... args) {
        addAll(Arrays.asList(args));
    }
    
    public _List(final List<Callable> l){
        addAll(l);
    }
    
    @Override
    public Callable call(final Callable... args) {
        return this;
    }

    @Override
    public Callable bindTo(final Callable a) {
        return a.call(this);
    }

    @Override
    public LinkedList<Callable> unwrap() {
        return (LinkedList)this;
    }
    
    @Override
    public String toString(){
        //override the default Java representation with something more meaningfull
        StringBuilder res = new StringBuilder("[");
        for(int i=0; i<size(); i++){
            res.append(get(i));
            if(i != (size()-1)) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
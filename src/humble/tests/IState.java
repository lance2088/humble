package humble.tests;

import humble.primitives._List;
import humble.runtime.Callable;
import humble.runtime.Lambda;

/**
 * An interface to make functions from the State module accessible in 
 * external Java code
 *
 * @author nickpeck
 */
public interface IState {
    
    _List raise(Callable value);
    
    _List call(_List writer, Lambda modifier);
    
    _List rollback(_List state);
  
    Callable get_value(_List state);
}

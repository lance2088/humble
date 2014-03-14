package humble.tests;

import humble.primitives._List;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.Lambda;


/**
 * An interface to make functions from the Writer module accessible in 
 * external Java code
 *
 * @author nickpeck
 */
public interface IWriter  {
    
    _List raise(Callable value);
    
    _List call(_List writer, Lambda modifier, _String log_msg);
    
    _String get_log(_List writer);
  
    Callable get_value(_List writer);
   
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.runtime;

/**
 * abstract implementation of the runnable interface that allows for
 * storing the result of action in the thread.
 * @author nickpeck
 */
public abstract class RunnableResult<T extends Callable> implements Runnable {
    
    protected T result;
    
    public T getResult(){
        return result;
    }
    
}
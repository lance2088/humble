package humble.runtime;

/**
 * Guards the result of a long running thread until it has completed.
 * @author nickpeck
 */
public class GuardianProxy<T extends Callable> extends StdLib implements Callable<T> {

    private RunnableResult<T> ward;
    private Thread t;
    
    public GuardianProxy(RunnableResult<T> r) {
        ward = r;
    }
    
    public GuardianProxy start(){
        t = new Thread(ward);
        t.start();
        return this;
    }
    
    @Override
    public T call(Callable... args) {

        while(t.isAlive()) {
            //block until its ready
        }
        return ward.getResult();
    }
    
    @Override
    public String toString(){
        return this.call().toString();
    }

    @Override
    public Callable bindTo(Callable c) {
        return c.call(this);
    }
    
}
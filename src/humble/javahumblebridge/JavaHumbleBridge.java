package humble.javahumblebridge;

import humble.runtime.Callable;
import humble.runtime.FuturePromise;
import humble.runtime.Lambda;
import humble.runtime.Module;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy class to map the calls to an instance of interface I to Module M.
 * This makes it easy to reference Humble code from within a Java application.
 * @author nickpeck
 */
public class JavaHumbleBridge<I, M extends Module> {

    private final Class<I> iface;
    private final Class<M> module;
    
    /**
     * Internally, translate calls to our interface to the appropriate members
     * of our Humble module.
     */
    private InvocationHandler handler = new InvocationHandler() {
        
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Field field = module.getDeclaredField(method.getName());//find a lambda function in M with
            //identical name
            Callable result =  (Callable)field.get(module);
            //re-cast the array of args to Atoms
            //TODO a nice feature might be auto casting of Java types to relative
            //Humble wrapper types
            Callable[] atomArgs = new Callable[args.length];
            for (int i = 0; i < args.length; i++) {
                atomArgs[i] = (Callable) args[i];
            }
            while (result instanceof FuturePromise) {
                result = result.call();
            }
            return result.call(atomArgs);
        }
    };

    /**
     * 
     * @param iface a defined interface that defines the accessible functions of a 
     * Humble module
     * @param module a class instance of the Humble module to be mapped to
     */
    public JavaHumbleBridge(Class<I> iface, Class<M> module) {
        this.iface = iface;
        this.module = module;
    }

    /**
     * @return a proxy class of type I that delegates calls to the interface supplied to
     * the constructor to the relevant humble module M as supplied to the constructor
     */
    public I getBridge() {
        I bridge = (I) Proxy.newProxyInstance(module.getClassLoader(),
                new Class[]{iface},
                handler);

        return bridge;
    }
}

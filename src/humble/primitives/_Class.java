package humble.primitives;

import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Primitive;
import humble.runtime.Wrappable;
import humble.runtime._Exception;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nickpeck
 */
public class _Class<T extends Callable>extends Primitive {

    private Class c;
    
    public _Class(Class c) {
        super(c);
        this.c = c;
    }

    /**
     * Type objects have an interesting callable property. 'Calling' a type
     * returns an instance of type T eg new
     * _Class<_String>(_JavaClassWrapper<String.class).call("Hello world") is equivalent to new
     * _String("hello world");
     *
     * @param args
     * @return instance of type t.
     */
    @Override
    public T call(Callable... args) {

        T value = null;
        Constructor<T>[] constructors = c.getDeclaredConstructors();
        //todo unwrap the args into Java types and find out which one works...
        System.out.println("\n\nFound " + constructors.length + " constructors for class " + c);
        ArrayList argsList = new ArrayList();
        argsList.add(c);
        for (Callable arg : args) {
            if (arg instanceof Wrappable) {
                Wrappable w = (Wrappable) arg;
                argsList.add(w.unwrap());
            } else {
                argsList.add(arg);
            }
        }
        for (Constructor<T> constructor : constructors) {
            System.out.println("-----" + constructor.toGenericString());
            Type[] types = constructor.getGenericParameterTypes();
            if (types.length != argsList.size()) {
                System.out.println("Params lists are not equal , ignoring " + types.length + " " + argsList.size());
                continue;
            }
            System.out.println("This constructor has the same number of args as those supplied");
            //compare the declared types of each constructor against the args list
            boolean matchResult = true;
            Class enclosingClass = c.getEnclosingClass();
            if (enclosingClass != null) {
                Object enclosingClassInstance;
                try {
                    enclosingClassInstance = enclosingClass.newInstance();
                    argsList.set(0, enclosingClassInstance);
                } catch (        InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(_Class.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            for (int i = 0; i < argsList.size(); i++) {
                System.out.println("Comparing required" + types[i] + " with  given " + argsList.get(i).getClass());
                if (!(argsList.get(i).getClass() == types[i])) {
                    matchResult = false;
                }
            }
            if (matchResult) {
                //this is the correct constructor.
                System.out.println("This is the matching constructor");


                constructor.setAccessible(true);
                //argsList.set(0, new ClassTest());
                System.out.println(argsList.size());
                try {
                    value = (T) constructor.newInstance(argsList.toArray());
                } catch (        InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(_Class.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(value);
                //return a new primitive, in which the call() function is in fact a proxy
                //to the wrapped type...
            }
        }

        return value;
    }
}
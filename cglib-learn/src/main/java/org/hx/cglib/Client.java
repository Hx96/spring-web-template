package org.hx.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

import java.sql.PreparedStatement;

import static org.junit.Assert.assertEquals;

// https://www.baeldung.com/cglib
public class Client {
    public static void main(String[] args) {
        cglib1();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, args1);
            }
        });

        PersonService proxy = (PersonService) enhancer.create();

        assertEquals("Hello Tom!", proxy.sayHello(null));
        int lengthOfName = proxy.lengthOfName("Mary");

        assertEquals(4, lengthOfName);
    }

    private static void cglib1() {
        PreparedStatement preparedStatement;
//        preparedStatement.setObject();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);

        assertEquals("Hello Tom!", res);
    }


}

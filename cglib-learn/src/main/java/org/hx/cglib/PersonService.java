package org.hx.cglib;

public class PersonService {
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(@org.jetbrains.annotations.NotNull String name) {
        return name.length();
    }
}

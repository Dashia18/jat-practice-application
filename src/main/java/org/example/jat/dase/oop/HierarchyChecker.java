package org.example.jat.dase.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
1. Analyze the hierarchy of classes and the code. Will the code be compiled and running?
A->B->C (Class A is a parent of Class B, Class B is a parent of Class C)

public class Test {
public static void main(String[] args) {
    A ab = new B();
    A ac = new C();
    C cb = (C) new B();
}
}
 */

public class HierarchyChecker {
    private static final Logger log = LoggerFactory.getLogger(HierarchyChecker.class);

    public static void main(String[] args) {
        A ab = new B();
        log.info("'A ab = new B()' This line is valid. A reference of type A can point to an instance of B " +
                "because B is a subclass of A, ab: {}", ab);

        A ac = new C();
        log.info("'A ac = new C()' This line is also valid. A reference of type A can point to an instance of C " +
                "because C is a subclass of A (through B), ac: {}", ac);

        //C cb = (C) new B();
        log.info("'C cb = (C) new B()' This line will compile because Java allows casting between related types. " +
                "However, it will throw a ClassCastException at runtime because new B() creates an instance of B, " +
                "which cannot be cast to C. B is not a subclass of C, but rather a superclass");
    }

    @Data
    public static class A {
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class B extends A {
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class C extends B {
    }
}

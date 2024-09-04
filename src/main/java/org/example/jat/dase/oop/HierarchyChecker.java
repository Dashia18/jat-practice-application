package org.example.jat.dase.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
1. Analyze the hierarchy of classes and the code. Will the code be compiled and running?
*/

public class HierarchyChecker {
    private static final Logger log = LoggerFactory.getLogger(HierarchyChecker.class);

    public static void main(String[] args) {
        A ab = new B();
        log.info("'A ab = new B()' This line is valid. Compiled and run successfully. " +
                "A reference of type A can point to an instance of B because B is a subclass of A, ab: {}", ab);

        A ac = new C();
        log.info("'A ac = new C()' This line is also valid. Compiled and run successfully. " +
                "A reference of type A can point to an instance of C " +
                "because C is a subclass of A (through B), ac: {}", ac);

        //C cb = (C) new B();
        log.info("'C cb = (C) new B()' This line will compile because Java allows casting between related types. " +
                "However, it will throw a ClassCastException at runtime because new B() creates an instance of B, " +
                "which cannot be cast to C. B is not a subclass of C, but rather a superclass");

        log.info("Corrected version: Ensure the object is an instance of C before casting");
        B b = new C();
        log.info("'B b = new C()' is valid because C is a subclass of B");
        if (b instanceof C) {
            C cb = (C) b;
            log.info("Safe to cast because 'b' is confirmed to be an instance of C, cb: {}", cb);
        }
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

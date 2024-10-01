package org.example.jat.dase.oop;

/*
3. Analyze the code and explain which of the methods will run

Answer:

Overloading Resolution Rules
Exact Match: If there is a method that exactly matches the argument type, it will be chosen.
Subtype Match: If there is no exact match,
                the compiler will look for a method where the argument type is a subtype of the parameter type.
Most Specific Method: If multiple methods can accept the argument,
                        the most specific method (the one with the most specific parameter type) will be chosen.

Applying the Rules
Exact Match: There is no exact match for null because null can be assigned to any reference type.
Subtype Match: Both Object and String can accept null as an argument. However, String is a subclass of Object.
Most Specific Method: Since String is more specific than Object,
                        the method with the String parameter is considered more specific.

Therefore, the method1(String o) method will be invoked.
 */
public class MethodRunChecker {
    public static void main(String[] args) {
        MethodRunChecker t1= new MethodRunChecker();
        t1.method1(null);
    }
    public void method1(Object o) {
        System.out.println("object call");
    }

    public void method1(String o) {
        System.out.println("String call");
    }
}

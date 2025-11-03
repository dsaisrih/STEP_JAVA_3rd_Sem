// File: com/company/extended/ExtendedDemo.java
package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int p, String d, double pr, boolean pub) {
        super(p, d, pr, pub);
    }

    public void testInheritedAccess() {
        // Public accessible
        System.out.println(publicField);
        publicMethod();

        // Protected accessible (because subclass)
        System.out.println(protectedField);
        protectedMethod();

        // ❌ Default not accessible (different package)
        // System.out.println(defaultField);
        // defaultMethod();

        // ❌ Private not inherited
        // System.out.println(privateField);
        // privateMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden Protected method called in ExtendedDemo");
    }

    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(1, "X", 2.2, true);
        child.testInheritedAccess();

        AccessModifierDemo parent = new AccessModifierDemo(2, "Y", 3.3, false);
        parent.publicMethod(); // only public
        // parent.protectedMethod(); ❌ (not accessible directly outside subclass)
    }
}

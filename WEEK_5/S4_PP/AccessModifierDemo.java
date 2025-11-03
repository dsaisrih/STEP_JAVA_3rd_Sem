// File: com/company/security/AccessModifierDemo.java
// File: com/company/main/PackageTestMain.java
package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(30, "Cross", 55.5, true);

        // Accessible
        System.out.println(obj.publicField);
        obj.publicMethod();

        // ❌ Not accessible across package without inheritance
        // System.out.println(obj.defaultField);
        // obj.defaultMethod();

        // ❌ Protected also not accessible through object in different package
        // System.out.println(obj.protectedField);
        // obj.protectedMethod();

        // ❌ Private never accessible
    }
}

package com.company.security;

public class AccessModifierDemo {
    // Fields with different access modifiers
    private int privateField;
    String defaultField; // package-private
    protected double protectedField;
    public boolean publicField;

    // Constructor
    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    // Methods with different access levels
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Test internal access
    public void testInternalAccess() {
        System.out.println("PrivateField: " + privateField);
        System.out.println("DefaultField: " + defaultField);
        System.out.println("ProtectedField: " + protectedField);
        System.out.println("PublicField: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.9, true);

        // Accessible
        System.out.println(obj.publicField);
        obj.publicMethod();

        // Accessible (same package, but here it's same class so all work)
        System.out.println(obj.defaultField);
        obj.defaultMethod();

        System.out.println(obj.protectedField);
        obj.protectedMethod();

        // Not accessible outside this class → would cause error if tried externally
        // System.out.println(obj.privateField); ❌
        // obj.privateMethod(); ❌

        obj.testInternalAccess();
    }
}

// Second class in SAME package
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(20, "World", 77.7, false);

        // Accessible
        System.out.println(obj.publicField);
        obj.publicMethod();

        // Accessible (same package)
        System.out.println(obj.defaultField);
        obj.defaultMethod();

        System.out.println(obj.protectedField);
        obj.protectedMethod();

        // ❌ Private not accessible
        // System.out.println(obj.privateField);
        // obj.privateMethod();
    }
}

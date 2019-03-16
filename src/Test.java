/**
 * @author Daniel
 * @title: Test
 * @description: TODO
 * @date 2019-03-12 23:54
 */
public class Test {
    public static void main(String args[]) {
        new B();
    }
}

class A {
    public A() {
        System.out.println("I am A");
    }

    {
        System.out.println("A");
    }

    static {
        System.out.println("static A");
    }
}

class B extends A {
    public B() {
        System.out.println("I am B");
    }

    {
        System.out.println("B");
    }

    static {
        System.out.println("static B");
    }
}
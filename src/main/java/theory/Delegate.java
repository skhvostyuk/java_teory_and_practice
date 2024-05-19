package theory;

import java.util.function.Function;

public class Delegate {
    static void Meth(final Func1<A, B> SomeDelegate) {

    }

    public static void main(String[] args) {
        new C();
    }



    @FunctionalInterface
    public static interface Func1<TValue, TReturn> extends Function<TValue, TReturn>
    {
        TReturn invoke(TValue value);
        default TReturn apply(TValue t) { return invoke(t); }
    }

    static class A {

    }

    static class B{

    }
    static class C {

        static B StaticMeth(A a) {
            return new B();
        }
    }

}

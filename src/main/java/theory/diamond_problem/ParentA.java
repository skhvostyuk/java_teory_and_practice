package theory.diamond_problem;

public interface ParentA {//extends GrandParent{

    default void hello() {
        System.out.println("A");
    }
}

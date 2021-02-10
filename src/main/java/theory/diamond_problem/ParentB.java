package theory.diamond_problem;

public interface ParentB {//extends GrandParent{

    default void hello() {
        System.out.println("B");
    }
}

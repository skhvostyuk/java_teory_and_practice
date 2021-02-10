package theory.diamond_problem;

public interface GrandParent {
    default void hello() {
        System.out.println("Grand");
    }
}

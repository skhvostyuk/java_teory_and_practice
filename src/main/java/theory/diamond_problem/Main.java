package theory.diamond_problem;

import java.util.ArrayList;
import java.util.HashMap;

public class Main implements ParentA { //, ParentB{  //Не будет компилироваться

    public static void main(String[] args) {
        new ArrayList<>().stream().forEach(s -> System.out.println(""));
        HashMap<String, String> map = new HashMap<>();
        map.put("fff", "aaa");
        new Main().hello();
    }
}

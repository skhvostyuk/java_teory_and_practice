package tests;

import java.util.UUID;

public class UUID_Generator {

    public static void main(String[] args) {
        for(int i = 0; i < 11; i++) {
            System.out.println(i + 1 +  "     " + UUID.randomUUID().toString());
        }
    }
}

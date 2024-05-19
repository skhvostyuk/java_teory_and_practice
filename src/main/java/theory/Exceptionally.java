package theory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exceptionally {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String ans = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException();
        })
                .thenCompose(a -> CompletableFuture.completedStage("do some stuff"))
        //        .exceptionally(e -> "exception")
                .whenComplete((answer, ex) -> System.out.println(answer + " " + ex))
                .get();

        System.out.println(ans);
    }

}

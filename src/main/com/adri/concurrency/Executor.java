package com.adri.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {

    public String execute(int executionWaitMs) {
        var executor = Executors.newSingleThreadExecutor();

        Future<String> result = executor.submit(() -> {
            wait(executionWaitMs);
            return "done";
        });

        try {
            if (result.isDone()) {
                return result.get();
            }
            else {
                return "not done";
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return "error";
        }
    }
}

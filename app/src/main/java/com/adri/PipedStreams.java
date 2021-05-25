package com.adri;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedStreams {
    public static void main(String[] args) throws IOException, InterruptedException {
        var executor = Executors.newFixedThreadPool(2);

        var output = new PipedOutputStream();
        var input = new PipedInputStream(output);

        executor.submit(() -> {
            for (int i = 65; i < 91; i++) {
                try {
                    System.out.println("Producing: \t" + (char) i);
                    output.write(i);
                    System.out.println("Produced: \t" + (char) i);
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                int oneCharAsInt;
                while ((oneCharAsInt = input.read()) != -1) {
                    final char oneChar = (char) oneCharAsInt;
                    System.out.println("Consumed: \t" + oneChar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Done consuming");
        });

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.exit(0);
    }
}

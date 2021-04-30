package com.adri.generics;

import java.util.function.Consumer;

public class GenericConsumer<T extends Message> {

    public GenericConsumer(Consumer<T.Builder> builderConsumer) {
    }
}

package com.adri.generics;

public class GenericsFactory extends GenericClass<String, FooMessage> {

    public GenericsFactory() {
        super(new GenericConsumer<FooMessage>((FooMessage.Builder builder) -> builder.build()));
    }
}

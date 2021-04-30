package com.adri.generics;

public abstract class GenericClass<B, T extends Message> {

    public GenericClass(GenericConsumer<T> snapshotRepository) {
    }
}

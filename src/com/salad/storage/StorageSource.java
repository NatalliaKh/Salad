package com.salad.storage;

public interface StorageSource {
    int getTomatoAmount();
    int getCucumberAmount();
    int getPepperAmount();
    void cleanUp();
}

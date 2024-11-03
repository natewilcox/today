package io.natewilcox;

public interface Consumer {
    void process(String type, String message);
}

package com.example.javaspringtest.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

public class AtomicTest {

    private static final AtomicLong count = new AtomicLong(0L);

    @Test
    void incrementTest() {
        long incrementNumber = count.incrementAndGet();
        assertThat(incrementNumber).isEqualTo(1);
    }
}

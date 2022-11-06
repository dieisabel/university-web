package com.lab2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TabulationServiceTest {
    private TabulationService service;

    private final double a = 1.5;
    private final double eps = 1e-3;
    private final double start = 0.8;
    private final double end = 2.0;
    private final double step = 0.005;

    @Before
    public void setUp() {
        this.service = new TabulationService();
    }

    @Test
    public void test_calculateFunction_ifXIsLessThan() {
        double expected = -0.337;
        double actual = service.calculateFunction(1.2, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateFunction_ifXIsEqual() {
        double expected = 16.496;
        double actual = service.calculateFunction(1.7, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateFunction_ifXIsMoreThan() {
        double expected = 1.062;
        double actual = service.calculateFunction(1.9, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateSteps() {
        int expected = 241;
        int actual = service.calculateSteps(start, end, step);
        assertEquals(expected, actual);
    }

    @Test
    public void test_createXArray() {
        int size = service.calculateSteps(start, end, step);
        double expectedValueAt0 = 0.8;
        double expectedValueAt180 = 1.7;
        double expectedValueAt240 = 2.0;
        double[] array = service.createXArray(size, start, step);
        assertEquals(expectedValueAt0, array[0], eps);
        assertEquals(expectedValueAt180, array[180], eps);
        assertEquals(expectedValueAt240, array[240], eps);
    }

    @Test
    public void test_createYArray() {
        int size = service.calculateSteps(start, end, step);
        double expectedValueAt0 = -8.926;
        double expectedValueAt180 = 16.496;
        double expectedValueAt240 = 1.0755;
        double[] array = service.createYArray(size, start, step, a, eps);
        assertEquals(expectedValueAt0, array[0], eps);
        assertEquals(expectedValueAt180, array[180], eps);
        assertEquals(expectedValueAt240, array[240], eps);
    }

    @Test
    public void test_min() {
        int size = service.calculateSteps(start, end, step);
        double[] array = service.createYArray(size, start, step, a, eps);
        int expected = 0;
        int actual = service.min(array);
        assertEquals(expected, actual);
    }
}

package com.lab2.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.lab2.Config;

public class CalculatorImplTest {
    private Calculator calculator;

    private final double a = Config.A;
    private final double eps = Config.EPS;
    private final double start = 0.8;
    private final double end = 2.0;
    private final double step = 0.005;

    @Before
    public void setUp() {
        this.calculator = new CalculatorImpl();
    }

    @Test
    public void test_calculateFunction_ifXIsLessThan() {
        double expected = -0.337;
        double actual = calculator.calculateFunction(1.2, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateFunction_ifXIsEqual() {
        double expected = 16.496;
        double actual = calculator.calculateFunction(1.7, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateFunction_ifXIsMoreThan() {
        double expected = 1.062;
        double actual = calculator.calculateFunction(1.9, a, eps);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_calculateSteps() {
        int expected = 241;
        int actual = calculator.calculateSteps(start, end, step);
        assertEquals(expected, actual);
    }

    @Test
    public void test_createXArray() {
        int size = calculator.calculateSteps(start, end, step);
        double expectedValueAt0 = 0.8;
        double expectedValueAt180 = 1.7;
        double expectedValueAt240 = 2.0;
        double[] array = calculator.createXArray(size, start, step);
        assertEquals(expectedValueAt0, array[0], eps);
        assertEquals(expectedValueAt180, array[180], eps);
        assertEquals(expectedValueAt240, array[240], eps);
    }

    @Test
    public void test_createYArray() {
        int size = calculator.calculateSteps(start, end, step);
        double expectedValueAt0 = -8.926;
        double expectedValueAt180 = 16.496;
        double expectedValueAt240 = 1.0755;
        double[] array = calculator.createYArray(size, start, step, a, eps);
        assertEquals(expectedValueAt0, array[0], eps);
        assertEquals(expectedValueAt180, array[180], eps);
        assertEquals(expectedValueAt240, array[240], eps);
    }

    @Test
    public void test_min() {
        int size = calculator.calculateSteps(start, end, step);
        double[] array = calculator.createYArray(size, start, step, a, eps);
        int expected = 0;
        int actual = calculator.min(array);
        assertEquals(expected, actual);
    }

    @Test
    public void test_max() {
        int size = calculator.calculateSteps(start, end, step);
        double[] array = calculator.createYArray(size, start, step, a, eps);
        int expected = 180;
        int actual = calculator.max(array);
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum() {
        int size = calculator.calculateSteps(start, end, step);
        double[] array = calculator.createYArray(size, start, step, a, eps);
        double expected = 67.322;
        double actual = calculator.sum(array);
        assertEquals(expected, actual, eps);
    }

    @Test
    public void test_mean() {
        int size = calculator.calculateSteps(start, end, step);
        double[] array = calculator.createYArray(size, start, step, a, eps);
        double expected = 0.279;
        double actual = calculator.mean(array);
        assertEquals(expected, actual, eps);
    }
}

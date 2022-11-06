package com.lab2;

public class TabulationService {
    public double calculateFunction(double x, double a, double eps) {
        if (x < 1.7 - eps) {
            return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        }
        if (x > 1.7 + eps) {
            return Math.log10(x + 7 * Math.sqrt(x));
        }
        return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
    }

    public int calculateSteps(double start, double end, double step) {
        return (int) ((end - start) / step + 1);
    }

    public double[] createXArray(int size, double start, double step) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = start + i * step;
        }
        return array;
    }

    public double[] createYArray(int size, double start, double step, double a, double eps) {
        double[] array = new double[size];
        double x;
        for (int i = 0; i < size; i++) {
            x = start + i * step;
            array[i] = calculateFunction(x, a, eps);
        }
        return array;
    }
    
    public int min(double[] array) {
        double minElement = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    public int max(double[] array) {
        double minElement = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

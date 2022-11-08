package com.lab2.calculator;

public interface Calculator {
    double calculateFunction(double x, double a, double eps);
    int calculateSteps(double start, double end, double step);
    double[] createXArray(int size, double start, double step);
    double[] createYArray(int size, double start, double step, double a, double eps);
    int min(double[] array);
    int max(double[] array);
    double sum(double[] array);
    double mean(double[] array);
}

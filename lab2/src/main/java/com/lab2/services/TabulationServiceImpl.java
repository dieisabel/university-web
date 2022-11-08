package com.lab2.services;

import com.lab2.dtos.TabulationData;
import com.lab2.calculator.Calculator;
import com.lab2.calculator.CalculatorImpl;
import com.lab2.Config;

public class TabulationServiceImpl implements TabulationService {
    private final Calculator calculator;

    public TabulationServiceImpl() {
        calculator = new CalculatorImpl();
    }

    public TabulationData tabulate(double start, double end, double step) {
        int steps = calculator.calculateSteps(start, end, step);
        double[] xArray = calculator.createXArray(steps, start, step);
        double[] yArray = calculator.createYArray(steps, start, step, Config.A, Config.EPS);
        int minIndex = calculator.min(yArray);
        int maxIndex = calculator.max(yArray);
        double minElement = yArray[minIndex];
        double maxElement = yArray[maxIndex];
        double sum = calculator.sum(yArray);
        double mean = calculator.mean(yArray);

        TabulationData data = new TabulationData();
        data.start = start;
        data.end = end;
        data.step = step;
        data.steps = steps;
        data.xArray = xArray;
        data.yArray = yArray;
        data.minIndex = minIndex;
        data.maxIndex = maxIndex;
        data.minElement = minElement;
        data.maxElement = maxElement;
        data.sum = sum;
        data.mean = mean;
        return data;
    }
}

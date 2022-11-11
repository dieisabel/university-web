package com.lab2.services;

import com.lab2.dtos.Pair;
import com.lab2.dtos.TabulationData;
import com.lab2.calculator.Calculator;
import com.lab2.calculator.CalculatorImpl;
import com.lab2.Config;
import com.lab2.dtos.TabulationInput;

import java.util.ArrayList;
import java.util.List;;

public class TabulationServiceImpl implements TabulationService {
    private final Calculator calculator;

    public TabulationServiceImpl() {
        calculator = new CalculatorImpl();
    }

    public TabulationData tabulate(TabulationInput input) {
        int steps = calculator.calculateSteps(input.getStart(), input.getEnd(), input.getStep());
        double[] xArray = calculator.createXArray(steps, input.getStart(), input.getStep());
        double[] yArray = calculator.createYArray(steps, input.getStart(), input.getStep(), Config.A, Config.EPS);
        int minIndex = calculator.min(yArray);
        int maxIndex = calculator.max(yArray);
        List<Pair> pairs = convertArraysToPairs(xArray, yArray);
        return new TabulationData(
                input.getStart(),
                input.getEnd(),
                input.getStep(),
                steps,
                pairs,
                minIndex,
                maxIndex,
                yArray[minIndex],
                yArray[maxIndex],
                calculator.sum(yArray),
                calculator.mean(yArray)
        );
    }

    private List<Pair> convertArraysToPairs(double[] xArray, double[] yArray) {
        List<Pair> result = new ArrayList<>();
        for (double x : xArray) {
            for (double y : yArray) {
                result.add(new Pair(x, y));
            }
        }
        return result;
    }
}

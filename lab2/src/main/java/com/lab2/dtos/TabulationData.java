package com.lab2.dtos;

import java.util.List;

public class TabulationData {
    private double start;
    private double end;
    private double step;
    private int steps;
    private List<Pair> pairs;
    private int minIndex;
    private int maxIndex;
    private double minElement;
    private double maxElement;
    private double sum;
    private double mean;

    public TabulationData(
            double start,
            double end,
            double step,
            int steps,
            List<Pair> pairs,
            int minIndex,
            int maxIndex,
            double minElement,
            double maxElement,
            double sum,
            double mean
    ) {
        this.start = start;
        this.end = end;
        this.step = step;
        this.steps = steps;
        this.pairs = pairs;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.minElement = minElement;
        this.maxElement = maxElement;
        this.sum = sum;
        this.mean = mean;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public double getMinElement() {
        return minElement;
    }

    public void setMinElement(double minElement) {
        this.minElement = minElement;
    }

    public double getMaxElement() {
        return maxElement;
    }

    public void setMaxElement(double maxElement) {
        this.maxElement = maxElement;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }
}

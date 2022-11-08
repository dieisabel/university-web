package com.lab2;

import com.lab2.services.TabulationService;
import com.lab2.services.TabulationServiceImpl;

public class Main {
    public static void main(String[] args) {
        TabulationService service = new TabulationServiceImpl();
        double start = 0.8;
        double end = 2.0;
        double step = 0.005;

        System.out.println(service.tabulate(start, end, step).steps);
    }
}

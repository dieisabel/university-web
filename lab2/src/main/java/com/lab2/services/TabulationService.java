package com.lab2.services;

import com.lab2.dtos.TabulationData;

public interface TabulationService {
    TabulationData tabulate(double start, double end, double step);
}

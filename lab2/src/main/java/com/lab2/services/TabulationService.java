package com.lab2.services;

import com.lab2.dtos.TabulationData;
import com.lab2.dtos.TabulationInput;

public interface TabulationService {
    TabulationData tabulate(TabulationInput input);
}

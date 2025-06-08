package com.hari.cloud.service;

import com.hari.cloud.dto.MobilesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineMobilesService {

    public List<MobilesDto> getMobileDetails() {
        return List.of(
                new MobilesDto("Oneplus", "9RT", "Black", 999.99),
                new MobilesDto("Vivo", "T3X", "White", 799.99),
                new MobilesDto("Iqoo", "neo", "Blue", 599.99)
        );
    }
}

package com.hari.cloud.service;

import com.hari.cloud.dto.MobilesDto;
import com.hari.cloud.exceptions.ResourceNotFoundException;
import com.hari.cloud.repository.OnlineMobilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineMobilesService {


    /**
     * MongoDB repository for managing mobile details.
     */
    @Autowired
    private OnlineMobilesRepository onlineMobilesRepository;

    public List<MobilesDto> getMobileDetails() {
        return List.of(
                new MobilesDto("Oneplus", "9RT", "Black", 999.99),
                new MobilesDto("Vivo", "T3X", "White", 799.99),
                new MobilesDto("Iqoo", "neo", "Blue", 599.99)
        );
    }

    public MobilesDto saveMobileDetails(MobilesDto mobiles) {
       return onlineMobilesRepository.save(mobiles);
    }

    public List<MobilesDto> getMobiles() {
        return onlineMobilesRepository.findAll();
    }

    public MobilesDto getMobileById(Long id)  {
        return onlineMobilesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mobile not found with id: " + id));
    }


    public MobilesDto updateMobileDetails(MobilesDto mobilesDto) {
        MobilesDto existingMobile = getMobileById(mobilesDto.getId());
        existingMobile.setBrand(mobilesDto.getBrand());
        existingMobile.setModel(mobilesDto.getModel());
        existingMobile.setColor(mobilesDto.getColor());
        existingMobile.setPrice(mobilesDto.getPrice());
        return onlineMobilesRepository.save(existingMobile);
    }

    public MobilesDto deleteMobileById(Long id) {
        MobilesDto existingMobile = getMobileById(id);
        onlineMobilesRepository.delete(existingMobile);
        return existingMobile;
    }
}

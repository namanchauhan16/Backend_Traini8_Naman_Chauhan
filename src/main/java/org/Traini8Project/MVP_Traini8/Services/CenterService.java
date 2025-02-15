package org.Traini8Project.MVP_Traini8.Services;

import org.Traini8Project.MVP_Traini8.Entity.Center;
import org.Traini8Project.MVP_Traini8.Repositories.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

// Training Center Service class for business logic
@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    // Method to create and save a new center
    public Center createCenter(Center center){
        center.setCreatedOn(Instant.now().getEpochSecond());
        return centerRepository.save(center);
    }

    // Method to fetch all the centers present in database
    public List<Center> getAllCenters(){
        return centerRepository.findAll();
    }
}

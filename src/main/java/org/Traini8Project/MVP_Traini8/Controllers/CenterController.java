package org.Traini8Project.MVP_Traini8.Controllers;

import jakarta.validation.Valid;
import org.Traini8Project.MVP_Traini8.Entity.Center;
import org.Traini8Project.MVP_Traini8.Services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller to handle API requests
@RestController
@RequestMapping("/api/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;

    // API endpoint to create a new training center (http://localhost:8080/api/centers)
    @PostMapping
    public ResponseEntity<Center> createCenter(@Valid @RequestBody Center center){
        Center savedCenter = centerService.createCenter(center);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }

    // API endpoint to fetch all training centers (http://localhost:8080/api/centers)
    @GetMapping
    public  ResponseEntity<List<Center>> getAllCenters(){
        List<Center> allCenters = centerService.getAllCenters();
        return new ResponseEntity<>(allCenters, HttpStatus.OK);
    }
}

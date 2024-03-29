package com.example.MedInsightHub.user.controllers;


import com.example.MedInsightHub.user.dto.PatientDTO;
import com.example.MedInsightHub.user.dto.PatientProfileDTO;
import com.example.MedInsightHub.user.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/patient")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @PreAuthorize("hasAuthority('Doctor')")
    public List<PatientDTO> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping(path = "profile/{patient_id}")
    @PreAuthorize("hasAuthority('Doctor')")
    public PatientProfileDTO getPatientProfile(@PathVariable long patient_id){
        return patientService.getPatientProfile(patient_id);
    }
}

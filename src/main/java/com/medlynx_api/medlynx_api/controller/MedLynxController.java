package com.medlynx_api.medlynx_api.controller;

import com.medlynx_api.medlynx_api.dto.CreateMedLynxDTO;
import com.medlynx_api.medlynx_api.model.MedicationLegalModel;
import com.medlynx_api.medlynx_api.service.MedLynxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medlynx")
public class MedLynxController {
    @Autowired
    MedLynxService medLynxService;

    @PostMapping("/save")
    public ResponseEntity<Void> createMedication(@RequestBody CreateMedLynxDTO medication) {
        try {
            medLynxService.saveMedicationInfo(medication);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<MedicationLegalModel>> searchMedications(
            @RequestParam(required = false) Integer expediente,
            @RequestParam(required = false) Integer consecutivocum,
            @RequestParam(required = false) Integer cantidadcum) {

        try {
            List<MedicationLegalModel> medications = medLynxService
                    .findMedicationsByFilters(expediente, consecutivocum, cantidadcum);

            if (medications.isEmpty()) {
                System.out.println("No se encontraron medicaciones con los filtros indicados.");
                return ResponseEntity.noContent().build();
            }
            System.out.println("Se encontraron " + medications.size() + " medicaciones con los filtros indicados.");
            return ResponseEntity.ok(medications);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}

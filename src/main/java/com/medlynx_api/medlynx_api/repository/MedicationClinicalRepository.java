package com.medlynx_api.medlynx_api.repository;

import com.medlynx_api.medlynx_api.model.MedicationClinicalModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicationClinicalRepository extends MongoRepository<MedicationClinicalModel, String> {
}

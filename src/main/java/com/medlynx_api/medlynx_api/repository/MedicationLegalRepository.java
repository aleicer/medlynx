package com.medlynx_api.medlynx_api.repository;

import com.medlynx_api.medlynx_api.model.MedicationLegalModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicationLegalRepository extends MongoRepository<MedicationLegalModel, String> {
    List<MedicationLegalModel> findByExpedienteAndConsecutivocumAndCantidadcum(
            Integer expediente,
            Integer consecutivocum,
            Integer cantidadcum
    );
}

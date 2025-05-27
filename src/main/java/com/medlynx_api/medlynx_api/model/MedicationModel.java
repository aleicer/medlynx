package com.medlynx_api.medlynx_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medications")
public class MedicationModel {
    @Id
    private String _id;
    private String name;
    private String description;
    private String concentration;
    private float price;

    public MedicationModel() {}

    public MedicationModel(String id, String name, String description, String concentration, float price) {
        this._id = id;
        this.name = name;
        this.description = description;
        this.concentration = concentration;
        this.price = price;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getConcentration() {
//        return concentration;
//    }
//
//    public void setConcentration(String concentration) {
//        this.concentration = concentration;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public String getId() {
//        return _id;
//    }
//
//    public void setId(String id) {
//        this._id = id;
//    }
}

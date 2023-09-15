package ua.com.alevel.service;

import ua.com.alevel.db.PlantDb;
import ua.com.alevel.entity.Plant;

public class PlantService {

   private PlantDb plantDb = new PlantDb();

   public void create(String plantVariety, String namePlant, int age) {
       Plant plant = new Plant();
       plant.setPlantVariety(plantVariety);
       plant.setNamePlant(namePlant);
       plant.setAge(age);
       plantDb.create(plant);
   }
   public void delete(String plant){
       plantDb.delete(plant);
   }

   public Plant[] findAll() {
       return plantDb.findAll();
   }
}

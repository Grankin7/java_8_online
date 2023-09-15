package ua.com.alevel.db;

import ua.com.alevel.entity.Plant;

public class PlantDb {

    private Plant[] plants = new Plant[10];

    public void create(Plant plant) {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] == null) {
                plants[i] = plant;
                break;
            }
        }
    }
    public void delete(String delPlant) {
        for (int i = 0; i < plants.length; i++) {
            if(plants[i] != null && delPlant.equals(plants[i].getNamePlant()) ) {
                plants[i] = null;
                break;
            }
        }
    }

  public Plant[] findAll() {
        return plants;
  }

}

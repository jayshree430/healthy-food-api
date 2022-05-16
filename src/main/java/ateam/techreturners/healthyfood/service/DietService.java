package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.Diet;

import java.util.List;

public interface DietService {

    List<Diet> getAllDiets();
    Diet getDietById(Long id);
}

package com.kalyanov.service;

import com.kalyanov.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface Service {
    ArrayList<Car> getCarCount(int count);
    ArrayList<Car> getListCar();
}

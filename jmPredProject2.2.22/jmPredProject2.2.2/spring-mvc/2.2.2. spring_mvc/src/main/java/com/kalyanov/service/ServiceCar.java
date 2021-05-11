package com.kalyanov.service;

import com.kalyanov.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceCar implements Service {

    private ArrayList<Car> inputCar;

    {
        inputCar = new ArrayList<>();
        inputCar.add(new Car(1L,"mazda", "x5"));
        inputCar.add(new Car(2L,"bmw", "x5"));
        inputCar.add(new Car(3L,"mersedec", "c"));
        inputCar.add(new Car(4L,"toyotta", "mark2"));
        inputCar.add(new Car(5L,"maz", "x5"));
    }

     public ArrayList<Car> getListCar(){

         return inputCar;
    }


    @Override
    public ArrayList<Car> getCarCount(int count) {

        return (ArrayList<Car>) inputCar.stream().limit(count).collect(Collectors.toList());
    }
}

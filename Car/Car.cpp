#include "Car.h"

Car::Car(double capacity, double consumption, const Point& location, const std::string& model) {
    this->fuelAmount = 0;
    this->fuelCapacity = capacity;
    this->fuelConsumption = consumption;
    this->location = location;
    this->model = model;

}
Car::~Car() {

}


double Car::getFuelAmount() const {
    return this->fuelAmount;
}

double Car::getFuelCapacity() const {
    return this->fuelCapacity;
}

double Car::getFuelConsumption() const {
    return this->fuelConsumption;
}

const Point& Car::getLocation() const {
    return this->location;
}

const std::string& Car::getModel() const {
    return this->model;
}


void Car::drive(const Point& destination) {
    double newFuel = this->location.distance(destination) * fuelConsumption;

    if ( newFuel > fuelAmount ) {
        throw OutOfFuel();
    }
    fuelAmount -= newFuel;
    this->location = destination;
}

void Car::drive(double x, double y) {
    drive(Point(x, y));
}

void Car::refill(double fuel) {
    double newFuel = this->fuelAmount + fuel;

    if ( newFuel < fuelAmount ) {
        throw OutOfFuel();
    }
    if ( newFuel > fuel ) {     
        throw ToMuchFuel();
    }
    fuelAmount = newFuel;
}


std::ostream& operator<<(std::ostream& out, const Car& car) {
return out  << "Car: " << car.getModel()
            << "\n    Location: " << car.getLocation()
            << "\n    Fuel: " << car.getFuelAmount() << '/' << car.getFuelCapacity()
            << "\n    Consumption: " << car.getFuelConsumption() << std::endl;
}



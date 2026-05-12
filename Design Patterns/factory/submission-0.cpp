class Vehicle {
public:
    virtual string getType() = 0;
};

class Car : public Vehicle {
public:
    string getType() override {
        return "Car";
    }
};

class Bike : public Vehicle {
public:
    string getType() override {
        return "Bike";
    }
};

class Truck : public Vehicle {
public:
    string getType() override {
        return "Truck";
    }
};

class VehicleFactory {
public:
    virtual Vehicle* createVehicle() = 0;
};

class CarFactory : public VehicleFactory {
    Vehicle* createVehicle()override {
        Vehicle* car = new Car();
        return car;
    }
    // Write your code here
};

class BikeFactory : public VehicleFactory {
    Vehicle* createVehicle()override {
        Vehicle* bike = new Bike();
        return bike;
    }
    // Write your code here
};

class TruckFactory : public VehicleFactory {
    Vehicle* createVehicle()override {
        Vehicle* truck = new Truck();
        return truck;
    }
    // Write your code here
};

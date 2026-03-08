package java17.sealed;
public sealed class Vehicle permits Car {
}

sealed class Car extends  Vehicle permits Ford,Volvo{

}

class Ford extends Car{

}
class Volvo extends  Car{

}
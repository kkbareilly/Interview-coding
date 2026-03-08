package designpattern.structural.facade;

public class ZomatoFacade {
    Resturent resturent;
    DeliveryTeam deliveryTeam;
    DeliveryBoy deliveryBoy;

    public void placeOrder(){
        resturent.prepareOrder();
        deliveryTeam.assignDeliveryBoy();;
        deliveryBoy.pickOrder();;
        deliveryBoy.deliverOrder();;
    }
}

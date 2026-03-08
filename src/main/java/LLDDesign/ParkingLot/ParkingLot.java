package LLDDesign.ParkingLot;

import java.util.List;

public class ParkingLot {
    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exits;
    Address address;
    String parkingLotName;
    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant,int gateId);
}

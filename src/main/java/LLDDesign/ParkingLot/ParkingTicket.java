package LLDDesign.ParkingLot;

import java.util.Date;

public class ParkingTicket {

    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehileExitDateTime;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    public void updateTotalCost();
    public void updateVehileExitTime(Date vehicleEntryDateTime);

}

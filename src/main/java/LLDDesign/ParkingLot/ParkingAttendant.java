package LLDDesign.ParkingLot;

public class ParkingAttendant extends Account{
    Payment paymentService;
    public boolean processVehicleEntry(Vehicle vehicle);
    public PaymentInfo paymentProcess(ParkingTicket parkingTicket,PaymentType paymentType);
}

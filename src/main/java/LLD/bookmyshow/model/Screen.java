package LLD.bookmyshow.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id;
    private String name;
    private Theater theater;
    private List<Seat> seats;

    public Screen(String id, String name, Theater theater) {
        this.id = id;
        this.name = name;
        this.theater = theater;
        this.seats=new ArrayList<>();
    }

    public void addSeat(Seat seat){this.seats.add(seat);};
}

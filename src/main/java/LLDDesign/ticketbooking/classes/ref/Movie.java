package LLDDesign.ticketbooking.classes.ref;

import LLDDesign.ticketbooking.classes.Admin;

import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private int durationInMins;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    private Admin movieAddedBy;

    private List<SHow> shows;
    public List<SHow> getShows(){return null;}
}

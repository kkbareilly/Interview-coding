package LLD.bookmyshow.model;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private String name;
    private String id;
    private List<Screen> screens;

    public Theater(final String name, final String id) {
        this.name = name;
        this.id = id;
    this.screens = new ArrayList<>();
    }

    public void addScreen( final Screen screen){
        this.screens.add(screen);
    }
}

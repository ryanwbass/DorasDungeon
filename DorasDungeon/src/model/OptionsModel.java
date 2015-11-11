package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katie on 10/30/2015.
 */
public class OptionsModel {

//    Possible User Options
    // title
    // action (thing that it does)
    // description

    private List<String> options;

    public OptionsModel() {
        options = new ArrayList<>();
        options.add("Start Game");
        options.add("New User");
        options.add("Delete User");
        options.add("Difficulty");
        options.add("Quit Game");
    }

    public List<String> getOptions() {
        return options;
    }

}

package mx.mobilestudio.placefinder.model;

import java.util.ArrayList;

/**
 * Created by cesar on 8/5/17.
 */

class Venue {

    String id;
    String name;
    Contact contact;
    Location location;
    ArrayList<Category> categories;
    boolean verified;
    Stats stats;
    BeenHere beenHere;


}

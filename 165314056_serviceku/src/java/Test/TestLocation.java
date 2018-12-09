/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Helper.LocationHelper;
import Pojos.Location;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TestLocation {

    public static void main(String[] args) {
        LocationHelper helper = new LocationHelper();
        List<Location> list = helper.getLocation();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getLng());
            System.out.println(list.get(i).getLat());
        }
    }
}

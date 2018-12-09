/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Helper.DokterHelper;
import Pojos.Dokter;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TestDokter {

    public static void main(String[] args) {
        DokterHelper helper = new DokterHelper();
        List<Dokter> list = helper.bacaSemuaDokter();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getNama());
            System.out.println(list.get(i).getSpesialis());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Helper.AntrianHelper;
import Pojos.Antrian;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TestAntrian {

    public static void main(String[] args) {
        AntrianHelper helper = new AntrianHelper();
        List<Antrian> list = helper.bacaSemuaAntrian();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getTanggal());
            System.out.println(list.get(i).getNoRm());
            System.out.println(list.get(i).getNama());
            System.out.println(list.get(i).getAlamat());
            System.out.println(list.get(i).getNamaKlinik());

        }
    }
}

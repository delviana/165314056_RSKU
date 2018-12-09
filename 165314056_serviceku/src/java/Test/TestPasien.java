/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Helper.PasienHelper;
import Pojos.Pasien;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TestPasien {

    public static void main(String[] args) {
        PasienHelper helper = new PasienHelper();
        List<Pasien> list = helper.bacaSemuaPasien();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNoRm());
            System.out.println(list.get(i).getNama());
            System.out.println(list.get(i).getAlamat());
            System.out.println(list.get(i).getNik());
            System.out.println(list.get(i).getTanggalLahir());
            System.out.println(list.get(i).getKelamin());
        }
    }
}

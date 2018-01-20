/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redtaller;

import java.util.*;

public class RedTaller {

    //ATRIBUTOS
    ArrayList<Taller> talleres;

    //METODOS
    public static void main(String[] args) {
        RedTaller red1 = new RedTaller();   //se tiene que crear la red para poder usar los metodos de esta clase(1)
        Cliente fulano = new Cliente("A", "b", "c");
        Vehiculo buga1 = new Vehiculo(false, 232,fulano, "Audio","hika", "A3456");
        Vehiculo buga2 = new Vehiculo(false, 232,fulano, "VeusSiBaden","roma", "W1488");
        Vehiculo buga3 = new Vehiculo();
        
        //le damos coches a fulano
        fulano.addVehiculo(buga1);
        fulano.addVehiculo(buga2);
        fulano.addVehiculo(buga3);

        //red1.reportVehiculo(buga); //(1)
        fulano.reportVehiculo();

    }

    public RedTaller() {
        this.talleres = new ArrayList();
    }

    private void addCliente() {

    }

    private void reportVehiculo(Vehiculo v) {
        System.out.println(v.getMarca() + v.getMatricula()
                + v.getPropietario());
    }

}

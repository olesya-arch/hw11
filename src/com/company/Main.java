package com.company;

public class Main {

    public static void main(String[] args) {

        Addresses a1 = new Addresses(1, "Riga", "Barona", 17, 2, 18);
        Addresses a2 = new Addresses(2, "Minsk", "Gaya", 45, 2, 84);
        Addresses a3 = new Addresses(3, "Rome", "Modena", 64, 3, 95);
        Addresses a4 = new Addresses(4, "Berlin", "Martin Luther", 26, 1, 15);
        Addresses a5 = new Addresses(5, "Grodno", "Sovetskaya", 4, 1, 7);

        AddressConnector.add(a1);
        AddressConnector.add(a2);
        AddressConnector.add(a3);
        AddressConnector.add(a4);
        AddressConnector.add(a5);


         AddressConnector.delete(2);
         Addresses n = AddressConnector.byId(3);
         n.setCity("Paris");

         boolean changed = AddressConnector.update(n);
         System.out.println(changed);


         for (Addresses addresses : (new AddressConnector()).readAll()) {
          System.out.println(addresses);
     }


    }
}
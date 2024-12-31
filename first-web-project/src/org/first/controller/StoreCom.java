package org.first.controller;

import org.first.model.Store;
import org.first.service.StoreService;

public class StoreCom {
    public static void main(String[] args) throws Exception{
        StoreService service = new StoreService();
//        try {
//            service.create( "Md" , "HAIDER" , "SAHIL@gMAIL.COM","","","2000");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try {
            Store store = service.findById(1);
            System.out.println(store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

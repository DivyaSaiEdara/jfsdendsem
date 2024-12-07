package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Device device = new Device();
        device.setBrand("Samsung");
        device.setModel("M21");
        device.setPrice(30000.00);
        session.save(device);

        Smartphone phone = new Smartphone();
        phone.setBrand("Vivo");
        phone.setModel("Y19");
        phone.setPrice(320000.00);
        phone.setOperatingSystem("Android");
        phone.setCameraResolution(12);
        session.save(phone);

        // Insert Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S8");
        tablet.setPrice(69945.99);
        tablet.setScreenSize(12.4);
        tablet.setBatteryLife(14);
        session.save(tablet);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Records inserted successfully!");
    }
}

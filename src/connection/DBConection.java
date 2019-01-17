/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hunky
 */
public class DBConection {
    private static  EntityManagerFactory factory=null;
    public  static  EntityManager manager;


    public DBConection() {
        factory= Persistence.createEntityManagerFactory("stonebookshopPU");
        manager=factory.createEntityManager();
    }

}

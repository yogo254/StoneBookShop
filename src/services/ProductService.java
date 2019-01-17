package services;

import entities.Product;
import sample.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductService {
    private static  final EntityManager manager= Main.entityManagerTask.getValue();

    public static List<Product>getAllProducts(){
        return manager.createNamedQuery("Product.findAll",Product.class)
                .getResultList();
    }
    public static void addProduct(Product product){
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        try {
            manager.persist(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }
    public static List<Product>getbyName(String name){
        return manager.createNamedQuery("Product.findByProductName",Product.class)
                .setParameter("productName",name).getResultList();
    }

}

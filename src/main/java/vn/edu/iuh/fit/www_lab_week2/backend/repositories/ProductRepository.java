package vn.edu.iuh.fit.www_lab_week2.backend.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Product;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.ProductStatus;

import java.util.List;

public class ProductRepository {

    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductRepository() {
        em = Persistence
                .createEntityManagerFactory("WWW_Lab_Week2")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(Product product) {
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            logger.error(e.getMessage());
        }
    }
    public List<Product> getActiveProduct(){
        return em.createNamedQuery("Product.findAll",Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }

    public void updateStatus(long id, ProductStatus status) {
        TypedQuery<Product> q = em.createNamedQuery("Product.findById", Product.class)
                .setParameter(1, id);
        Product product = q.getSingleResult();
        product.setStatus(status);
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            logger.error(e.getMessage());
        }
    }
}

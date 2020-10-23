package tv.nosy.climanage.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UsersImpl implements IUsersDAO {

    private EntityManager em;

    public UsersImpl(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        em = emf.createEntityManager();
    }


    @Override
    public void addUsers(Users u) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        /**
         * Creation d'une transaction
         */
        EntityTransaction transaction = em.getTransaction();

        /**
         * Demarrer la transaction
         */
        transaction.begin();

        try{
            em.persist(u);
            transaction.commit();
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    @Override
    public Users getUsers(long id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        
        try{
            Query query = em.createQuery("Select u from Users u");
            return query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(em.isOpen()){
                em.close();
            }
        }
        return null;
    }

    @Override
    public void deleteUsers(long id) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }

        Users u = null;

        try{
            u = em.find(Users.class, id);
            em.remove(u);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(em.isOpen())
                em.close();
        }
    }
    @Override
    public void updateUsers(Users u) {
        em.merge(u);
    }

    @Override
    public void deleteUsers(Users u) {
        em.remove(u);
    }    
}

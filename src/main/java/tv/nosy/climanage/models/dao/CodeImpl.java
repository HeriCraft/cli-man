package tv.nosy.climanage.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CodeImpl implements ICodeDAO {

    private EntityManager em;

    public CodeImpl(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        em = emf.createEntityManager();
    }

    @Override
    public void addCode(Code cd) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try{
            em.persist(cd);
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
    public Code getCode(long ref) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        Code res = null;
        try{
            res = em.find(Code.class, ref);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(em.isOpen()){
                em.close();
            }
        }
        return res;
    }

    @Override
    public void updateCode(Code ref) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        try{
            em.merge(ref);
        } catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    @Override
    public void removeCode(long ref) {
        if(em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        try{
            em.remove(em.find(Code.class, ref));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }


    }
    
}

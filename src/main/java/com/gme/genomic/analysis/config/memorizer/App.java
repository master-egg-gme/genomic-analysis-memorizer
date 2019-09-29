package com.gme.genomic.analysis.config.memorizer;

import com.gme.genomic.analysis.config.memorizer.model.Step;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{

    private static EntityManagerFactory ENTITIY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("persist");

    public static void main( String[] args )
    {

        addStep(1, "test-tool-name-0");

    }

    public static void addStep(int step_id, String step_name)
    {
        EntityManager entityManager = ENTITIY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try
        {
            transaction.begin();
            Step customer = new Step(
                    step_id,
                    step_name
            );
            entityManager.persist(customer);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if (entityManager != null)
            {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally
        {
            entityManager.close();
        }
    }

}

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
		
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			
			Movie movie = new Movie();
			movie.setDirector("봉준호");
			movie.setActor("송강호");
			movie.setName("기생충");
			
			em.persist(movie);
			
			em.flush();
			em.clear();
			
			Movie movie2 = em.find(Movie.class, movie.getId());
			
			System.out.println(movie2.getName());
			
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.clear();
		}
		
		emf.close();
				
	}
}

// default package
// Generated Jul 5, 2018 11:56:26 AM by Hibernate Tools 3.6.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class StudentRegistration.
 * @see .StudentRegistration
 * @author Hibernate Tools
 */
@Stateless
public class StudentRegistrationHome {

	private static final Log log = LogFactory.getLog(StudentRegistrationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(StudentRegistration transientInstance) {
		log.debug("persisting StudentRegistration instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(StudentRegistration persistentInstance) {
		log.debug("removing StudentRegistration instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public StudentRegistration merge(StudentRegistration detachedInstance) {
		log.debug("merging StudentRegistration instance");
		try {
			StudentRegistration result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudentRegistration findById(String id) {
		log.debug("getting StudentRegistration instance with id: " + id);
		try {
			StudentRegistration instance = entityManager.find(StudentRegistration.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

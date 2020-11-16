package br.com.lucaswagner.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.lucaswagner.domain.Processo;
import br.com.lucaswagner.util.JpaUtil;

public class ProcessoManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int Cadastrar(Processo p) {

		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
			em.getTransaction().rollback();
			return 500;

		} finally {

			em.close();
		}
		
		return 201;
	}

	public List<Processo> BuscarTodos() {

		EntityManager em = JpaUtil.getEntityManager();

		List<Processo> resultado = new ArrayList<Processo>();

		try {
			String consulta = "select p from Processo p";
			TypedQuery<Processo> query = em.createQuery(consulta, Processo.class);
			resultado = query.getResultList();

		} catch (Exception ex) {

			ex.printStackTrace();
			em.getTransaction().rollback();

		} finally {

			em.close();
		}

		return resultado;
	}

	public List<Processo> BuscarProcessoPorID(Long id) {

		EntityManager em = JpaUtil.getEntityManager();

		List<Processo> resultado = new ArrayList<Processo>();

		try {
			String consulta = "select p from Processo p where p.id = :id ";
			TypedQuery<Processo> query = em.createQuery(consulta, Processo.class);
			query.setParameter("id", id);
			resultado = query.getResultList();

		} catch (Exception ex) {

			ex.printStackTrace();
			em.getTransaction().rollback();

		} finally {

			em.close();
		}

		return resultado;

	}
	
	public List<Processo> BuscarProcessoPorNumero(String numero) {

		EntityManager em = JpaUtil.getEntityManager();

		List<Processo> resultado = new ArrayList<Processo>();

		try {
			String consulta = "select p from Processo p where p.publicacao = :numero ";
			TypedQuery<Processo> query = em.createQuery(consulta, Processo.class);
			query.setParameter("numero", numero);
			resultado = query.getResultList();

		} catch (Exception ex) {

			ex.printStackTrace();
			em.getTransaction().rollback();

		} finally {

			em.close();
		}

		return resultado;

	}

	
	@SuppressWarnings("unchecked")
	public List<Processo> BuscarProcessoPorRequerentes(String requerentes) {

		EntityManager em = JpaUtil.getEntityManager();
		
		List<Processo> resultado = new ArrayList<Processo>();

		try {
			Session s = em.unwrap(Session.class);
			Criteria criteria = s.createCriteria(Processo.class);
			criteria.add(Restrictions.ilike("requerentes", requerentes, MatchMode.ANYWHERE));
			resultado = criteria.list();
		} catch (Exception ex) {

			ex.printStackTrace();
			em.getTransaction().rollback();

		} finally {

			em.close();
		}

		return resultado;
	}

}

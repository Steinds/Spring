package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;


@Service
public class CotisationServiceJpa implements CotisationService {
 @PersistenceContext private EntityManager em;

@Override
public void sauvegarder(Cotisation nouvelleCotisation) {
	// TODO Auto-generated method stub
	em.persist(nouvelleCotisation);
	
}

@Override
public void mettreAJour(Cotisation cotisation) {
	// TODO Auto-generated method stub
	em.merge(cotisation);
	
}

@Override
public List<Cotisation> lister() {
	// TODO Auto-generated method stub
	TypedQuery<Cotisation> query =  em.createQuery("select coti from Cotisation coti",Cotisation.class);		
	return query.getResultList();
	
}
}

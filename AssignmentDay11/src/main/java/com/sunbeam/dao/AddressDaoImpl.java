package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Address;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignUserAddress(Long userId, Address newAdr) {
		String mesg="assigning adr failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}

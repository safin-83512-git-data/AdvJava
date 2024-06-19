package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.AddressDao;
import com.sunbeam.dao.AddressDaoImpl;
import com.sunbeam.entities.Address;

public class AssignUserAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AddressDao dao=new AddressDaoImpl();
			System.out.println("Enter user id");
			Long userId = sc.nextLong();
			System.out.println(
					"Enter adr details - adrLine1, String adrLine2, String city, String state, String country, String zipCode ,phone no");
			Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),sc.next());
			System.out.println(dao.assignUserAddress(userId,adr));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

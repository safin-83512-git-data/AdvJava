package com.sunbeam.dao;

import com.sunbeam.entities.Address;

public interface AddressDao {

	String assignUserAddress(Long userId,Address newAdr);

}

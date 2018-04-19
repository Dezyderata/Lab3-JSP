package domain.mappers;

import javax.servlet.http.HttpServletRequest;

import domain.Address;

public class AddressResultMapper implements ResultSetMapper<Address>{

	@Override
	public Address map(HttpServletRequest request) {
		Address result = new Address();
		result.setCity(request.getParameter("city"));
		result.setZipCode(request.getParameter("zipCode"));
		result.setStreet(request.getParameter("street"));
		result.setHouseNumber(request.getParameter("houseNumber"));
		result.setLocalNumber(request.getParameter("localNumber"));
		result.setPhoneNumber(request.getParameter("phoneNumber"));
		return result;
	}

}

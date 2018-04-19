package domain.mappers;

import javax.servlet.http.HttpServletRequest;

import domain.Person;

public class PersonResultMapper implements ResultSetMapper<Person> {

	@Override
	public Person map(HttpServletRequest request) {
		Person result = new Person();
		result.setFirstName(request.getParameter("firstName"));
		result.setSurname(request.getParameter("surname"));
		result.setPesel(request.getParameter("pesel"));
		return result;
	}

}

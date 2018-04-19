package validation;

import domain.Address;

public class AddressValidation {
	private Address address;
	private Boolean answer= true;
	private String problem = "";
	public AddressValidation(Address address) {
		this.address = address;
	}
	public void doAddressValidation() {
		checkCity();
		checkZipCode();		
		checkStreet();
		checkHouseNumber();
		checkPhoneNumber();
	}
	public void checkCity() {
		if((this.address.getCity().length()<=1) || !(this.address.getCity().matches("(^[A-Z])([a-z]*)"))) {
			setAnswer(false);
			setProblem("Błąd w nazwie miasta! ");
		}
		
	}
	public void checkZipCode() {
		if(this.address.getZipCode().length()!=6 || !(this.address.getZipCode().matches("([0-9]{2})([\\u002D]?)([0-9]{3})"))) {
			setAnswer(false);
			setProblem("Błąd w kodzie ! ");
		}
	}
	public void checkStreet() {
		if(this.address.getStreet().length()<=2 || !(this.address.getStreet().matches("(^[A-Z])([a-z]*)"))) {
			setAnswer(false);
			setProblem("Błąd w nazwie ulicy ! ");
		}
	}
	public void checkHouseNumber() {
		if(this.address.getHouseNumber().length()<1 || !(this.address.getHouseNumber().matches("([0-9]*)([a-z]?)"))) {
			setAnswer(false);
			setProblem("Błąd w numerze domu ! ");
		}
	}
	public void checkPhoneNumber() {
		if(this.address.getPhoneNumber().length()!=9 || !(this.address.getPhoneNumber().matches("([0-9]*)"))) {
			setAnswer(false);
			setProblem("Błąd w numerze telefonu ! ");
		}
	}	
	
	public Boolean getAnswer() {
		return answer;
	}
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem += "" + problem;
	}
}

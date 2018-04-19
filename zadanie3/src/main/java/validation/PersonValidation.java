package validation;

import domain.Person;

public class PersonValidation {

	private Person person;
	private Boolean answer= true;
	private String problem = "";	
	public PersonValidation(Person person) {
		this.person = person;
	}
	public void doPersonValidation() {
		checkFirstName();
		checkSurname();
		checkPesel();
	}
	public void checkFirstName() {
		if((this.person.getFirstName().length()<=2) || !(this.person.getFirstName().matches("(^[A-Z])([a-z]*)"))){
			setAnswer(false);
			setProblem("Błąd w imieniu! ");
		}
	}
	public void checkSurname() {
		if((this.person.getSurname().length()<=2) || !(this.person.getSurname().matches("(^[A-Z])([a-z]*)"))){
			setAnswer(false);
			setProblem("Błąd w nazwisku! ");
		}
	}
	public void checkPesel() {
		if((this.person.getPesel().length()!=11) || !(this.person.getPesel().matches("[0-9]*"))){
			setAnswer(false);
			setProblem("Błąd w peselu! ");
		}
	}	
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem += "" + problem;
	}

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

}

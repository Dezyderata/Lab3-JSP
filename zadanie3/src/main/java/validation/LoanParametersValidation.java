package validation;

import domain.LoanParameters;

public class LoanParametersValidation {

	private LoanParameters loanParameters;
	private String problem = "";
	private Boolean answer =  true;
	
	public LoanParametersValidation(LoanParameters loanParameters) {
		this.loanParameters = loanParameters;
	}
	public void doLoanParametersValidation() {
		checkAmount();
		checkInstallments();
	}
	public void checkAmount() {
		if(loanParameters.getAmount() < 500) {
			setAnswer(false);
			setProblem("Kwota kredytu powinna być większa niż: 500. ");
		}
	}
	public void checkInstallments() {
		if(!(this.loanParameters.getInstallmentCount() >= 1 
				&& this.loanParameters.getInstallmentCount() <= 600)) {
			setAnswer(false);
			setProblem("Liczba rat powinna przyjmować wartości z zakresu: 1 - 600. ");
		}
	}
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem += ""+ problem;
	}

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

}

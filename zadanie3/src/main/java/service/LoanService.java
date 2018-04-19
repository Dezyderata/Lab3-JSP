package service;

import java.util.ArrayList;
import java.util.List;

import domain.LoanApplication;

public class LoanService {

	private List<LoanApplication> loans = new ArrayList<LoanApplication>();
	
	public void add(LoanApplication aplication) {
		if(loans.contains(aplication))
			return;
		loans.add(aplication);
	}
	public List<LoanApplication> getAll(){
		return loans;
	}
}

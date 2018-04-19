package domain.mappers;

import javax.servlet.http.HttpServletRequest;

import domain.LoanParameters;

public class LoanParametersResultMapper implements ResultSetMapper<LoanParameters>{

	@Override
	public LoanParameters map(HttpServletRequest request) {
		LoanParameters result = new LoanParameters();
		result.setAmount(Integer.parseInt(request.getParameter("amount")));
		result.setInstallmentCount(Integer.parseInt(request.getParameter("installmentCount")));
		return result;
	}	
}

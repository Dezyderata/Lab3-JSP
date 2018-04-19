package web.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domain.LoanParameters;
import domain.ParamIterator;
import domain.Person;
import domain.mappers.LoanParametersResultMapper;
import validation.LoanParametersValidation;

@WebFilter({"/address.jsp", "/success.jsp", "/person.jsp"})
public class LoanParametersFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		LoanParameters loanParameters;
		if((loanParameters = (LoanParameters)session.getAttribute("parameters")) == null) {
			if((loanParameters = retrieveLoanParametersFromRequest(httpRequest)) == null) {
				httpResponse.sendRedirect("index.jsp?error=1");
				return;
			}
		}
		LoanParametersValidation validation = new LoanParametersValidation(loanParameters);
		validation.doLoanParametersValidation();
		if(!validation.getAnswer()) {
			request.setAttribute("Validation", validation.getProblem());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	private LoanParameters retrieveLoanParametersFromRequest(HttpServletRequest request) {
		ParamIterator paramIterator = new ParamIterator(request);
		if(paramIterator.getAns()) {
			return null;
		}else{
			LoanParametersResultMapper loanParameters = new LoanParametersResultMapper();
			return loanParameters.map(request);
		}
	}	
}

package web.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Address;
import domain.ParamIterator;
import domain.mappers.AddressResultMapper;
import validation.AddressValidation;


@WebFilter("/success.jsp")
public class AddressFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Address address;
		if((address = retrieveAddressFromRequest(httpRequest))==null) {
			httpResponse.sendRedirect("index.jsp?error=1");
			return;
		}else {
			AddressValidation validation = new AddressValidation(address);
			validation.doAddressValidation();
			if(!validation.getAnswer()) {
				request.setAttribute("Validation", validation.getProblem());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	private Address retrieveAddressFromRequest(HttpServletRequest request) {
		ParamIterator paramIterator = new ParamIterator(request);
		if(paramIterator.getAns()) {
			return null;
		}else {
			AddressResultMapper address = new AddressResultMapper();
			return address.map(request);
		}
	}

}

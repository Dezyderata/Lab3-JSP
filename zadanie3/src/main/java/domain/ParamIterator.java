package domain;

import java.util.Enumeration;

import javax.servlet.ServletRequest;

public class ParamIterator {
	
	private Boolean ans;
	public ParamIterator(ServletRequest request) {
		Enumeration en = request.getParameterNames();
		this.ans = false;
		if(!en.hasMoreElements()) {
			ans = true;
		}else {
			while(en.hasMoreElements() && ans==false) {
				String parameterName = (String)en.nextElement();
				if(request.getParameter(parameterName)==null || request.getParameter(parameterName).isEmpty()) {
					ans = true;
				}
			}
		}
	}
	public Boolean getAns() {
		return ans;
	}
}

package domain.mappers;

import javax.servlet.http.HttpServletRequest;

public interface ResultSetMapper <TEntity>{
	public TEntity map(HttpServletRequest request);

}

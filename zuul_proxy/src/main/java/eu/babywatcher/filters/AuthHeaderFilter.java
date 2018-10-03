package eu.babywatcher.filters;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class AuthHeaderFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getAttribute("AUTH_HEADER") == null) {
			//generate or get AUTH_TOKEN, ex from Spring Session repository
			String sessionId = UUID.randomUUID().toString();

			ctx.addZuulRequestHeader("AUTH_HEADER", sessionId);
		}
		return null;
	}
}
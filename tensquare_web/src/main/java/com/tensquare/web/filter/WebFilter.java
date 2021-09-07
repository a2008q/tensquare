package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //pre方法执行之前进行拦截
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤顺序 值越小，优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //true走过滤器 false 不走过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
//        System.out.println("zuul过滤器");
        //需要先获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String authorization = request.getHeader("Authorization");
        if(authorization!=null){
            //请求转发
            requestContext.addZuulRequestHeader("Authorization",authorization);
        }
        return null;
    }
}

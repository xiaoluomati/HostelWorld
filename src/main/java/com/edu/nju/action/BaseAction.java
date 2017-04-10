package com.edu.nju.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zhuding on 2017/3/10.
 */
public class BaseAction extends ActionSupport implements SessionAware,
        ServletRequestAware, ServletResponseAware {

    private static final long serialVersionUID = 1L;

    public HttpServletRequest request;
    public HttpServletResponse response;
    public Map<String, Object> session;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;

    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}


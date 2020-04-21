/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;


import Job.JobDao;
import com.me.user.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import java.util.*;

import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author qiank
 */
public class registerController extends AbstractController {
    static int temp = 3;
    public registerController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView res = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao ud = new UserDao();
        ud.addUser(temp, username, password);
        res = new ModelAndView("index");
        return res;

    }
}

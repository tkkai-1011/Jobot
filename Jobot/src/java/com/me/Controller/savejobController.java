/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;

import com.me.job.Jobhelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author qiank
 */
public class savejobController extends AbstractController {
    static int temp = 10;
    public savejobController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        Jobhelper jh = new Jobhelper();
        HttpSession session = request.getSession();
        String username =  (String) session.getAttribute("username");
        System.out.println(username);
        String jobtitle = request.getParameter("jobtitle");
        String joburl = request.getParameter("joburl");
        jh.addJob(temp, username, jobtitle, joburl);
        temp ++;
        mv = new ModelAndView("addsuccess");
        return mv;
    }
    
}

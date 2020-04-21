/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;

import com.me.job.Job;
import com.me.job.Jobhelper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author qiank
 */
public class fetchController extends AbstractController {
    
    public fetchController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("viewsavejobs");
        Jobhelper jd = new Jobhelper();
        HttpSession session = request.getSession();
        String x = (String) session.getAttribute("username");
        List list = jd.getJobs("name", x);

        mv.addObject("jobs", list);
        return mv;
    }
    
}

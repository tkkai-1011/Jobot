/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;


import Job.JobDao;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author qiank
 */
public class searchController extends AbstractController {
    
    public searchController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView res = null;
        res = new ModelAndView("view");
        List<JobDao> job = new ArrayList<>();
        HttpSession session = request.getSession();
        String searchword = request.getParameter("jobSpecification");
//        System.out.println(searchwo/rd);
        Map<JobDao, List<HtmlElement>> jobs =  (Map<JobDao, List<HtmlElement>>) session.getAttribute("jobs");
        for (Map.Entry<JobDao, List<HtmlElement>> entry : jobs.entrySet()) {
            Pattern p = Pattern.compile(searchword);
            for (HtmlElement item : entry.getValue()) {
//                for(String i : item.getTextContent().split(" ")){
//                    m = p.matcher(item.getTextContent());
                    if(searchword.equals("c++")||searchword.equals("C++")){
                        if(Pattern.matches(".*C"+Pattern.quote("+")+Pattern.quote("+")+".*", item.getTextContent())){
                            job.add(entry.getKey());
                            break;
                        }
                    }else{
                        if(Pattern.matches(".*"+searchword+".*", item.getTextContent())){
                            job.add(entry.getKey());
                            break;
                        }
                    }
            }

        }
        res.addObject("job",job);
        return res;

    }
}

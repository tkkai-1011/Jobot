/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;


import Job.JobDao;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import java.util.*;
import java.util.regex.Pattern;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
/**
 *
 * @author qiank
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
  maxFileSize = 1024 * 1024 * 5, 
  maxRequestSize = 1024 * 1024 * 5 * 5)
public class fileController extends AbstractController {
    
    public fileController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
                ModelAndView res = null;
                res = new ModelAndView("view");
        String temp = (String) request.getParameter("resume");
//        System.out.println(temp);
        String[] lines = temp.split(" ");
        int softwareCounter = 0;//count to >=2 to identify as software engineer
        int databaseCounter = 0;//count to >=2 to identify as data analyst
        int frontendCounter = 0;//count to >=2 to identify as frontend developer
        int backendCounter = 0;//count to >=2 identify as backend developer
        //identify as fullstack when frontend and backend are all over 2;
        List<JobDao> job = new ArrayList<>();
        HttpSession session = request.getSession();
        Map<JobDao, List<HtmlElement>> jobs =  (Map<JobDao, List<HtmlElement>>) session.getAttribute("jobs");
        List<String> searchkey = new ArrayList<>();

        
        /**
         * extract keyword from resume text area
         */
        for(String i : lines){
            System.out.println("yes");
            if(Pattern.matches(".*Java.*", i)||Pattern.matches(".*Python.*", i)||Pattern.matches(".*C.*", i)){
                softwareCounter++;
            }
            if(Pattern.matches(".*MongoDB.*", i)||Pattern.matches(".*MySQL.*", i)||Pattern.matches(".*SQL.*", i)){
                databaseCounter++;
            }
            if(Pattern.matches(".*CSS.*", i)||Pattern.matches(".*HTML.*", i)||Pattern.matches(".*Angular.*", i)||Pattern.matches(".*React.*", i)||Pattern.matches(".*Javascript.*", i)){
                frontendCounter++;
            }
            if(Pattern.matches(".*Servlet.*", i)||Pattern.matches(".*REST.*", i)||Pattern.matches(".*Hibernate.*", i)){
                backendCounter++;
            }
        }
        if(softwareCounter>1){
            searchkey.add("Java");
            searchkey.add("Python");
            searchkey.add("C++");
        }else if(databaseCounter>1){
            searchkey.add("MongoDB");
            searchkey.add("MySQL");
            searchkey.add("database");
        }else if(frontendCounter>1){
            searchkey.add("CSS");
            searchkey.add("HTML");
            searchkey.add("Javascript");
        }else if(backendCounter>1){
            searchkey.add("Servlet");
            searchkey.add("REST");
            searchkey.add("Hibernate");
        }
        System.out.println("software" + softwareCounter);
        System.out.println("database" + databaseCounter);
        System.out.println("frontend" + frontendCounter);
        System.out.println("backend" + backendCounter);
        for(String i : searchkey){
            System.out.println(i);
        }
        /**
         * pass extracted keyword to search job list
         */
        int index = 0;
        boolean flag = false;
        for (Map.Entry<JobDao, List<HtmlElement>> entry : jobs.entrySet()) {
            Pattern p = Pattern.compile(searchkey.get(index));
            for (HtmlElement item : entry.getValue()) {
                if(index>=searchkey.size()){
                    flag = true;
                    break;
                }
                    if(searchkey.get(index).equals("c++")||searchkey.get(index).equals("C++")){
                        if(Pattern.matches(".*C"+Pattern.quote("+")+Pattern.quote("+")+".*", item.getTextContent())){
                            job.add(entry.getKey());
                            index++;
                            flag = true;
                            break;
                        }
                    }else{
                        if(Pattern.matches(".*"+searchkey.get(index)+".*", item.getTextContent())){
                            job.add(entry.getKey());
                            index++;
                            flag = true;
                            break;
                        }
                    }
            }
            if(flag){
                break;
            }
        }
        res.addObject("job",job);
        for(JobDao j : job){
            System.out.println(j);
        }
        return res;

    }
}

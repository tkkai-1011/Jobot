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
import javax.servlet.http.HttpSession;
/**
 *
 * @author qiank
 */
public class optionController extends AbstractController {
    
    public optionController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView res = null;
        WebClient wc = new WebClient();//using webclient
        HttpSession session = request.getSession();
        String searchword = request.getParameter("keyword");
        Map<JobDao,List<HtmlElement>> jobs = new HashMap<>();
        wc.getOptions().setCssEnabled(false);
        wc.getOptions().setJavaScriptEnabled(false);
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setThrowExceptionOnScriptError(false);
        res = new ModelAndView("option");
        try {
            String searchUrl = "https://www.indeed.com/jobs?q="+searchword+"&l=Boston%2C+MA";//search jobs in indeed
            res = new ModelAndView("option");
            HtmlPage page = wc.getPage(searchUrl);
            List<HtmlElement> tandu = page.getByXPath("//a[@data-tn-element='jobTitle']");//title and url
            List<HtmlElement> location = page.getByXPath("//div[@class='recJobLoc']");//location

//            for (HtmlElement i : tandu) {
//                System.out.println(i);
//            }
//            for (HtmlElement i : location) {
//                System.out.println(i);
//            }
            if (tandu.isEmpty()) {
                System.out.println("No items found !");
            } else {
                for (int i =0; i<tandu.size();i++) {
                    String title =  tandu.get(i).getAttribute("title");
                    String url = "https://www.indeed.com"+tandu.get(i).getAttribute("href");
                    String loc = location.get(i).getAttribute("data-rc-loc");
                    JobDao jd = new JobDao();
                    jd.setTitle(title);
                    jd.setUrl(url);
                    jd.setLocation(loc);
                    
                    HtmlPage jobpage = wc.getPage(url);
                    System.out.println(url);
                    List<HtmlElement> jobdes =  jobpage.getByXPath("//div[@id='jobDescriptionText']/*");// job description and requirement which needs to be stored in db
//                    for (HtmlElement j: jobdes) {
//                        System.out.println(j.getTextContent());
//                    }
                    jobs.put(jd,jobdes);
                }
//                System.out.println(jobs);
                session.setAttribute("jobs", jobs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }
}

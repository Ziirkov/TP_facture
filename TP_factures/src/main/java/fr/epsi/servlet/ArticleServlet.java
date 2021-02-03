package fr.epsi.servlet;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;
import fr.epsi.service.IArticleService;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {
	
	@EJB
	private IArticleService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
			if(req.getParameter("action").equals("list"))
					{
						req.setAttribute("articles", service.getArticle());
				
						this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);
					}
			else if(req.getParameter("action").equals("creer"))
			{
				req.setAttribute("articles", service.getArticle());
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/createarticle.jsp").forward(req, resp);
			}
		   
        }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		Article a = new Article();
			a.setNom(req.getParameter("nom"));
			a.setPrix(Double.parseDouble(req.getParameter("prix")) );
			service.createArticle(a);
			
			resp.sendRedirect("http://localhost:8080/TP_factures-0.0.1-SNAPSHOT/articles?action=list");
        }
    
        
}

package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Client;
import fr.epsi.service.IClientService;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

	@EJB
	private IClientService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {  
		
				if(req.getParameter("action").equals("list"))
				{
					req.setAttribute("clients", service.getClient());
			
					this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clients.jsp").forward(req, resp);
				}
		else if(req.getParameter("action").equals("creer"))
		{
			req.setAttribute("clients", service.getClient());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/createclient.jsp").forward(req, resp);
		}
        
        }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		Client c = new Client();
    		c.setNom(req.getParameter("nom"));
    		c.setAdresse(req.getParameter("adresse"));
    		service.createClient(c);
    		
    		resp.sendRedirect("http://localhost:8080/TP_factures-0.0.1-SNAPSHOT/clients?action=list");
    		
    		
        }
        
}

package prueba5;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Filtro
 */
public class Filtro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws ServletException, IOException {
String path = request.getRequestURI().toLowerCase();
        

        if (!path.equals("/") &&
                !path.startsWith("/api") &&
                !path.startsWith("/static") &&
                !path.startsWith("/manifest.json") &&
                !path.startsWith("/favicon.ico") &&
                !path.startsWith("/robots.txt") &&
                !path.endsWith("xml") &&
                !path.endsWith("json") &&
                !path.endsWith("jpg") &&
                !path.endsWith("jpeg") &&
                !path.endsWith("gif") &&
                !path.endsWith("png")) {
            
            request.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }


        
        filterChain.doFilter(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


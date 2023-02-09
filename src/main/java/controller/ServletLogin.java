package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

import java.io.IOException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin usuario1 = new ModelLogin();
			usuario1.setUsuario(usuario);
			usuario1.setSenha(senha);
			
			request.getSession().setAttribute(usuario, usuario1.getUsuario());
			RequestDispatcher redirecionar = request.getRequestDispatcher("principal/inicio.jsp");
			redirecionar.forward(request, response);
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensagem", "Informe o Usuário e Senha corretamenet!!!");
			redirecionar.forward(request, response);
		}
		
		
	}

}

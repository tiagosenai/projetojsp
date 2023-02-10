package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class FilterAuthentication extends HttpFilter {
       

    public FilterAuthentication() {
        super();

    }

	public void destroy() {
		//Encerrar a conex�o com o Banco
		//Encerrar processos e recursos do projeto
	}

	//Interceptar requisi��es e repostas
	//Tudo que for executado no sistema vai passar por aqui
	//valida��o e autentica��o
	//Commit e Rolback de transa��o no banco
	//Validar e fazer redirecionamento de p�ginas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlAcessada = req.getServletPath();
		
		if (usuarioLogado == null && !urlAcessada.equals("/principal/login")) {
			RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp?url=" + urlAcessada);
			request.setAttribute("mensagem", "Por Favor, realizar login!!!");
			redireciona.forward(request, response);
			return;
		}else {
			chain.doFilter(request, response);
		}		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		//iniciar a conex�o com o banco
		//inicia os processos e recursos do projeto
	}

}

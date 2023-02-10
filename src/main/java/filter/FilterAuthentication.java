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
		//Encerrar a conexão com o Banco
		//Encerrar processos e recursos do projeto
	}

	//Interceptar requisições e repostas
	//Tudo que for executado no sistema vai passar por aqui
	//validação e autenticação
	//Commit e Rolback de transação no banco
	//Validar e fazer redirecionamento de páginas
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
		//iniciar a conexão com o banco
		//inicia os processos e recursos do projeto
	}

}

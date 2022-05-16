package controller;

import jakarta.servlet.http.HttpServlet;
import model.Produto;
import model.ProdutoDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gerenciarProduto")
public class GerenciarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GerenciarProduto() {
        super();
        
    }


    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    		PrintWriter out = response.getWriter();
    		String acao = request.getParameter("acao");
    		String idProduto = request.getParameter("idProduto");
    		String mensagem = "";
    		
    		Produto produto = new Produto();
    		ProdutoDAO produtodao = new ProdutoDAO();
    		
    			try {
    			
    				if(acao.equals("deletar")) {
    					produto.setIdProduto(Integer.parseInt(idProduto));
    					if(produtodao.deletar(produto.getIdProduto())) {
    							mensagem = 
    								"Produto excluído da base de dados!";
    					
    					}else {
    						mensagem = 
    					"Falha ao excluir o produto da base de dados!";
    					}
    			}
    		
    				if(acao.equals("alterar")){
    					produto = produtodao.getCarregarPorId(
    							Integer.parseInt(idProduto));
    					if(produto.getIdProduto() > 0) {
    						RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().
							getRequestDispatcher("/cadastrarProduto.jsp");
    						request.setAttribute("produto", produto);
    						dispatcher.forward(request, response);
    						
    					}else {
    						mensagem = "Produto não encontrado na base de dados!";
    					}
    				}
    					
    				
    			} catch (SQLException e){
    				mensagem = "Erro: " + e.getMessage();
    				out.println(mensagem);
    				e.printStackTrace();
    			}
    			
    		out.println(
    				"<script type='text/javascript'>" +
    				"alert('" + mensagem + "');" +
    				"location.href='listarProduto.jsp';" +
    				"</script>");
    }
   
    	
  	
    	protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		String idProduto = request.getParameter("idProduto");
    		String nome = request.getParameter("nome");
    		String descricao = request.getParameter("descricao");
    		String estoque = request.getParameter("estoque");
    		String preco = request.getParameter("preco");
    		String nomearquivo = request.getParameter("nomearquivo");
    		String caminho = request.getParameter("caminho");
    		String mensagem = "";
    		
    		Produto produto  = new Produto();
    		ProdutoDAO produtodao = new ProdutoDAO();
    		
    		try {
    			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    			
    			if(!idProduto.isEmpty()) {
    				produto.setIdProduto(Integer.parseInt(idProduto));
    				
    			}
    			
    			if(nome.isEmpty() || nome.equals("")) {
    				mensagem = "Campo Obrigatório";
    				
    			}else {
    				produto.setNome(nome);
    				produto.setDescricao(descricao);
    				produto.setPreco(serialVersionUID);
    				produto.setNomeArquivo(nomearquivo);
    				produto.setCaminho(caminho);
    				if(produtodao.gravar(produto)) {
    					mensagem = 
    						"Produto gravado com sucesso na base de dados!";
    				}else {
    					mensagem =
    						"Falha ao gravar o produto na base de dados!";
    					
    				}
    			}
    		}
    		catch (SQLException e) {
    			mensagem = "Erro: " + e.getMessage();
    			out.println(mensagem);
    		}
    		
    		out.println(
    			"<script type='text/javascript'>" +
    			"alert('" + mensagem + "');" +
    			"location.href='listarProduto.jsp';" +
    			"</script>"
    			
    				);
    	}

}

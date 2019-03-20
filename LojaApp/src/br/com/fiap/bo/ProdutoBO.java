package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.client.ClientResponse;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	// private static Logger log = Logger.getLogger(EstoqueBO.class);
	
	private static ArrayList<ProdutoTO> lista = new ArrayList<ProdutoTO>();
	private static ProdutoBO produtoBo;
	
	
	public static ProdutoBO getInstance() {
		if (produtoBo == null) {
			produtoBo = new ProdutoBO();
		}
		return produtoBo;
	}

	
	public ProdutoBO() {
		lista.add(new ProdutoTO(402, 2.99, 4, "Camisa Branca"));
		lista.add(new ProdutoTO(402, 2.99, 4, "Camisa Azul"));
		lista.add(new ProdutoTO(403, 2.99, 4, "Camisa Rosa"));
		
	}

	public static ProdutoTO consultaBO(int codProd) {

		for (ProdutoTO produto : lista) {
			if (produto.getCodigo() == codProd) {
				return produto;

			}
		}
		return null;
	}
	
	
	
	public void remover(int codigo) {
		for (ProdutoTO produto : lista) {
			if (produto.getCodigo() == codigo) {
				lista.remove(produto);
				break;
			}
		}
	}

	public List<ProdutoTO> listar() {
		return lista ;
	}
	
	
	public void cadastar(ProdutoTO produto) {
		lista.add(produto);
	}
	
	public ProdutoTO listar(int codigo) {
		return consultaBO(codigo);
	}


	public void atualizar(ProdutoTO produto) {
		
		for (ProdutoTO produto2 : lista) {
			if (produto.getCodigo() == produto2.getCodigo()) {
				produto2.setDescricao(produto.getDescricao());
				produto2.setQuantidade(produto.getQuantidade());
				produto2.setPreco(produto.getPreco());
				break;
			}
		}
	}
	
	

}

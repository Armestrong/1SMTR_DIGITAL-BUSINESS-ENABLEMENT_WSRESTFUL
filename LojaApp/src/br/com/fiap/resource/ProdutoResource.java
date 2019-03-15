package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")

public class ProdutoResource {
	private static ProdutoBO produtoBo = ProdutoBO.getInstance();
	
	// CONSULTAR POR LISTA
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar() {
		return produtoBo.listar();
	}

	// CONSULTAR POR CODIGO
	@                                                  GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO burcar(@PathParam("id") int cod) {
		return produtoBo.consultarBO(cod);
	}

	//CADASTRAR 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		 produtoBo.cadastar(produto);
		System.out.println(produto.getCodigo());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
		System.out.println(produto.getDescricao());
		
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produto.getCodigo()));
		return Response.created(builder.build()).build();

	}
	
	
	
	
}

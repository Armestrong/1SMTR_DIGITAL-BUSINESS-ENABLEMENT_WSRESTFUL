
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainGET {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200) {
			ProdutoTO[] produtos = response.getEntity(ProdutoTO[].class);
			for (ProdutoTO produtoTO : produtos) {
				System.out.println(produtoTO.getCodigo());
				System.out.println(produtoTO.getDescricao());
				System.out.println(produtoTO.getQuantidade());
				System.out.println(produtoTO.getPreco());
				System.out.println("---");

			}
		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}
	}

}
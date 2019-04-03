import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class MainGETID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = Client.create();
		Scanner leitor = new Scanner(System.in);
		int codigo = leitor.nextInt();
		
		WebResource resource = client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto/" + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		leitor.close();
		
		if (response.getStatus() == 200) {
			ProdutoTO produto = response.getEntity(ProdutoTO.class);
			System.out.println(produto.getCodigo());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getQuantidade());
			System.out.println(produto.getPreco());

		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}

	}

}
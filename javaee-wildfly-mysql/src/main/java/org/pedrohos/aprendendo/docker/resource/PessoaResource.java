package org.pedrohos.aprendendo.docker.resource;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.pedrohos.aprendendo.docker.model.entities.Pessoa;
import org.pedrohos.aprendendo.docker.model.repository.Pessoas;

@Path("pessoas/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class PessoaResource {
	
	@Inject
	private Pessoas pessoas;

	@POST
	public Response novo(Pessoa pessoa) {
		
		pessoas.novo(pessoa);
		
		URI uri = UriBuilder.fromResource(PessoaResource.class)
							.path(String.valueOf(pessoa.getId()))
							.build();
		
		return Response.created(uri)
					   .build();
	}
	
	@GET
	public Response todas() {
		return Response.ok(pessoas.todos()).build();
	}
}

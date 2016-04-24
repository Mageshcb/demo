package com.stack.service;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stack.rs.QuestionNotFoundException;
import com.stack.rs.Questions;
import com.stack.rs.QuestionsDao;

@Path("/question")
public class QuestionService {

	QuestionsDao qdao = new QuestionsDao();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response add(Questions question) {
		qdao.create(question);
		return Response.ok().build();
	}

	@Path("/{questionId}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response get(@PathParam("questionId") int questionId)
			throws QuestionNotFoundException {
		Questions question = qdao.read(questionId);
		Response.ok().header("Access-Control-Allow-Origin", "*");
		return Response.ok().entity(question).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response get() throws ParseException {
		List<Questions> questions = qdao.readAll();
		GenericEntity<List<Questions>> entity = new GenericEntity<List<Questions>>(
				questions) {
		};
		return Response.ok().entity(entity)
				.header("Access-Control-Allow-Origin", "*").build();
	}
}

package br.usp.icmc.intermidia.esm.rest.api.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment.Experiment;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment.ExperimentRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.json.ActiveSample;
import br.usp.icmc.intermidia.esm.rest.api.client.json.Person;
import br.usp.icmc.intermidia.esm.rest.api.client.json.QuestionIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.json.Researcher;
import br.usp.icmc.intermidia.esm.rest.api.client.json.SampleTrigger;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final String REST_API_ADDRESS = "http://localhost:8080/";
	
	public static void main(String[] args) {
		testExperiment();
	}
	
	static void testExperiment() {
		Client client = Client.create();
		Gson gson = new Gson();
		
		Researcher researcher = new Researcher();
		researcher.setName("Bruna Rodrigues");
		researcher.setEmail("brunaru7@gmail.com");
		researcher.setPassword("123456");
		// POST researcher
		String researcherJson = gson.toJson(researcher);
		WebResource researcherResource = client.resource(REST_API_ADDRESS + "researchers");
		ClientResponse researcherResponse = researcherResource.type("application/json").post(ClientResponse.class, researcherJson);
		URI researcherLocation = researcherResponse.getLocation();
		List<URI> researchers = new ArrayList<URI>();
		researchers.add(researcherLocation);
		
		Person participant1 = new Person();
		participant1.setName("Claudio Aparecido");
		participant1.setEmail("c.aparecido248@gmail.com");
		Person participant2 = new Person();
		participant2.setName("Claudiana Silva");
		participant2.setEmail("clau.silva271@gmail.com");
		// POST participants
		String participant1Json = gson.toJson(participant1);
		String participant2Json = gson.toJson(participant2);
		WebResource participantResource = client.resource(REST_API_ADDRESS + "participants");
		ClientResponse participant1Response = participantResource.type("application/json").post(ClientResponse.class, participant1Json);
		ClientResponse participant2Response = participantResource.type("application/json").post(ClientResponse.class, participant2Json);
		URI participant1Location = participant1Response.getLocation();
		URI participant2Location = participant2Response.getLocation();
		List<URI> participants = new ArrayList<URI>();
		participants.add(participant1Location);
		participants.add(participant2Location);
		
		QuestionIntervention question1 = new QuestionIntervention();
		question1.setStatment("Qual o sobrenome da família de sua mãe?");
		question1.setObligatory(true);		
		question1.setOrderPosition(1);
		question1.setQuestionType(QuestionIntervention.QUESTION_TYPE_OPEN_TEXT);
		question1.setOptions(null);
		question1.setShowCondition(null);
		QuestionIntervention question2 = new QuestionIntervention();
		question2.setStatment("Escolha uma sobremesa");
		question2.setObligatory(false);		
		question2.setOrderPosition(2);
		question2.setQuestionType(QuestionIntervention.QUESTION_TYPE_RADIO);
		List<String> options = new ArrayList<String>();
		options.add("Sorvete");
		options.add("Pudim");
		options.add("Bolo");
		options.add("Mousse");
		question2.setOptions(options);
		question2.setShowCondition(null);
		// POST questions
		String question1Json = gson.toJson(question1);
		String question2Json = gson.toJson(question2);
		WebResource questionResource = client.resource(REST_API_ADDRESS + "question-interventions");
		ClientResponse question1Response = questionResource.type("application/json").post(ClientResponse.class, question1Json);
		ClientResponse question2Response = questionResource.type("application/json").post(ClientResponse.class, question2Json);
		URI question1Location = question1Response.getLocation();
		URI question2Location = question2Response.getLocation();
		List<URI> interventions = new ArrayList<URI>();
		interventions.add(question1Location);
		interventions.add(question2Location);
		
		SampleTrigger trigger = new SampleTrigger();
		trigger.setSampleType(SampleTrigger.TYPE_MANUAL);
		trigger.setTriggerCondition(null);		
		// POST trigger
		String triggerJson = gson.toJson(trigger);
		WebResource triggerResource = client.resource(REST_API_ADDRESS + "triggers");
		ClientResponse triggerResponse = triggerResource.type("application/json").post(ClientResponse.class, triggerJson);
		URI triggerLocation = triggerResponse.getLocation();
		List<URI> triggers = new ArrayList<URI>();
		triggers.add(triggerLocation);
				
		ActiveSample sample = new ActiveSample();
		sample.setTitle("Amostra Teste");
		sample.setDescription("Esta é uma amostra ativa de teste.");
		sample.setInterventions(interventions);
		sample.setSensors(new ArrayList<URI>());
		sample.setTriggers(triggers);
		// POST active-samples
		String sampleJson = gson.toJson(sample);
		WebResource sampleResource = client.resource(REST_API_ADDRESS + "active-samples");
		ClientResponse sampleResponse = sampleResource.type("application/json").post(ClientResponse.class, sampleJson);
		URI sampleLocation = sampleResponse.getLocation();
		List<URI> samples = new ArrayList<URI>();
		samples.add(sampleLocation);
		
		Experiment experiment = new Experiment();
		experiment.setDescription("Esse é um experimento de teste para saber se está ok.");
		experiment.setTitle("Meu experimento teste");
		ExperimentRestFacade experimentFacade = new ExperimentRestFacade();
		URI experimentLocation = experimentFacade.post(experiment);
		System.out.println(experimentLocation);
		
		experimentFacade.putRelationship(experimentLocation, participants.get(0));
		experimentFacade.putRelationship(experimentLocation, participants.get(1));
		experimentFacade.putRelationship(experimentLocation, researchers.get(0));
		experimentFacade.putRelationship(experimentLocation, samples.get(0));
		
		experimentFacade.getAll();
		
		experimentFacade.deleteRelationship(experimentLocation, participants.get(1));

	    System.out.println("SUCESSO");
	}

	void testPeople() {
		Client client = Client.create();

		Movie m = new Movie();
		Persona p = new Persona();
		m.setName("Final Feliz");
		m.setYear(2015);
		p.setFirstName("Maria2");
		p.setLastName("Silva2");

		Gson gson = new Gson();
		String personJson = gson.toJson(p);
		String movieJson = gson.toJson(m);

		WebResource personResource = client.resource("http://localhost:8080/people");
		WebResource movieResource = client.resource("http://localhost:8080/movies");

		// POST
		ClientResponse responseP = personResource.type("application/json").post(ClientResponse.class, personJson);
		URI ploc = responseP.getLocation();

		ClientResponse responseM = movieResource.type("application/json").post(ClientResponse.class, movieJson);
		URI mloc = responseM.getLocation();

		List<URI> l = new ArrayList<URI>();
		l.add(mloc);
		p.setMovies(l);
		personJson = gson.toJson(p);
		WebResource personMovieResource = client.resource(ploc);
		ClientResponse response = personMovieResource.type("application/json").put(ClientResponse.class, personJson);

		// GET
		// ClientResponse response =
		// webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200 && response.getStatus() != 201) {
			System.out.println("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}
}

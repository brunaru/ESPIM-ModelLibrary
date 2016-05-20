package br.usp.icmc.intermidia.esm.rest.api.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.event.ActiveEvent;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.event.ActiveEventRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionInterventionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.program.Program;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.program.ProgramRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.EventTrigger;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.EventTriggerRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ParticipantRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Person;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Observer;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ObserverRestFacade;

public class App {
	
	public static void main(String[] args) {
		testExperiment();
	}
	
	static void testExperiment() {		
		/*Observer researcher = new Observer();
		researcher.setName("Bruna Rodrigues");
		researcher.setEmail("brunaru7@gmail.com");
		researcher.setPassword("123456");
		// POST researcher
		ObserverRestFacade researcherFacade = new ObserverRestFacade();
		URI researcherLocation = researcherFacade.post(researcher);
		
		Person participant1 = new Person();
		participant1.setName("Claudio Aparecido");
		participant1.setEmail("c.aparecido248@gmail.com");
		Person participant2 = new Person();
		participant2.setName("Claudiana Silva");
		participant2.setEmail("clau.silva271@gmail.com");
		// POST participants
		ParticipantRestFacade participantFacade = new ParticipantRestFacade();
		URI participant1Location = participantFacade.post(participant1);
		URI participant2Location = participantFacade.post(participant2);
		
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
		QuestionInterventionRestFacade questionFacade = new QuestionInterventionRestFacade();
		URI question1Location = questionFacade.post(question1);
		URI question2Location = questionFacade.post(question2);
		
		EventTrigger trigger = new EventTrigger();
		trigger.setTriggerType(EventTrigger.TYPE_MANUAL);
		trigger.setTriggerCondition(null);		
		// POST trigger
		EventTriggerRestFacade triggerFacade = new EventTriggerRestFacade();
		URI triggerLocation = triggerFacade.post(trigger);

		ActiveEvent sample = new ActiveEvent();
		sample.setTitle("Amostra Teste");
		sample.setDescription("Esta é uma amostra ativa de teste.");
		// POST active-samples
		ActiveEventRestFacade activeSampleFacade = new ActiveEventRestFacade();
		URI sampleLocation = activeSampleFacade.post(sample);
		activeSampleFacade.putRelationship(sampleLocation, question1Location);
		activeSampleFacade.putRelationship(sampleLocation, question2Location);
		activeSampleFacade.putRelationship(sampleLocation, triggerLocation);
		
		Program experiment = new Program();
		experiment.setDescription("Esse é um experimento de teste para saber se está ok.");
		experiment.setTitle("Meu experimento teste");
		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		URI experimentLocation = experimentFacade.post(experiment);
				
		experimentFacade.putRelationship(experimentLocation, participant1Location);
		experimentFacade.putRelationship(experimentLocation, participant2Location);
		experimentFacade.putRelationship(experimentLocation, researcherLocation);
		experimentFacade.putRelationship(experimentLocation, sampleLocation);
		
		// TEST
		//experimentFacade.getAll();
		//experimentFacade.deleteRelationship(experimentLocation, participant2Location);*/
		
		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		ObserverRestFacade researcherFacade = new ObserverRestFacade();
		ParticipantRestFacade participantFacade = new ParticipantRestFacade();
		
		List<Program> pro1 = experimentFacade.findByObserversEmail("brunaru7@gmail.com");
		List<Program> pro2 = experimentFacade.findByParticipantsEmail("clau.silva271@gmail.com");
		Observer o = researcherFacade.findByEmail("brunaru7@gmail.com");
		Person p = participantFacade.findByEmail("clau.silva271@gmail.com");

		//System.out.println(experimentLocation);
	    System.out.println("SUCESSO");
	}
}

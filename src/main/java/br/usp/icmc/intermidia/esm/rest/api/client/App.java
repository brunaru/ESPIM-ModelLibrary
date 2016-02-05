package br.usp.icmc.intermidia.esm.rest.api.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment.Experiment;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment.ExperimentRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionInterventionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.sample.ActiveSample;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.sample.ActiveSampleRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.SampleTrigger;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.TriggerRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ParticipantRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Person;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Researcher;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ResearcherRestFacade;

public class App {
	
	public static void main(String[] args) {
		testExperiment();
	}
	
	static void testExperiment() {		
		Researcher researcher = new Researcher();
		researcher.setName("Bruna Rodrigues");
		researcher.setEmail("brunaru7@gmail.com");
		researcher.setPassword("123456");
		// POST researcher
		ResearcherRestFacade researcherFacade = new ResearcherRestFacade();
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
		
		SampleTrigger trigger = new SampleTrigger();
		trigger.setTriggerType(SampleTrigger.TYPE_MANUAL);
		trigger.setTriggerCondition(null);		
		// POST trigger
		TriggerRestFacade triggerFacade = new TriggerRestFacade();
		URI triggerLocation = triggerFacade.post(trigger);

		ActiveSample sample = new ActiveSample();
		sample.setTitle("Amostra Teste");
		sample.setDescription("Esta é uma amostra ativa de teste.");
		// POST active-samples
		ActiveSampleRestFacade activeSampleFacade = new ActiveSampleRestFacade();
		URI sampleLocation = activeSampleFacade.post(sample);
		activeSampleFacade.putRelationship(sampleLocation, question1Location);
		activeSampleFacade.putRelationship(sampleLocation, question2Location);
		activeSampleFacade.putRelationship(sampleLocation, triggerLocation);
		
		Experiment experiment = new Experiment();
		experiment.setDescription("Esse é um experimento de teste para saber se está ok.");
		experiment.setTitle("Meu experimento teste");
		ExperimentRestFacade experimentFacade = new ExperimentRestFacade();
		URI experimentLocation = experimentFacade.post(experiment);
				
		experimentFacade.putRelationship(experimentLocation, participant1Location);
		experimentFacade.putRelationship(experimentLocation, participant2Location);
		experimentFacade.putRelationship(experimentLocation, researcherLocation);
		experimentFacade.putRelationship(experimentLocation, sampleLocation);
		
		// TEST
		//experimentFacade.getAll();
		//experimentFacade.deleteRelationship(experimentLocation, participant2Location);

		System.out.println(experimentLocation);
	    System.out.println("SUCESSO");
	}
}

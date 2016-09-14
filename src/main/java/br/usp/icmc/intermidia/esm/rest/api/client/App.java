package br.usp.icmc.intermidia.esm.rest.api.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.event.ActiveEvent;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.event.ActiveEventRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.ComplexCondition;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.EmptyIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.EmptyInterventionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.QuestionInterventionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.TaskIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.TaskInterventionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.program.Program;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.program.ProgramRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.EventTrigger;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.EventTriggerRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Observer;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ObserverRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.ParticipantRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.user.Person;

public class App {

	public static void main(String[] args) {
		testExperiment();
	}

	static void testExperiment() {

		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		List<Program> programs = experimentFacade.getAll();
		if (programs == null || programs.isEmpty()) {
			populate();
		}

		//ObserverRestFacade researcherFacade = new ObserverRestFacade();
		//ParticipantRestFacade participantFacade = new ParticipantRestFacade();
		//List<Program> pros1 = experimentFacade.findByObserversEmail("brunaru@icmc.usp.br");
		//List<Program> pros2 = experimentFacade.findByParticipantsEmail("clau.silva271@gmail.com");
		//Observer o = researcherFacade.findByEmail("brunaru@icmc.usp.br");
		//Person p = participantFacade.findByEmail("brunaru7@gmail.com");
		//Program ptest = experimentFacade.get((long) 1);
		//Person p2 = participantFacade.get((long) 22);
		System.out.println("SUCESSO");
	}

	private static void populate() {
		Observer researcher = new Observer();
		researcher.setName("Bruna Rodrigues");
		researcher.setEmail("brunaru@icmc.usp.br");
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
		Person participant3 = new Person();
		participant3.setName("Bruna Rodrigues");
		participant3.setEmail("brunaru7@gmail.com");
		Person participant4 = new Person();
		participant4.setName("Intermidia Lab");
		participant4.setEmail("intermidia.icmc.usp.br@gmail.com");
		// POST participants
		ParticipantRestFacade participantFacade = new ParticipantRestFacade();
		URI participant1Location = participantFacade.post(participant1);
		URI participant2Location = participantFacade.post(participant2);
		URI participant3Location = participantFacade.post(participant3);
		URI participant4Location = participantFacade.post(participant4);

		QuestionIntervention question1 = new QuestionIntervention();
		question1.setStatment("Qual o sobrenome da família de sua mãe?");
		question1.setObligatory(true);
		question1.setOrderPosition(1);
		question1.setNext(2);
		question1.setFirst(true);
		question1.setQuestionType(QuestionIntervention.QUESTION_TYPE_OPEN_TEXT);
		question1.setOptions(null);
		question1.setConditions(null);
		
		QuestionIntervention question2 = new QuestionIntervention();
		question2.setStatment("Escolha uma sobremesa:");
		question2.setObligatory(false);
		question2.setOrderPosition(2);
		question2.setNext(3);
		question2.setQuestionType(QuestionIntervention.QUESTION_TYPE_RADIO);
		List<String> options2 = new ArrayList<String>();
		options2.add("Sorvete");
		options2.add("Pudim");
		options2.add("Bolo");
		options2.add("Mousse");
		question2.setOptions(options2);
		Map<String, Integer> conditions = new HashMap<>();
		conditions.put("Bolo", 4);
		question2.setConditions(conditions);
		ComplexCondition c = new ComplexCondition();
		c.setCondition("");
		c.setType("simple");
		c.setNext(4);
		c.setValue("Bolo");
		List<ComplexCondition> cs = new ArrayList<ComplexCondition>();
		cs.add(c);
		question2.setComplexConditions(cs);
		
		QuestionIntervention question3 = new QuestionIntervention();
		question3.setStatment("Porque não escolheu bolo?");
		question3.setObligatory(true);
		question3.setOrderPosition(3);
		question3.setNext(4);
		question3.setQuestionType(QuestionIntervention.QUESTION_TYPE_OPEN_TEXT);
		question3.setOptions(null);
		question3.setConditions(null);
		
		TaskIntervention task = new TaskIntervention();
		task.setStatment("Jogue por 3 minutos. Pressione o botão para iniciar o jogo.");
		task.setObligatory(false);
		task.setOrderPosition(4);
		task.setNext(5);
		task.setAppPackage("br.usp.icmc.intermidia.memorygame");
		
		EmptyIntervention message = new EmptyIntervention();
		message.setStatment("Parabéns por completar a tarefa!");
		message.setObligatory(false);
		message.setOrderPosition(5);
		message.setNext(6);

		QuestionIntervention question4 = new QuestionIntervention();
		question4.setStatment("Escolha um ou mais sabores:");
		question4.setObligatory(false);
		question4.setOrderPosition(6);
		question4.setNext(0);
		question4.setQuestionType(QuestionIntervention.QUESTION_TYPE_CHECKBOX);
		List<String> options4 = new ArrayList<String>();
		options4.add("Chocolate");
		options4.add("Morango");
		options4.add("Limão");
		options4.add("Maracujá");
		question4.setOptions(options4);
		question4.setConditions(null);

		// POST questions
		QuestionInterventionRestFacade questionFacade = new QuestionInterventionRestFacade();
		URI question1Location = questionFacade.post(question1);
		URI question2Location = questionFacade.post(question2);
		URI question3Location = questionFacade.post(question3);
		URI question4Location = questionFacade.post(question4);
		// POST task
		TaskInterventionRestFacade taskFacade = new TaskInterventionRestFacade();
		URI taskLocation = taskFacade.post(task);
		// POST message
		EmptyInterventionRestFacade emptyFacade = new EmptyInterventionRestFacade();
		URI messageLocation = emptyFacade.post(message);

		EventTrigger trigger = new EventTrigger();
		trigger.setTriggerType(EventTrigger.TYPE_TIME);
		trigger.setTriggerCondition("0 0 20 ? * 1,2,3,4,5 *");
		// POST trigger
		EventTriggerRestFacade triggerFacade = new EventTriggerRestFacade();
		URI triggerLocation = triggerFacade.post(trigger);

		ActiveEvent sample = new ActiveEvent();
		sample.setTitle("Questões");
		sample.setDescription("Esta é uma intervenção que possui questões teste.");
		// POST active-samples
		ActiveEventRestFacade activeSampleFacade = new ActiveEventRestFacade();
		URI sampleLocation = activeSampleFacade.post(sample);
		activeSampleFacade.putRelationship(sampleLocation, question1Location);
		activeSampleFacade.putRelationship(sampleLocation, question2Location);
		activeSampleFacade.putRelationship(sampleLocation, question3Location);
		activeSampleFacade.putRelationship(sampleLocation, question4Location);
		activeSampleFacade.putRelationship(sampleLocation, taskLocation);
		activeSampleFacade.putRelationship(sampleLocation, messageLocation);
		activeSampleFacade.putRelationship(sampleLocation, triggerLocation);

		Program experiment = new Program();
		experiment.setDescription("Esse é um experimento para testes.");
		experiment.setTitle("Experimento Teste");
		Long time = new Date().getTime();
		experiment.setUpdateDate(String.valueOf(time));
		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		URI experimentLocation = experimentFacade.post(experiment);

		experimentFacade.putRelationship(experimentLocation, participant1Location);
		experimentFacade.putRelationship(experimentLocation, participant2Location);
		experimentFacade.putRelationship(experimentLocation, participant3Location);
		experimentFacade.putRelationship(experimentLocation, participant4Location);		
		experimentFacade.putRelationship(experimentLocation, researcherLocation);
		experimentFacade.putRelationship(experimentLocation, sampleLocation);

		// exemplo delete relacionamento
		// experimentFacade.deleteRelationship(experimentLocation, participant2Location);
	}

}

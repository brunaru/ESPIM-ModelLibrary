package br.usp.icmc.intermidia.esm.rest.api.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usp.icmc.intermidia.esm.rest.api.client.model.event.ActiveEvent;
import br.usp.icmc.intermidia.esm.rest.api.client.model.event.Event;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.ComplexCondition;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.EmptyIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.Intervention;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.MediaIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.MediaPresentation;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.QuestionIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.TaskIntervention;
import br.usp.icmc.intermidia.esm.rest.api.client.model.program.Program;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.program.ProgramRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.QuestionResult;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.Result;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.ResultsSession;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.result.ResultsSessionRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.trigger.EventTrigger;
import br.usp.icmc.intermidia.esm.rest.api.client.model.user.Observer;
import br.usp.icmc.intermidia.esm.rest.api.client.model.user.Person;

public class App {

	public static void main(String[] args) {
		testExperiment();
	}

	@SuppressWarnings("unused")
	static void testExperiment() {

		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		//ObserverRestFacade of = new ObserverRestFacade();
		//List<Observer> observers = of.getAll();
		//Observer observer = of.findByEmail("brunaru@icmc.usp.br");
		//List<Program> programs = experimentFacade.getAll();
		List<Program> programs = experimentFacade.findByParticipantsEmail("diana.interm@gmail.com");
		//programs = experimentFacade.findByObserversEmail("brunaru@icmc.usp.br");
		
		if (programs == null || programs.isEmpty()) {
			populate();
			//populate2();
		}
		populateResults();
		System.out.println("SUCESSO");
	}

	private static void populate() {
		Observer researcher = new Observer();
		researcher.setName("Bruna Rodrigues");
		researcher.setEmail("brunaru@icmc.usp.br");
		researcher.setRole("adm");
		List<Observer> observers = new ArrayList<>();
		observers.add(researcher);

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
		participant4.setName("Diana Intermidia Lab");
		participant4.setEmail("diana.interm@gmail.com");
		List<Person> participants = new ArrayList<>();
		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);

		QuestionIntervention question1 = new QuestionIntervention();
		question1.setStatement("Quais os nomes das pessoas com as quais você conversou hoje?");
		List<MediaPresentation> medias = new ArrayList<>();
		MediaPresentation media = new MediaPresentation();
		media.setMediaUrl("http://www.w3schools.com/tags/horse.mp3");
		media.setType(MediaPresentation.MEDIA_TYPE_AUDIO);
		medias.add(media);
		question1.setMedias(medias);
		question1.setObligatory(true);
		question1.setOrderPosition(1);
		question1.setNext(2);
		question1.setFirst(true);
		question1.setQuestionType(QuestionIntervention.QUESTION_TYPE_OPEN_TEXT);
		
		QuestionIntervention question2 = new QuestionIntervention();
		question2.setStatement("O vídeo a seguir apresenta receitas de doces. Escolha um doce:");
		List<MediaPresentation> medias2 = new ArrayList<>();
		MediaPresentation media2 = new MediaPresentation();
		media2.setMediaUrl("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
		media2.setType(MediaPresentation.MEDIA_TYPE_VIDEO);
		medias2.add(media2);
		question2.setMedias(medias2);
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
		question3.setStatement("Porque não escolheu bolo?");
		question3.setObligatory(true);
		question3.setOrderPosition(3);
		question3.setNext(4);
		question3.setQuestionType(QuestionIntervention.QUESTION_TYPE_OPEN_TEXT);
		
		TaskIntervention task = new TaskIntervention();
		task.setStatement("Jogue por 3 minutos. Pressione o botão para iniciar o jogo.");
		task.setObligatory(false);
		task.setOrderPosition(4);
		task.setNext(5);
		task.setAppPackage("br.usp.icmc.intermidia.memorygame");
		
		EmptyIntervention message = new EmptyIntervention();
		message.setStatement("Parabéns por completar a tarefa!");
		message.setObligatory(false);
		message.setOrderPosition(5);
		message.setNext(6);

		QuestionIntervention question4 = new QuestionIntervention();
		question4.setStatement("Escolha um ou mais sabores:");
		question4.setObligatory(false);
		question4.setOrderPosition(6);
		question4.setNext(7);
		question4.setQuestionType(QuestionIntervention.QUESTION_TYPE_CHECKBOX);
		List<String> options4 = new ArrayList<String>();
		options4.add("Chocolate");
		options4.add("Morango");
		options4.add("Limão");
		options4.add("Maracujá");
		question4.setOptions(options4);
		
		MediaIntervention mediaIntervention1 = new MediaIntervention();
		mediaIntervention1.setStatement("Por favor, tire uma foto de sua refeição.");
		mediaIntervention1.setObligatory(false);
		mediaIntervention1.setOrderPosition(7);
		mediaIntervention1.setNext(8);
		mediaIntervention1.setMediaType(MediaIntervention.MEDIA_TYPE_IMAGE);
		
		MediaIntervention mediaIntervention2 = new MediaIntervention();
		mediaIntervention2.setStatement("Por favor, grave um vídeo relatando quais atividades você realizou hoje.");
		mediaIntervention2.setObligatory(false);
		mediaIntervention2.setOrderPosition(8);
		mediaIntervention2.setNext(0);
		mediaIntervention2.setMediaType(MediaIntervention.MEDIA_TYPE_VIDEO);
		
		List<Intervention> interventions = new ArrayList<>();
		interventions.add(question1);
		interventions.add(question2);
		interventions.add(question3);
		interventions.add(question4);
		interventions.add(task);
		interventions.add(message);
		interventions.add(mediaIntervention1);
		interventions.add(mediaIntervention2);

		EventTrigger trigger = new EventTrigger();
		trigger.setTriggerType(EventTrigger.TYPE_TIME);
		trigger.setTriggerCondition("0 0 20 ? * 1,2,3,4,5 *");
		List<EventTrigger> triggers = new ArrayList<>();

		ActiveEvent sample = new ActiveEvent();
		sample.setTitle("Questões");
		sample.setDescription("Esta é uma intervenção que possui questões teste.");
		sample.setInterventions(interventions);
		sample.setTriggers(triggers);
		List<Event> events = new ArrayList<>();
		events.add(sample);

		Program experiment = new Program();
		experiment.setDescription("Esse é um experimento para testes.");
		experiment.setTitle("Experimento Teste");
		Long time = new Date().getTime();
		experiment.setUpdateDate(String.valueOf(time));
		ProgramRestFacade experimentFacade = new ProgramRestFacade();
		experiment.setParticipants(participants);
		experiment.setObservers(observers);
		experiment.setEvents(events);
		experimentFacade.post(experiment, true);
	}
	
	@SuppressWarnings("unused")
	private static void populateResults() {
		QuestionResult qr = new QuestionResult();
		qr.setAnswer("Maria apenas.");
		qr.setQuestion(2);
		qr.setStarted("1234");
		qr.setEnded("1235");		
		List<Result> results = new ArrayList<>();
		results.add(qr);
		ResultsSession rs = new ResultsSession();
		rs.setId((long) 1);
		rs.setParticipant(4);
		rs.setEvent(1);
		rs.setResults(results);		
		ResultsSessionRestFacade rsf = new ResultsSessionRestFacade();
		String rjson = rsf.post(rs, true);
	}

}

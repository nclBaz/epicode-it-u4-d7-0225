import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		// ArrayList<User> usersList = new ArrayList<>(); // Nelle parentesi angolari andrò a specificare il tipo di dato che voglio venga salvato nella lista
		List<User> usersList = new LinkedList<>(); // UPCASTING. E' una tecnica avanzata che consente di "tenere una porta aperta per il futuro". Nel
		// senso che se un domani volessi sostituire l'ArrayList con un altro tipo di List, come ad es. una Linked List, lo potrei fare cambiando
		// solo il tipo della classe e non 10000 righe di codice.
		// Se utilizzassi solo metodi specifici di ArrayList purtroppo non potrei fare questa cosa però.
		// L'upcasting lo uso quando so che utilizzerò metodi comuni ai vari tipi di liste
		// Le Linked List sono più performanti in termini di aggiunte/rimozioni (quando parliamo di grossi numeri) rispetto alle ArrayList, di contro
		// però queste ultime sono ben più compatte e quindi più efficienti dal punto di vista della memoria utilizzata

		// ----------------------------------------------------- ADD -------------------------------------------------------------
		// Permette di aggiungere elementi o in coda, o specificando un indice/posizione che di conseguenza shifta tutti gli altri elementi
		System.out.println("La lista ha " + usersList.size() + " elementi");
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(1, new User("Ajeje", "Brazorf"));
		// alternative usersList.addFirst(); usersList.addLast();

		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println(usersList);

		for (User user : usersList) {
			System.out.println(user.getName());
		}

		System.out.println("---------------------------------------------- GET --------------------------------------------------------");
		// Dato l'indice mi restituisce l'elemento (occhio a non uscire dai limiti della lista)

		try {
			User found = usersList.get(2); // IndexOutOfBoundsException
			System.out.println(found.getName());
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Utente non trovato!");
		}

		System.out.println("---------------------------------------------- INDEX OF --------------------------------------------------------");
		// Dato un utente ci restituisce il suo indice all'interno della lista
		System.out.println("L'indice di Giovanni è: " + usersList.indexOf(giovanni));

		System.out.println("---------------------------------------------- CONTAINS --------------------------------------------------------");
		// Ci restituisce un booleano che permette di stabilire se un certo elemento sia presente nella lista o meno
		User aldo2 = new User("Aldo", "Baglio");
		if (usersList.contains(aldo2)) {
			// .contains() sotto il cofano utilizza il metodo .equals degli oggetti di tipo User.
			// Di default quindi controllerà se 2 oggetti sono nella stessa cella di memoria
			// Se non mi stesse bene tale comportamento posso effettuare un override di .equals
			System.out.println("La lista contiene l'elemento Aldo " + usersList.indexOf(aldo));
		} else {
			System.out.println("La lista NON contiene Aldo");
		}
		System.out.println(usersList);

		System.out.println("---------------------------------------------- REMOVE --------------------------------------------------------");
		// Remove permette di togliere un elemento dalla lista specificando o l'indice o l'elemento da eliminare.
		usersList.remove(aldo);
		usersList.remove(1);
		usersList.removeFirst();
		usersList.removeLast();

		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println("---------------------------------------------- ADD ALL --------------------------------------------------------");
		// AddAll ci consente di aggiungere con un'unica operazione tanti elementi ad una lista.
		User[] users = {aldo, giovanni, giacomo};
		usersList.addAll(List.of(users)); // Se parto da un array devo prima convertirlo in lista tramite List.of()
		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println("---------------------------------------------- REMOVE ALL --------------------------------------------------------");
		User[] usersToRemove = {aldo, giacomo};
		usersList.removeAll(List.of(usersToRemove));
		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println("---------------------------------------------- SET --------------------------------------------------------");
		// Set serve per rimpiazzare un elemento in una posizione specifica con un altro
		usersList.set(0, new User("Ajeje", "Brazorf"));
		System.out.println(usersList);

		System.out.println("---------------------------------------------- CLEAR --------------------------------------------------------");
		// Clear svuota completamente una lista
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear();
		System.out.println("La lista è vuota? " + usersList.isEmpty());

		// ***************************************************** COLLECTIONS E TIPI PRIMITIVI *******************************************************
		// ArrayList<int> interi = new ArrayList<>(); // <- Non posso creare collections di tipi primitivi
		// Posso però utilizzare le cosiddette WRAPPER CLASSES, ovvero classi che corrispondono ai tipi primitivi. Ogni tipo primitivo avrà la sua:
		// Integer, Double, Boolean, Byte, Short,.....
		ArrayList<Integer> numeriInteri = new ArrayList<>();
		numeriInteri.add(10);
		numeriInteri.add(100);

		// ************************************************** RIMUOVERE ELEMENTI DA UNA LISTA DURANTE UN CICLO ***************************************
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e")); // Lista creata con già 5 elementi
		/* lettere.add("a");
		lettere.add("b");
		lettere.add("c");
		lettere.add("d");
		lettere.add("e"); */

		// Non si possono rimuovere elementi mentre si sta ciclando una collection! (ConcurrentModificationException)
		/* for (String lettera : lettere) {
			if (lettera.equals("c")) lettere.remove(lettera);
			else System.out.println(lettera);
		} */

		// Per poter rimuovere elementi durante un ciclo bisognerebbe utilizzare il cosiddetto ITERATOR
		Iterator<String> iterator = lettere.iterator(); // Ogni collection mi può fornire il proprio ITERATOR
		while (iterator.hasNext()) { // Vai avanti fino a che ci sono elementi
			String lettera = iterator.next(); // iterator.next() mi restituisce sempre l'elemento corrente dell'iterazione
			System.out.println(lettera);
			if (lettera.equals("c")) iterator.remove(); // N.B. non sto facendo lettere.remove(), bensì iterator.remove()! altrimenti avrei
			// lo stesso problema di sopra (ConcurrentModificationException). Utilizzo l'iterator perché è tramite questo oggetto speciale
			// che posso effettuare in maniera safe la rimozione di un elemento durante l'iterazione e lui si occuperà di "rimettere assieme i pezzi"
			// della lista
		}

		System.out.println(lettere);

		// ******************************************************** SET *******************************************************************
		/* I SET a differenza delle Liste NON AMMETTONO DUPLICATI. Per poterci dare questa funzionalità però ad ogni inserimento (tramite add() )
		dovrà andare a iterare elemento per elemento per verificare se quell'elemento esiste già, se non c'è lo inserisce altrimenti ci torna false
		*/
		HashSet<User> usersSet = new HashSet<>();
		// Set<User> usersSet = new HashSet<>(); <-- Anche qua volendo potrei usare l'upcasting
		// Alternativa a HashSet è LinkedHashSet che mantiene anche un ordine di inserimento degli elementi
		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		usersSet.add(aldo); // Aggiungere un duplicato non è vietato nel senso che non riceverò un'eccezione. Mi viene però segnalato da IntellIJ
		// con un warning che è un'operazione sprecata in quanto il Set non aggiungerà tale elemento
		usersSet.add(aldo2);
		System.out.println(usersSet);

		TreeSet<String> alfabeto = new TreeSet<>(); // Non ammette duplicati ma inoltre ordina gli elementi (operazione molto costosa quindi
		// se non necessaria meglio usare un altro tipo di Set)
		alfabeto.add("z");
		alfabeto.add("c");
		alfabeto.add("a");
		alfabeto.add("h");
		alfabeto.add("c");

		System.out.println(alfabeto);

		alfabeto.add("p");
		alfabeto.add("b");

		System.out.println(alfabeto);

		// ****************************************************************** MAP ************************************************************
		// Le Map sono strutture dati caratterizzate da elementi costituiti da coppie di <CHIAVE, VALORE>. Nelle Map quindi dovrò, in fase di creazione,
		// andare a specificare di che tipo sarà la Chiave e di che tipo sarà il valore. Le chiavi devono essere UNICHE

		// "Albero" - "Definizione di albero"
		// "Casa" - "Definizione di casa"
		// "Barbagianni" - "Definizione di barbagianni"
		HashMap<String, String> dizionario = new HashMap<>();
		dizionario.put("Albero", "Definizione di albero"); // Quando aggiungo nuovi elementi devo passare sia chiave che valore rispettando i tipi
		dizionario.put("Casa", "Definizione di casa");
		dizionario.put("Barbagianni", "Definizione di barbagianni");
		System.out.println(dizionario);

		HashMap<Integer, User> usersMap = new HashMap<>();
		// 123123 - Aldo Baglio
		// 123124 - Giovanni Storti
		// 123125 - Giacomo Poretti
		usersMap.put(123123, aldo);
		usersMap.put(123124, giovanni);
		usersMap.put(123123, giacomo); // Se la chiave esiste già sto SOSTITUENDO l'elemento preesistente con quello nuovo
		System.out.println(usersMap);

		System.out.println("---------------------------------------------- LEGGERE ELEMENTI --------------------------------------------");
		String barbagianni = dizionario.get("Barbagianni");
		System.out.println(barbagianni);
		User fromMap = usersMap.get(123126);
		if (fromMap != null) // meglio prevenire che curare
			System.out.println(fromMap.getName());
		else System.out.println("Non trovato");

		System.out.println("---------------------------------------------- LEGGERE ELEMENTI --------------------------------------------");
		dizionario.remove("Casa"); // Anche per rimuovere specifico la chiave
		System.out.println(dizionario);

		System.out.println("---------------------------------------------- SOSTITUIRE UN ELEMENTO --------------------------------------------");
		dizionario.replace("Barbagianni", "Definizione aggiornata di Barbagianni"); // Non aggiunge un elemento se non lo trova, mi tornerà null in quel caso

		System.out.println("---------------------------------------------- OTTENERE ELENCO DELLE CHIAVI --------------------------------------------");
		Set<String> elencoChiavi = dizionario.keySet();
		System.out.println(elencoChiavi);
		for (String chiave : elencoChiavi) {
			System.out.println("Chiave: " + chiave);
			System.out.println("Valore: " + dizionario.get(chiave));
		}

		System.out.println("---------------------------------------------- OTTENERE ELENCO DEI VALORI --------------------------------------------");
		Collection<String> valori = dizionario.values();
		System.out.println(valori);
		
	}
}

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		ArrayList<User> usersList = new ArrayList<>(); // Nelle parentesi angolari andrò a specificare il tipo di dato che voglio venga salvato nella lista

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
	}
}

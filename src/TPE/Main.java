package TPE;

import java.util.ArrayList;

public class Main {
	final static String path500k = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/dataset_24.csv";
	final static String path1m = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/dataset_1000000.csv";
	final static String path3m = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/dataset_3000000.csv";
	final static String pathNew = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/dataset_insert_10000.csv";
	final static String pathSearch = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/dataset_busqueda_10000.csv";
	final static String resultSearch = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/salidabusqueda.csv";
	final static String resultUploading = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/salidaalta.csv";

	public static void main(String[] args) {
		UserLinkedList userP = new UserLinkedList(true, path500k); 
		userP.searchUsers(pathSearch);
		
	}
	}
		/*
		ArrayList<User> load500k = new ArrayList<User>();
		ArrayList<User> load1m = new ArrayList<User>();
		ArrayList<User> load3m = new ArrayList<User>();
		ArrayList<User> searchUsers = new ArrayList<User>();
		ArrayList<User> newUsers = new ArrayList<User>();

		UserLinkedList ullf = new UserLinkedList(false);
		UserLinkedList ulll = new UserLinkedList(true);
		UserArray ua;
		CSVReader csvr = new CSVReader();
		load500k = csvr.reader(path500k);
		System.out.println("read 500");
		//load1m = csvr.reader(path1m);
		//System.out.println("read 1");
		//load3m = csvr.reader(path3m);
		//System.out.println("read 3");
		searchUsers = csvr.reader(pathSearch);
		System.out.println("read search");
		// 500k
		
		ullf.addUsers(load500k);
		System.out.println("add 500 ullf");
	
		ulll.addUsers(load500k);
		System.out.println("add 500 ulll");
		ua = new UserArray();
		ua.addUsers(load500k);
		System.out.println("add 500 ua");
		ullf.searchUsers(searchUsers);
		System.out.println("search ullf");
		ulll.searchUsers(searchUsers);
		System.out.println("search ulll");
		ua.searchUsers(searchUsers);
		System.out.println("search ua");
		// 1m
		ullf = new UserLinkedListFirst();
		ullf.addUsers(load1m);
		ulll = new UserLinkedListLast();
		ulll.addUsers(load1m);
		ua = new UserArray();
		ua.addUsers(load1m);
		ullf.searchUsers(searchUsers);
		ulll.searchUsers(searchUsers);
		ua.searchUsers(searchUsers);
		// 1m
		ullf = new UserLinkedListFirst();
		ullf.addUsers(load3m);
		ulll = new UserLinkedListLast();
		ulll.addUsers(load3m);
		ua = new UserArray();
		ua.addUsers(load3m);
		ullf.searchUsers(searchUsers);
		ulll.searchUsers(searchUsers);
		ua.searchUsers(searchUsers);
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter(resultSearch);
		csvw.write(searchUsers);
		System.out.println("termino");
	}

	private static void loadUsers(UserArray ua, UserLinkedList ulll, UserLinkedList ullf,
			ArrayList<User> newUsers) {
		readUsers(pathNew, newUsers);
		ullf.addUsers(newUsers);
		ulll.addUsers(newUsers);
		ua.addUsers(newUsers);
		saveResult(resultUploading, newUsers);
	}

	private static void searchUsers() {

	}

	private static void readUsers(String path, ArrayList<User> users) {
		CSVReader csvr = new CSVReader();
		users = csvr.reader(path);
	}

	private static void saveResult(String path, ArrayList<User> users) {
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter(path);
		csvw.write(users);
	}
}*/
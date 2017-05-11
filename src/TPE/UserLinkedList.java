package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedList implements IUserList {
	String pathLista = "";
	final String resultSearch = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/salidabusqueda.csv";
	final String resultUploading = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial-master/datasets/salidaalta.csv";
	private User first;
	private User last;
	private int size = 0;
	String csvSplitBy = ";";
	private boolean insertarAlPrincipio = false; // si isertarAlPrincipio =
													// true, inserta al inicio,
													// de lo contrario,
													// insertará al final(por
													// defecto)
	private CSVReader csvr = new CSVReader();
	private CSVWritter csvw = new CSVWritter();

	public UserLinkedList(boolean insertarAlPrincipio, String pathLista) {
		this.insertarAlPrincipio = insertarAlPrincipio;
		this.pathLista = pathLista;
		cargarUsuarios();
	}

	public void insertarUsuario(User usuario) {
		if (insertarAlPrincipio) {
			insertarUsuarioAlPrincipio(usuario);
		} else {
			insertarUsuarioAlFinal(usuario);
		}

	};

	private void insertarUsuarioAlPrincipio(User user) {
		user.setNext(first);
		first = user;
		size++;
	}

	private void insertarUsuarioAlFinal(User user) {
		if (first == null) {
			first = user;
			last = first;
		} else {
			last.setNext(user);
			last = user;
		}
		size++;
	}
	
	@Override
	public void altaUsuarios(ArrayList<User> users) {
		// TODO Auto-generated method stub
		Date init = new Date();
		for (User user : users) {
			insertarUsuario(user);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeLast("500k", result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println(result);
	}

	private void cargarUsuarios() {
		ArrayList<String> aux = new ArrayList<String>();
		String[] auxs = this.csvr.reader(pathLista);
		for (String string : auxs) {
			aux.add(string);
		}
		
		for (String usuarioSt : aux) {
			User user = crearUsuario(usuarioSt);
			insertarUsuarioAlPrincipio(user);
		}
	}
	private User crearUsuario(String usuarioSt){
		User user = new User();
		String[] atributosUsuario = usuarioSt.split(csvSplitBy);
		user.setUserId(atributosUsuario[0].toString());
		for (int i = 1; i < atributosUsuario.length - 1; i++) {
			user.addInterest(atributosUsuario[i].toString());
		}
		return user;
	}

	@Override
	public void searchUsers(String pathABuscar) {
		String[] usuarios = csvr.reader(pathABuscar);
		ArrayList<String> usersQuery = new ArrayList<String>();
		for (String string : usuarios) {
			usersQuery.add(string);
		}
		 
		ArrayList<User> usuariosABuscar = new ArrayList<User>();
		for (String usuarioSt : usersQuery) {
			User user = crearUsuario(usuarioSt);
			user.setExists(false);
			boolean found = false;
			User userTemp = first;
			Date init = new Date();
			int i = 0;
			while (!found && (i < size)) {
				if (userTemp.getUserId().equals(user.getUserId())) {
					found = true;
					user.setExists(true);
				} else {
					if (userTemp.hasNext()) {
						userTemp = userTemp.getNext();
					}
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			saveResult(user, size, result);
			usuariosABuscar.add(user);
		}
		
		ArrayList<String> temp = new ArrayList<String>();
		String[] temps = this.csvr.reader(resultSearch);
		
		for (String string : temps) {
			temp.add(string);
		}
		temp.add("---------------" + "Lista nodos tamaño:" + this.size + "---------------");
		for (User usuario : usuariosABuscar) {
			temp.add(usuario.toString());
		}
		csvw.write(temp);///SEGUIR DESDE ACÁ CAMBIAR PARA QUE WRITER ACEPTE STRINGSSS
	}

	@Override
	public void saveResult(User user, int size, long result) {
		if (size <= 500000) {
			user.setTimeFirst("500k", result);
		} else if (size <= 1000000) {
			user.setTimeFirst("1m", result);
		} else if (size > 3000000) {
			user.setTimeFirst("3m", result);

		}

	}

}

package connectionTest;

import java.util.ArrayList;

public class ConnectionController {
	private ArrayList<DatabaseConnector> connections = new ArrayList<DatabaseConnector>();

	public ArrayList<DatabaseConnector> getConnections() {
		return connections;
	}

	public void addConnection(DatabaseConnector connection) {
		this.connections.add(connection);
	}
	
	public void deleteConnection(DatabaseConnector connection) {
		this.connections.remove(connection);
	}
	
	

}

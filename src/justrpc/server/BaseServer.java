package justrpc.server;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

import justrpc.rpc.Procedure;

public class BaseServer {
	private ArrayList<Procedure> procList = new ArrayList<Procedure>();
	private HashMap<String, Procedure> procDict = new HashMap<String, Procedure>();
	
	protected ServerSocket serverSocket;
	protected String host;
	protected int port;
    
	public BaseServer(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	public void register(Procedure proc){
		this.procList.add(proc);
		this.procDict.put(proc.getName(), proc);
	}
	
}

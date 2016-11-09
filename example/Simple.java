import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import justrpc.rpc.RPCClient;
import justrpc.rpc.RPCServer;

class SimpleClient extends RPCClient{
	
}

public class Simple extends Thread {
	
	public static void main(String[] args){
		try {
			RPCServer server = new RPCServer("127.0.0.1", 9527);
			server.run();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
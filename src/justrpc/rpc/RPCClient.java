package justrpc.rpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class ClientSession implements Runnable{
	
	Socket sock;
	BufferedReader reader;
	BufferedWriter writer;
	
	public ClientSession(Socket sock){
		this.sock = sock;
	}
	
	
	
	@Override
	public void run(){
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

public class RPCClient {
	
	public ClientSession connect(String host, int port){
		try {
			return new ClientSession(new Socket(host, port));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

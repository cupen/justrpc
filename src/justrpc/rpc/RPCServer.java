package justrpc.rpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import justrpc.server.BaseServer;

class Session implements Runnable{
	
	protected Socket sock;

	public Session(Socket sock){
		this.sock = sock;
	}
	
	public void close(){
		try {
			this.sock.close();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		
			String text = reader.readLine();
			if (text.equals("close")){
				reader.close();
				writer.close();
				sock.close();
			}
			writer.write(reader.readLine());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class RPCServer extends BaseServer{
	
	private ExecutorService executor;
	
	public RPCServer(String host, int port) {
		super(host, port);
	}
	
	public void run() throws UnknownHostException{
		try {
			InetAddress iaddr = InetAddress.getByName(this.host);
			this.serverSocket = new ServerSocket(this.port, 50, iaddr);
			while(true) {
				Socket sock = this.serverSocket.accept();
				Session session = new Session(sock);
				this.getSessionPool().execute(session);
			}
			
		} catch (UnknownHostException e) {
			throw e;
//			e.printStackTrace();
			
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	}
	
	public ExecutorService getSessionPool(){
		if (this.executor == null){
			this.executor = Executors.newCachedThreadPool();
		}
		return this.executor;
	}
	
}
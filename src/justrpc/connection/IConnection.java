package justrpc.connection;

import java.io.InputStream;
import java.io.OutputStream;

interface IConnection {
	
	public InputStream getInputStream();
	public OutputStream getOutputStream();

}

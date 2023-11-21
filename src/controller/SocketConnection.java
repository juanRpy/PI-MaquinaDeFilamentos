package controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketConnection {
	
	private ServerSocket socketServer;
    private Thread serverThread = null;
    private String msg;
    private volatile boolean isServerRunning = true;
    
    public SocketConnection() {
    	try {
            socketServer = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void Data() {
    	if (serverThread == null || !serverThread.isAlive()) {
            serverThread = new Thread(() -> {
                while (isServerRunning) {
                    try (Socket socket = socketServer.accept();
                         Scanner input = new Scanner(socket.getInputStream())) {

                        while (input.hasNextLine()) {
                            msg = input.nextLine();
                        }
                        
                        Thread.sleep(500);

                    } catch (IOException | InterruptedException e) {
                        if (!isServerRunning) {
                            // Si el servidor se está cerrando, la excepción SocketException es esperada
                            break;
                        } else {
                            e.printStackTrace();
                        }
                    }
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();
        }
    }
    

    public void sendPackage(String packageToSend) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("172.20.10.2", 5000);

                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                if (output != null) {
                    output.writeUTF(packageToSend);
                    socket.close(); // Cierra el socket después de enviar el paquete
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    public void stop() throws IOException {
    	isServerRunning = false;
    	socketServer.close();
	}


	public String getMsg() {
		return msg;
	}
	
	
    	
	
}


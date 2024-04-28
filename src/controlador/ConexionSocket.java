package controlador;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConexionSocket {
	
    private ServerSocket socketServer;
    private Thread serverThread = null;
    private Thread controlThread = null;
    private String msg;
    private volatile boolean isServerRunning = true;
    
    public ConexionSocket() {
    	try {
            socketServer = new ServerSocket(5000);
            System.out.println("Esperando al cliente");
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
                	    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                	                        	
                        while (input.hasNextLine()) {
                            msg = input.nextLine();
                        }
                        
                        Thread.sleep(1);

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
    
    public void Data(String packageData, String key) {
            controlThread = new Thread(() -> {
                while (isServerRunning) {
                    try (Socket socket = socketServer.accept();
                        Scanner input = new Scanner(socket.getInputStream())) {
                            DataOutputStream output = new DataOutputStream(socket.getOutputStream());



                            if(key == "O" ) {
                                output.writeUTF(packageData);
                                break;
                            }

                            if(key == "M" ) {
                                //System.out.println("Si llega");
                                output.writeUTF(packageData);
                                break;
                            }
                            
                            if(key == "C" ) {
                                //System.out.println("Si llega");
                                output.writeUTF(packageData);
                                break;
                            }

                        Thread.sleep(0);

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
            controlThread.setDaemon(true);
            controlThread.start();
    }
    
    
    public void sendPackage(String packageToSend, String key) {
    	System.out.println(packageToSend);
    	Data(packageToSend,key);
    }
    
    /*public void sendIntensityCommand(int intensity, int a) {
        String packageData = String.valueOf(intensity + "," + a);;
        Data(packageData);
    }*/
    
    public void stop() throws IOException {
        isServerRunning = false;
    	socketServer.close();
    }


    public String getMsg() {
            return msg;
    }	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        //Don't have access to the class repository in order to proceed with exercises.
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter outputToClient = null;
        BufferedReader inputFromClient = null;

        try{
            System.out.println("Starting server..." + SERVER_PORT);
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Waiting for connection...");

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
            inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String clientGreeting = inputFromClient.readLine();
            System.out.println("Client SErver: "+clientGreeting);
            outputToClient.println("Hello, Client! I am ready to recieve your numbers");

            int number = Integer.parseInt(inputFromClient.readLine());
            System.out.println("Client recieved number " +number);

            int number2 = Integer.parseInt(inputFromClient.readLine());
            System.out.println("Client recieved number " +number2);

            int sum = number + number2;
            outputToClient.println(sum);
            System.out.println("Sum sent to client " +sum);
        }catch(IOException e){
            System.err.println("Error occured in server " + e.getMessage());
        }catch(NumberFormatException e){
            System.err.println("Invalid Number format recieved from client " + e.getMessage());
        }finally {
            try{
                if( outputToClient != null) outputToClient.close();
                if( inputFromClient != null) inputFromClient.close();
                if( clientSocket != null) clientSocket.close();
                if( serverSocket != null) serverSocket.close();
            }catch(IOException e){
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}

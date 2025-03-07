import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client1 {
    private static final int SERVER_PORT = 8080;
    private static final String SERVER_ADDRESS = "localhost";
    public static void main(String[] args) {
        Socket clientSocket = null;
        PrintWriter outputToServer = null;
        BufferedReader inputFromServer = null;
        BufferedReader userInput = null;

        try{
            System.out.println("Connecting to server at " + SERVER_ADDRESS + " on port " + SERVER_PORT);
            clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server");

            outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            userInput = new BufferedReader(new InputStreamReader(System.in));

            outputToServer.println("Hello server! I am ready to send you my numbers");
            String responseFromServer = inputFromServer.readLine();
            System.out.println("Server says: " +responseFromServer);

            System.out.print("Input first number: ");
            String firstNumber = userInput.readLine();
            outputToServer.println(firstNumber);

            System.out.print("Input second number: ");
            String secondNumber = userInput.readLine();
            outputToServer.println(secondNumber);

            String inputSum = inputFromServer.readLine();
            System.out.println("The sum is: " + inputSum);

        }catch(UnknownHostException e){
            System.err.println("Cannot find the server at " + SERVER_ADDRESS);
        }catch(IOException e){
            System.err.println("Error in communication with " + e.getMessage());
        }finally {
            try{
                if( outputToServer != null) outputToServer.close();
                if( inputFromServer!= null) inputFromServer.close();
                if( clientSocket != null) clientSocket.close();
                if( userInput != null) userInput.close();
            }catch(IOException e){
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}

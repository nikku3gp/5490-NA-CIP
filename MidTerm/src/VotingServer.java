import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.*;

public class VotingServer {

    public static void main(String[] args) {
        Map<String, Integer> voting = new HashMap<>();
        voting.put("Option A", 0);
        voting.put("Option B", 0);
        voting.put("Option C", 0);
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("Server started on port 9000");
            while(true){
                try(Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

                    String clientIP = clientSocket.getInetAddress().getHostAddress();
                    System.out.println("Client connected: " + clientIP);

                    out.println("Voting Options: ");
                    for (Map.Entry<String, Integer> entry : voting.entrySet()) {
                        out.println(entry.getKey());
                    }
                    out.println("Enter your vote: ");
                    String input = in.readLine();
                    if (voting.containsKey(input)) {
                        voting.put(input, voting.get(input) + 1);
                    }

                    out.println("Vote cast successfully");

                    System.out.println("Current votes: ");
                    for (Map.Entry<String, Integer> entry : voting.entrySet()) {
                        out.println(entry.getKey()+ "="+entry.getValue());
                    }

                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

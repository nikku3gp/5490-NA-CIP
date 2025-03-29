import java.io.*;
import java.net.*;
import java.util.Scanner;
public class VotingClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server");
            Scanner scanner = new Scanner(System.in);

            String serverPrompt;
            System.out.println(in.readLine());
            while((serverPrompt = in.readLine()) != null) {
                System.out.println(in.readLine());
            }

            String input = scanner.nextLine().trim();
            out.println(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

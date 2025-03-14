import java.util.Scanner;
import java.io.*;
import java.util.List;
public class exc1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logFile = "log.txt";
        File file = new File(logFile);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            // ToDo: Check if the user wants to exit the program
            if (input.equals("exit")) break;

            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String[] msgSp = input.split(" ");
            String msg = "";





            // ToDo: Add try-catch block to handle IOException when implementing file operations
            try {
                switch (command) {
                    case "log":
                        // ToDo: Check if a message was provided
                        if (!parts[1].equals("")){
                            FileWriter fw = new FileWriter(logFile, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            for (int i = 1; i <= msgSp.length-1; i++){
                                msg+=msgSp[i] + " ";
                            }
                            bw.write(msg);
                            bw.write(System.lineSeparator());
                            System.out.println("Message logged");
                            bw.close();
                        }else{
                            break;
                        }
                        break;

                    case "read":
                        if(file.exists()){
                            FileReader fr = new FileReader(file);
                            BufferedReader br = new BufferedReader(fr);
                            String lines;
                            while((lines = br.readLine()) != null) {
                                System.out.println(lines);
                            }
                            br.close();
                        }else
                            System.err.println("Error: File not found");
                        // ToDo: Implement the read command
                        // - Check if the log file exists
                        // - If it exists, read and display its entire content
                        // - If it doesn't exist, print "Error: File not found"

                        break;

                    case "clear":
                        if(file.exists()){
                            file.delete();
                        }
                        // ToDo: Implement the clear command
                        // - Delete the log file if it exists
                        // - Print appropriate feedback message

                        break;

                    default:
                        System.out.println("Error: Unknown command");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}

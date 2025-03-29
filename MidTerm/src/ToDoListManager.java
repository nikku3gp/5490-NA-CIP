import java.util.Scanner;
import java.io.*;
public class ToDoListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String todoFile = "todo.txt";

        while(true){
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;

            String[] parts = input.split(" ", 2);
            String command = parts[0];

            try{
                switch (command) {
                    case "add":
                        if (parts.length < 2) {
                            System.err.println("Error: Message required");
                            break;
                        }
                        try (FileWriter writer = new FileWriter(todoFile, true)) {
                            writer.write(parts[1] + "\n");
                            System.out.println("Task added");
                        }
                        break;

                    case "view":
                        File file = new File(todoFile);
                        if (!file.exists()) {
                            System.err.println("Error: File not found");
                            break;
                        }
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            System.out.println("To-Do List:");
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        }
                        break;
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }



}

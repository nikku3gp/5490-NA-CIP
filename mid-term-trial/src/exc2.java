import java.io.*;
import java.util.Scanner;
public class exc2 {
    /**
     * ToDo: Implement the FileReaderTask class that extends Thread
     * - It should read a file and print its contents line-by-line
     * - Each line should be prefixed with the filename
     * - Handle file not found errors appropriately
     */
    static class FileReaderTask extends Thread {
        private String filename;

        public FileReaderTask(String filename) {
            // ToDo: Initialize the filename field
            this.filename = filename;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String lines;
                while((lines = br.readLine())!=null){
                    System.out.println(filename+"_"+lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // ToDo: Implement the run method
            // - Use BufferedReader to read the file line by line
            // - Print each line with the filename as prefix
            // - Handle IOException if the file is not found

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            // ToDo: Check if the user wants to exit the program
            if (input.equals("exit")) break;

            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command){
                case "read":
                    if(parts[1].equals(null) && parts[2].equals(null))
                        System.err.println("Format is invalid");
                    String file1 = parts[1];
                    String file2 = parts[2];

                    FileReaderTask f1 = new FileReaderTask(file1);
                    FileReaderTask f2 = new FileReaderTask(file2);

                    f1.start();
                    f2.start();

                    try{
                        f1.join();
                        f2.join();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Reading complete");

                    break;
            }
            // ToDo: Validate the command format
            // - Check if the command is "read"
            // - Check if there are exactly two filenames provided
            // - Print error message if the format is invalid


            // ToDo: Extract the two filenames from the command


            // ToDo: Create and start two threads to read the files
            // - Create two FileReaderTask instances
            // - Start both threads
            // - Wait for both threads to complete using join()
            // - Print "Reading complete" when both threads are done
            // - Handle InterruptedException

        }
        scanner.close();
    }
}

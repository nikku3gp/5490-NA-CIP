import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
public class ConcurrentKeywordFinder {
    static class syncList{
        private List<String> keywords;
        public syncList() {
            keywords = new CopyOnWriteArrayList<>();
        }
        public synchronized void find(String e){
            keywords.add(e);
        }
        public List<String> getList(){
            return keywords;
        }
    }
    static class KeywordFinderTask implements Runnable{
        private syncList key;
        private String filename;
        private String keyword;

        public KeywordFinderTask(syncList key, String filename, String keyword){
            this.key = key;
            this.filename = filename;
            this.keyword = keyword;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.contains(keyword)){
                        key.find(filename);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error: " + filename + " not found");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        syncList found = new syncList();
        List<String> Last = found.getList();
        while(true){
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;

            String[] parts = input.split(" ");
            String search = parts[0];

            try {
                Thread myThread[] = new Thread[parts.length-1];
                for (int i = 1; i < parts.length; i++) {
                    myThread[i-1] = new Thread(new KeywordFinderTask(found, parts[i], search));
                    myThread[i-1].start();
                }
                for (int i = 1; i < parts.length; i++) {
                    myThread[i-1].join();
                }
                System.out.println("Keywords found in: ");
                for (String line: found.getList()) {
                    System.out.println(line);
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}

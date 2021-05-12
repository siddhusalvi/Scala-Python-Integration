import java.io.*;

public class ProcessMakerJava {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("java starts at " + System.currentTimeMillis() + " ms");
        ProcessBuilder pb = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/script.py");

        Process tr = pb.start();



        PrintStream ps = new PrintStream(tr.getOutputStream());
        ps.println("First msg");
        ps.flush();
        ps.println("First msg");
        ps.flush();
        ps.println("First msg");
        ps.flush();
        ps.println("Second msg");
        ps.flush();
        Thread.sleep(3000);
        ps.println("x"); ps.flush();
        System.out.println("java ends at " + System.currentTimeMillis() + " ms");

        InputStream error = tr.getErrorStream();
        for (int i = 0; i < error.available(); i++) {
            System.out.println("" + error.read());
        }

    }
}

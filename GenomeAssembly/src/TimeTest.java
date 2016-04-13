import java.lang.Math.*;

public class TimeTest {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: <sequence_length> <min_lmer_size> <max_lmer_size>");
            System.exit(1);
        }

        long seq_length = Long.parseLong(args[0]);
        int min_lmer = Integer.parseInt(args[1]);
        int max_lmer = Integer.parseInt(args[2]);

        String sequence = RandomGenerator.generateRandomString(seq_length);

        String result;
        long start, end;
        for (int i = min_lmer; i < max_lmer; ++i) {
            result = "lmer_size: " + i + " seq_length: " + seq_length;
            String[] lmers = RandomGenerator.breakString(i, sequence);
            
            start = System.nanoTime();
            GenomeSolver solver = new GenomeSolver(lmers, i);
            String solution = solver.solve();

            if (solution == null) { // Could not solve
                result += " cns time: 0";
            } else {
                boolean correct = solution.equals(sequence);
                end = System.nanoTime();    
                double time = Math.abs(end - start) / 1000000000.0;

                if (correct) { // Correct solution
                    result += " solved time: " + time;
                } else { // Incorrect solution
                    result += " incorrect time: " + time;
                }
            }
            System.out.println(result);
        }
    }
}

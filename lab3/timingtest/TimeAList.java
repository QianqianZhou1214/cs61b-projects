package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> L = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCount = new AList<>();
        int temp = 1000;
        while(temp <= 128000){
            Ns.addLast(temp);
            opCount.addLast(temp);
            temp *= 2;
        }
        for(int i = 0; i < Ns.size(); i++){
            int N = Ns.get(i); // N is the number of added elements in AList everytime
            int j = 0; // use j to simulate the addLast process(N elements, N times of adding)
            Stopwatch sw = new Stopwatch();// start to count the time
            while(j < N){
                L.addLast(j);
                j += 1;
            }
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns, times, opCount);

    }
}

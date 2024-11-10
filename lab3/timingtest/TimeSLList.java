package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int M = 10000;  // 执行 getLast 操作的次数
        int[] testSizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

        for (int N : testSizes) {
            // 创建并填充 SLList
            SLList<Integer> testList = new SLList<>();
            for (int i = 0; i < N; i++) {
                testList.addLast(i);
            }

            // 计时执行 M 次 getLast 操作
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < M; i++) {
                testList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();

            // 记录数据
            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(M);
        }

        // 打印时间表
        printTimingTable(Ns, times, opCounts);
        }
    }



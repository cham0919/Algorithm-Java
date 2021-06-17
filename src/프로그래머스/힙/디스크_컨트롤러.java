package 프로그래머스.힙;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class 디스크_컨트롤러 {

    public static void main(String[] args) {
        디스크_컨트롤러 test = new 디스크_컨트롤러();
        List<int[][]> jobsList = getJobsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < jobsList.size(); i++) {
            int result = test.solution(jobsList.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        }
    }

    Queue<Job> queue = new PriorityQueue<>();
    int total = 0;
    int currentTime = 0;
    int currentJobsIdx = 0;

    public int solution(int[][] jobs) {
        total = 0;
        currentTime = 0;
        currentJobsIdx = 0;
        queue = new PriorityQueue<>();

        sort(jobs);

        addFirstJob(jobs);
        runJob();

        while (isFinish(jobs)) {
            addJob(jobs);
            runJob();
        }

        return total / jobs.length;
    }

    private void sort(int[][] jobs){
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

    }

    private boolean isFinish(int[][] jobs){
        return currentJobsIdx < jobs.length || !queue.isEmpty();
    }

    private void addFirstJob(int[][] jobs) {
        addJob(jobs);
        if (queue.isEmpty()) {
            currentTime++;
            addFirstJob(jobs);
        }
    }



    private void addJob(int[][] jobs) {
        for (; currentJobsIdx < jobs.length; currentJobsIdx++) {
            if (hasInputJob(jobs)) { inputJob(jobs); }
            else { break; }
        }
    }


    private void runJob(){
        if ( queue.isEmpty() ) {
            currentTime++;
            return;
        }
        Job outputJob = queue.poll();
        currentTime += outputJob.getRunningTime();
        total += currentTime - outputJob.getInputTime();
    }

    private void inputJob(int[][] jobs){
        Job inputJob = new Job().setInputTime(jobs[currentJobsIdx][0])
                .setRunningTime(jobs[currentJobsIdx][1]);
        queue.add(inputJob);
    }

    private boolean hasInputJob(int[][] jobs){
        return jobs[currentJobsIdx][0] <= currentTime;
    }


    class Job implements Comparable<Job> {

        private int inputTime;
        private int runningTime;

        public int getInputTime() {
            return inputTime;
        }

        public Job setInputTime(int inputTime) {
            this.inputTime = inputTime;
            return this;
        }

        public int getRunningTime() {
            return runningTime;
        }

        public Job setRunningTime(int runningTime) {
            this.runningTime = runningTime;
            return this;
        }

        @Override
        public int compareTo(Job o) {
            return this.getRunningTime() - o.getRunningTime();
        }
}


//    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(9);
        results.add(74);
        results.add(15);
        results.add(72);

        return results;
    }

    public static List<int[][]> getJobsTestCases(){
        int[][] jobs1 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs2 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int[][] jobs3 = {{0, 10}, {4, 10}, {15, 2}, {5, 11}};
        int[][] jobs4 = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};

        List<int[][]> jobsList = new ArrayList<>();
        jobsList.add(jobs1);
        jobsList.add(jobs2);
        jobsList.add(jobs3);
        jobsList.add(jobs4);

        return jobsList;
    }


}

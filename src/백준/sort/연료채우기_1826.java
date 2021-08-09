package 백준.sort;

import java.util.*;

public class 연료채우기_1826 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();

        PriorityQueue<GasStation> gasStations = new PriorityQueue<>(Comparator.comparing(GasStation::getLocation));

        for(int i = 0; i < size; i++) {
            gasStations.add(new GasStation(scan.nextInt(), scan.nextInt()));
        }

        int town = scan.nextInt();
        int oil = scan.nextInt();

        int result = solution(gasStations, town, oil);
        System.out.println(result);
    }

    private static int solution(PriorityQueue<GasStation> gasStations, int town, int oil) {
        int result = 0;
        int currentLocation = oil;
        PriorityQueue<GasStation> pastGasStations = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(GasStation::getGas)));

        // 한번에 갈 수 있으면 한번에 감
        if (currentLocation >= town) {
            return result;
        }

        while (currentLocation < town) {
            // 거리는 안닿지만 주유소가 없으면 실패
            if (gasStations.isEmpty()) {
                return -1;
            }

            // 현재 갈 수 있는 주유소들
            while (!gasStations.isEmpty() && (currentLocation >= gasStations.peek().getLocation())) {
                pastGasStations.add(gasStations.poll());
            }

            // 현재 갈 수 있는 주유소 중 가장 많이 기름을 채울 수 있는 가장 큰 주유소
            if (!pastGasStations.isEmpty()) {
                // 주유소 이동 및 충전
                GasStation tempGasStation = pastGasStations.poll();
                currentLocation += tempGasStation.getGas(); // 기름만큼 또 가
                result++;

            } else {
                    return -1;
            }
        }

        return result;
    }
}

class GasStation{
    private final int gas;
    private final int location;

    public GasStation(int location, int gas) {
        this.location = location;
        this.gas = gas;
    }

    public int getGas() {
        return gas;
    }

    public int getLocation() {
        return location;
    }
}
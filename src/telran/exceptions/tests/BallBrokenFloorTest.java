package telran.exceptions.tests;

import org.junit.jupiter.api.Test;
import telran.exceptions.BallBrokenFloor;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BallBrokenFloorTest {
    private static final int N_FLOORS = 100;
    BallBrokenFloor ballBrokenFloor = new BallBrokenFloor(N_FLOORS);

    @Test
    void test() {
        assertEquals(ballBrokenFloor.getBrokenFloor(), getMinBrokenFloor(ballBrokenFloor));
    }

    private int getMinBrokenFloor(BallBrokenFloor ballBrokenFloor) {
        int res = 0;
        try {
            res = findBrokenFloor(ballBrokenFloor, N_FLOORS);
        } catch (Exception e) {
            System.out.println("Wrong number of floors");
            e.printStackTrace();
        }

        return res;
    }

    public static int findBrokenFloor(BallBrokenFloor ball, int nFloors) throws Exception {
        int low = 1;
        int high = nFloors;

        while (low < high) {
            int mid = (low + high) / 2;
            try {
                ball.checkFloor(mid);
                low = mid + 1;
            } catch (Exception e) {
                high = mid;
            }
        }
        return low;
    }
}


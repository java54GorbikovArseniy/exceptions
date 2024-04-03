package telran.exceptions.tests;

import org.junit.jupiter.api.Test;
import telran.exceptions.BallBrokenFloor;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BallBrokenFloorTest {
    private static final int N_FLOORS = 100;
    BallBrokenFloor ballBrokenFloor;

    @Test
    void minBrokenFloorTest() {
        ballBrokenFloor = new BallBrokenFloor(N_FLOORS);
        assertEquals(ballBrokenFloor.getBrokenFloor(), getMinBrokenFloor(ballBrokenFloor));
    }

    private int getMinBrokenFloor(BallBrokenFloor ballBrokenFloor) {
        int low = 1;
        int high = N_FLOORS;

        while (low < high) {
            int mid = (low + high) / 2;
            try {
                ballBrokenFloor.checkFloor(mid);
                low = mid + 1;
            } catch (Exception e) {
                high = mid;
            }
        }
        return low;
    }
}


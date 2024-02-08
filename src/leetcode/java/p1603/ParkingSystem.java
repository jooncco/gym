package leetcode.java.p1603;

/**
 * Ad hoc
 * | Time: O (1)
 * | Space: O (1)
 */
public class ParkingSystem {
    private final int[] slots = new int[4], occupied = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        slots[1] = big;
        slots[2] = medium;
        slots[3] = small;
    }

    public boolean addCar(int carType) {
        if (occupied[carType] == slots[carType])
            return false;
        ++occupied[carType];
        return true;
    }
}
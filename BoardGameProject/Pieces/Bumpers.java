package Pieces;

public class Bumpers extends PlayerItem
{
    public Bumpers(char s)
    {
        type = "bumpers";
        symbol = s;
        isFinished = false;
    }

    /**
     * Based on the direction supplied, this method calculates the destination row & column IF the object were to be moved.
     * It returns this destination row & column pair in an array.
     * Note: You may assume integer values for directions as follows: 1 (north), 2(south), 3 (east), 4 (west), 5 (northeast), 6 (southeast), 7 (northwest), 8 (southwest)
     */
    public int[] calcDestination(int direction)
    {
        int[] newlocation = new int[2];

        switch (direction)
        {
            case 1:
                System.out.println("North");
                newlocation[0] = location[0] - 1;    // row
                newlocation[1] = location[1];        // col
                return newlocation;
            case 2:
                System.out.println("South");
                newlocation[0] = location[0] + 1;
                newlocation[1] = location[1];
                return newlocation;
            case 3:
                System.out.println("east");
                newlocation[0] = location[0];
                newlocation[1] = location[1] + 1;
                return newlocation;
            case 4:
                System.out.println("West");
                newlocation[0] = location[0];
                newlocation[1] = location[1] - 1;
                return newlocation;
            case 5:
                System.out.println("NorthEast");
                newlocation[0] = location[0] - 1;
                newlocation[1] = location[1] + 1;
                return newlocation;
            case 6:
                System.out.println("SouthEast");
                newlocation[0] = location[0] + 1;
                newlocation[1] = location[1] + 1;
                return newlocation;
            case 7:
                System.out.println("NorthWest");
                newlocation[0] = location[0] - 1;
                newlocation[1] = location[1] - 1;
                return newlocation;
            case 8:
                System.out.println("SouthWest");
                newlocation[0] = location[0] + 1;
                newlocation[1] = location[1] - 1;
                return newlocation;
            default:
                return location;
        }
    }// calcDestination
}

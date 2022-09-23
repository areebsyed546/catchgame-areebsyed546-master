
/**
 * This class models the Doctor in the game. A Doctor has
 * a position and can move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        // when click on a square that is one away from the doctor, make the doctor only
        // move one square left, up ,down,right or diagonally
        if (newRow == row - 1 || newRow == row + 1 || newCol == col - 1 || newCol == col + 1) {
            this.row = newRow;
            this.col = newCol;
            // when the user click on square that is two away make it teleport
        } else if (newRow != row - 1 || newRow != row + 1 || newRow != row || newCol != col - 1 || newCol != col + 1
                || newCol != col) {
            int high = 11;

            int low = 0;
            row = (int) (Math.random() * (high - low + 1) + low);
            col = (int) (Math.random() * (high - low + 1) + low);
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;
    }

}


/**
 * This class models a Delek in the game. A Delek has
 * a position and can advance towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        // make a variable to stroe where the dalek is
        this.row = theRow;
        this.col = theCol;

    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doctor) {
        int docRow = doctor.getRow();
        int docCol = doctor.getCol();
        // when doctor is above the dalek move up
        if (docRow > this.row) {
            this.row++;
            // when doctor is below the dalek move down
        } else if (docRow < this.row) {

            this.row--;
        }
        // when doctor is on the right the dalek move right
        if (docCol > this.col) {
            this.col++;
            // when doctor is on the left the dalek move left
        } else if (docCol < this.col) {
            this.col--;
        }

    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {

        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {

        return hasCrashed;
    }

}


/**
 * This class manages the interactions between the different pieces of
 * the game: the Board, the Daleks, and the Doctor. It determines when
 * the game is over and whether the Doctor won or lost.
 * 
 */
public class CatchGame {

    /**
     * one
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */

    private Board gameBoard;
    private Doctor doctor;
    private Dalek delek1;
    private Dalek delek2;
    private Dalek delek3;

    /**
     * The constructor for the game.
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        // setting the size of the gameboard
        this.gameBoard = new Board(12, 12);
        // setting the position of the doctor
        this.doctor = new Doctor(5, 3);
        // setting the position of the dalek
        this.delek1 = new Dalek(2, 5);
        // setting the position of dalek 2
        this.delek2 = new Dalek(4, 1);
        // setting the position of dalek 3 
        this.delek3 = new Dalek(1, 10);

    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        // putting the doctor on the board and seting the colour
        this.gameBoard.putPeg(Board.GREEN, this.doctor.getRow(), this.doctor.getCol());
        // putting the daleks on the board and seting the colour
        this.gameBoard.putPeg(Board.BLACK, this.delek1.getRow(), this.delek1.getCol());
        this.gameBoard.putPeg(Board.BLACK, this.delek2.getRow(), this.delek2.getCol());
        this.gameBoard.putPeg(Board.BLACK, this.delek3.getRow(), this.delek3.getCol());

        while (true) {
            // get the coordinate, when you click
            Coordinate click = this.gameBoard.getClick();
            // get the coordinate from the row
            int row = click.getRow();

            // get the coordinate from the column
            int col = click.getCol();
            // remove the doctor
            this.gameBoard.removePeg(this.doctor.getRow(), this.doctor.getCol());
            // move the doctor
            this.doctor.move(row, col);
            // put the doctor on the board
            this.gameBoard.putPeg(Board.GREEN, this.doctor.getRow(), this.doctor.getCol());
            // remove the daleks
            this.gameBoard.removePeg(this.delek1.getRow(), this.delek1.getCol());
            this.gameBoard.removePeg(this.delek2.getRow(), this.delek2.getCol());
            this.gameBoard.removePeg(this.delek3.getRow(), this.delek3.getCol());
            // move towards the doctor, only when dalak hasnt crashed
            if (delek1.hasCrashed() == false) {
                this.delek1.advanceTowards(doctor);
            }
            if (delek2.hasCrashed() == false) {
                this.delek2.advanceTowards(doctor);
            }
            if (delek3.hasCrashed() == false) {
                this.delek3.advanceTowards(doctor);

            }
            // put delaks on the board and set the colour when we move towards the doctor
            this.gameBoard.putPeg(Board.BLACK, this.delek1.getRow(), this.delek1.getCol());
            this.gameBoard.putPeg(Board.BLACK, this.delek2.getRow(), this.delek2.getCol());
            this.gameBoard.putPeg(Board.BLACK, this.delek3.getRow(), this.delek3.getCol());
            // when the delek1 and dalek2 crash together, make them stop moving
            if (this.delek1.getRow() == this.delek2.getRow() && this.delek1.getCol() == this.delek2.getCol()) {

                this.delek1.crash();
                this.delek2.crash();
                // remove the daleks and add a red one
                this.gameBoard.removePeg(this.delek1.getRow(), this.delek1.getCol());
                this.gameBoard.removePeg(this.delek2.getRow(), this.delek2.getCol());
                this.gameBoard.putPeg(Board.RED, this.delek2.getRow(), this.delek2.getCol());
            }
            // when the delek1 and dalek3 crash together, make them stop moving
            if (this.delek1.getRow() == this.delek3.getRow() && this.delek1.getCol() == this.delek3.getCol()) {
                this.delek1.crash();
                this.delek3.crash();
                // remove the daleks and add a red one
                this.gameBoard.removePeg(this.delek1.getRow(), this.delek1.getCol());
                this.gameBoard.removePeg(this.delek3.getRow(), this.delek3.getCol());
                this.gameBoard.putPeg(Board.RED, this.delek3.getRow(), this.delek3.getCol());
            }
            // when the delek2 and dalek3 crash together, make them stop moving
            if (this.delek2.getRow() == this.delek3.getRow() && this.delek2.getCol() == this.delek3.getCol()) {
                this.delek2.crash();
                this.delek3.crash();
                // remove the daleks and add a red one
                this.gameBoard.removePeg(this.delek2.getRow(), this.delek2.getCol());
                this.gameBoard.removePeg(this.delek3.getRow(), this.delek3.getCol());
                this.gameBoard.putPeg(Board.RED, this.delek3.getRow(), this.delek3.getCol());
            }
            // when the delaks crash into the doctors tell the play you lost and end the
            // game
            if (this.doctor.getRow() == this.delek1.getRow() && this.doctor.getCol() == this.delek1.getCol()) {
                this.gameBoard.displayMessage("you lose");
                this.gameBoard.putPeg(Board.YELLOW, this.doctor.getRow(), this.doctor.getCol());
                // to stop the player from making more moves
                break;
            } else if (this.doctor.getRow() == this.delek2.getRow() && this.doctor.getCol() == this.delek2.getCol()) {
                this.gameBoard.displayMessage("you lose");
                this.gameBoard.putPeg(Board.YELLOW, this.doctor.getRow(), this.doctor.getCol());
                // to stop the player from making more moves
                break;
            } else if (this.doctor.getRow() == this.delek3.getRow() && this.doctor.getCol() == this.delek3.getCol()) {
                this.gameBoard.displayMessage("you lose");
                this.gameBoard.putPeg(Board.YELLOW, this.doctor.getRow(), this.doctor.getCol());
                // to stop the player from making more moves
                break;

            } else if (this.delek1.hasCrashed() && this.delek2.hasCrashed() && this.delek3.hasCrashed()) {
                this.gameBoard.displayMessage("you win");

                // to stop the player from making more moves
                break;

            }
        }

    }
}

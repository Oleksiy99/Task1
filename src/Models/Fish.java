package Models;

public class Fish {
    private boolean isFull;
    private char symbol;
    private int coordX;
    private int coordY;

    public Fish(char symbol, int coordX, int coordY) {
        this.isFull = false;
        this.symbol = symbol;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public boolean isFull() {

        return isFull;
    }

    public void setFull(boolean full) {
        symbol = Character.toUpperCase(symbol);
        isFull = full;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
}

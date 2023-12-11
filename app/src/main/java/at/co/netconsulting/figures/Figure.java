package at.co.netconsulting.figures;

public abstract class Figure {
    private int color;
    private int value;
    private int maxPiece;
    private int setCellX;
    private int setCellY;

    public Figure(int color, int value, int maxPiece) {
        this.color = color;
        this.value = value;
        this.maxPiece = maxPiece;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSetCellX() {
        return setCellX;
    }

    public void setSetCellX(int setCellX) {
        this.setCellX = setCellX;
    }

    public int getSetCellY() {
        return setCellY;
    }

    public void setSetCellY(int setCellY) {
        this.setCellY = setCellY;
    }
    public int getMaxPiece() {
        return maxPiece;
    }

    public void setMaxPiece(int maxPiece) {
        this.maxPiece = maxPiece;
    }
}

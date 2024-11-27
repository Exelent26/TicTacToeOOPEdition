import java.util.Objects;

public class Coordinates {
    public int x;
    public int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}



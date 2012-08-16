/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/16/12
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRover {
    private int x;
    private int y;
    private Orient orient;

    public MarsRover(int x, int y, String orient) {
        this.x = x;
        this.y = y;
        this.orient = Orient.valueOf(orient);
    }

    public void turnLeft() {
        this.orient = orient.left();
    }

    public String orient() {
        return orient.toString();
    }

    public void turnRight() {
        this.orient = orient.right();
    }
}

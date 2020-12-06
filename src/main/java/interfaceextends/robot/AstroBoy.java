package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void flyTo(Point position) {
        this.position = position;
        path.add(position);
    }

    @Override
    public void liftTo(long altitude) {
        position = new Point(position.getX(), position.getY(), altitude);
        path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        flyTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        Point flyingPosition = new Point(position.getX(), position.getY(), ALTITUDE);
        liftTo(ALTITUDE);
        flyTo(flyingPosition);
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}

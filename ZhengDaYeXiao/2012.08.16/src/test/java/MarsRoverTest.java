import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/16/12
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverTest {

    @Test
    public void should_orient_north_when_rover_orient_east_and_turn_left() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "E");
        rover.turnLeft();
        assertThat(rover.orient(), is("N"));
    }

    @Test
    public void should_orient_west_when_rover_orient_north_and_turn_left() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "N");
        rover.turnLeft();
        assertThat(rover.orient(), is("W"));
    }

    @Test
    public void should_orient_south_when_rover_orient_west_and_turn_left() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "W");
        rover.turnLeft();
        assertThat(rover.orient(), is("S"));
    }

    @Test
    public void should_orient_east_when_rover_orient_south_and_turn_left() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "S");
        rover.turnLeft();
        assertThat(rover.orient(), is("E"));
    }

    @Test
    public void should_orient_east_when_rover_orient_north_and_turn_right() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "N");
        rover.turnRight();
        assertThat(rover.orient(), is("E"));
    }

    @Test
    public void should_orient_south_when_rover_orient_east_and_turn_right() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "E");
        rover.turnRight();
        assertThat(rover.orient(), is("S"));
    }

    @Test
    public void should_orient_west_when_rover_orient_south_and_turn_right() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "S");
        rover.turnRight();
        assertThat(rover.orient(), is("W"));
    }

    @Test
    public void should_orient_north_when_rover_orient_west_and_turn_right() throws Exception {
        MarsRover rover = new MarsRover(1, 1, "W");
        rover.turnRight();
        assertThat(rover.orient(), is("N"));
    }
}

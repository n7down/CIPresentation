import org.junit.Test;
import static org.junit.Assert.*;

public class Vector2Test {
  @Test public void testGetX() {
    Vector2 vector2 = new Vector2(1.0f, 2.0f);
    assertTrue("getX should return 1.0", vector2.getX() == 1.0f);
  }

  @Test public void testGetY() {
    Vector2 vector2 = new Vector2(1.0f, 2.0f);
    assertTrue("getY should return 2.0", vector2.getY() == 2.0f);
  }
}

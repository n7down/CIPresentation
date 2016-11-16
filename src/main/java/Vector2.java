
public class Vector2 {
  private float x;
  private float y;

  Vector2() {
    this.x = 0;
    this.y = 0;
  }

  Vector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public Vector2 set (Vector2 v) {
    x = v.x;
    y = v.y;
    return this;
  }

  public Vector2 set (float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

  public float len () {
		return (float)Math.sqrt(x * x + y * y);
	}

  public Vector2 normalize () {
    float len = len();
    if (len != 0) {
      x /= len;
      y /= len;
    }
    return this;
  }

  public float distance (float x, float y) {
    final float x_d = x - this.x;
    final float y_d = y - this.y;
    return (float)Math.sqrt(x_d * x_d + y_d * y_d);
  }
}

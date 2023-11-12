public class Fly {
  private double mass;
  private double speed;

  public Fly(double initMass, double initSpeed) {
    mass = initMass;
    speed = initSpeed;
  }

  public Fly(double initMass) {
    this(initMass, 10);
  }

  public Fly() {
    this(5, 10);
  }

  public void setMass(double newMass) {
    mass = newMass;
  }

  public double getMass() {
    return mass;
  }

  public void setSpeed(double newSpeed) {
    speed = newSpeed;
  }

  public double getSpeed() {
    return speed;
  }

  public String toString() {
    if (mass == 0) {
      return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
    } else {
      return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
    }
  }

  public void grow(int addedMass) {
    for (int i = 0; i < addedMass; i++) {
      if (mass < 20) {
        speed++;
      } else {
        speed -= 0.5;
      }
      mass++;
    }
    if (speed < 0) {
      speed = 0;
    }
  }

  public boolean isDead() {
    return mass == 0;
  }

  public static void main(String[] args) {}
}

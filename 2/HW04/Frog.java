public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";

  public Frog(String name, int age, double tongueSpeed) {
    this.setName(name);
    this.setAge(age);
    this.setTongueSpeed(tongueSpeed);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears * 12), tongueSpeed);
  }
  // A constructor that takes in just a name.
  public Frog(String name) {
    this(name, 5, 5);
  }

  public void setAge(int age) {
    this.age = age;
    updateIsFrogletAndTongueSpeed();
  }

  public void grow(int months) {
    for (int i = 0; i < months; i++) {
      grow();
    }
  }

  public void grow() {
    updateIsFrogletAndTongueSpeed();
    age++;
  }

  private void updateIsFrogletAndTongueSpeed() {
    setIsFroglet(age > 1 && age < 7);

    if (age < 12) {
      tongueSpeed++;
    } else if (age >= 30) {
      tongueSpeed = Math.max(5, tongueSpeed - 1);
    }
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }

    if (getTongueSpeed() > fly.getSpeed()) {
      if (fly.getMass() >= 0.5 * getAge()) {
        grow(1);
      }
      fly.setMass(0);
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    String frogType = isFroglet ? "froglet" : "frog";
    return String.format("My name is %s and I’m a rare %s. I’m %d months old and my tongue has a speed of %.2f.",
                         name, frogType, age, tongueSpeed);
  }

  public static String getSpecies() {
    return species;
  }

  public static void setSpecies(String newSpecies) {
    species = newSpecies;
  }

  public double getTongueSpeed() {
    return tongueSpeed;
  }

  public void setTongueSpeed(double tongueSpeed) {
    this.tongueSpeed = tongueSpeed;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIsFroglet(boolean isFroglet) {
    this.isFroglet = isFroglet;
  }

  public static void main(String[] args) {}
}

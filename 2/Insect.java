public class Insect {
  private double weight;
  private int x;
  private int y;

  private final double DIST_WEIGHT_LOSS_FACTOR = .0001;

  public Insect(double initWeight, int initX, int initY) {
    weight = initWeight;
    x = initX;
    y = initY;
  }

  public void move(int newX, int newY) {
    double distance = calculateDistance(x, y, newX, newY);
    if (distance > 0) {
      x = newX;
      y = newY;
      weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
      System.out.printf("Moved %.2f units\n", distance);
    } else
       System.out.println("Staying put");
  }

  private static double calculateDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
  }

  public static void main(String[] args) {
    Insect insect1 = new Insect(10.0, 10, 10);
    Insect insect2 = new Insect(9.5, -300, 400);
    insect1.move(1, 10);
    insect2.move(-300, 400);
  }
}

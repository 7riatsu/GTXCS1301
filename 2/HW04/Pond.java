public class Pond {
  public static void main(String[] args) {
    // Create Frog objects
    Frog peepo = new Frog("Peepo");
    Frog pepe = new Frog("Pepe", 10, 15);
    Frog peepaw = new Frog("Peepaw", 4.6, 5);
    Frog yourFrog = new Frog("YourFrogName", 8, 12); // Replace "YourFrogName" with the name you like

    // Create Fly objects
    Fly fly1 = new Fly(1, 3);
    Fly fly2 = new Fly(6);
    Fly yourFly = new Fly(2, 10); // Replace with the mass and speed you like

    // Perform operations
    Frog.setSpecies("1331 Frogs");

    // Description of Peepo
    System.out.println(peepo);

    // Peepo attempts to eat fly2
    peepo.eat(fly2);

    // Description of fly2
    System.out.println(fly2);

    // Peepo grows by 8 months
    peepo.grow(8);

    // Peepo attempts to eat fly2 again
    peepo.eat(fly2);

    // Description of fly2
    System.out.println(fly2);

    // Description of Peepo
    System.out.println(peepo);

    // Description of your own Frog
    System.out.println(yourFrog);

    // Peepaw grows by 4 months
    peepaw.grow(4);

    // Description of Peepaw
    System.out.println(peepaw);

    // Description of Pepe
    System.out.println(pepe);
  }
}

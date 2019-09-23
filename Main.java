public class Main {
    public static void main(String[] args) {
        Rational r = new Rational(3, 2);
        System.out.println(r.toString());

        Rational b = new Rational(1,3);
        r.mult(b);
        System.out.println(r.toString());

        Rational c = new Rational(2, 1);
        r.mult(c);
        System.out.println(r.toString());
    }
}
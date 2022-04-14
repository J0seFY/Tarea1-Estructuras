public class TestPolinomio {


    public static void main(String[] args) {

        Polinomio polinomio = new Polinomio();

        polinomio.addTermino(-3,4);
        polinomio.addTermino(-5,1);

        Polinomio polinomio2 = new Polinomio();
        polinomio2.addTermino(3,2);
        polinomio2.addTermino(5,0);

        System.out.println(polinomio.toString());
        System.out.println(polinomio2.toString());

        polinomio.multiPolinomio(polinomio2);

        System.out.println(polinomio);
    }
}

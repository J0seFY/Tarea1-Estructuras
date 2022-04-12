public class TestPolinomio {


    public static void main(String[] args) {

        Polinomio polinomio = new Polinomio();

        polinomio.addTermino(-3,4);
        polinomio.addTermino(-5,1);
        polinomio.addTermino(2,2);


        polinomio.addTermino(3,3);
        polinomio.addTermino(3,2);

        System.out.println(polinomio.toString());
        System.out.println(polinomio.getGrado());
        System.out.println(polinomio.evaluar(2));
    }
}

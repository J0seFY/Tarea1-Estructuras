public class Polinomio {

    private Nodo head = null;

    public Polinomio() {
    }

    public void addTermino(int coeficiente, int exponente) {

        Nodo nuevoTermino = new Nodo(coeficiente, exponente);
        if (head == null) {
            head = nuevoTermino;
        } else {
            Nodo pointer = head;
            if (nuevoTermino.exponente > head.exponente) {
                nuevoTermino.next = head;
                head = nuevoTermino;
            } else {
                while (pointer.next != null) {
                    if (nuevoTermino.exponente > pointer.next.exponente) {
                        nuevoTermino.next = pointer.next;
                        pointer.next = nuevoTermino;
                        break;
                    } else if (nuevoTermino.exponente == pointer.next.exponente) {

                        nuevoTermino.coeficiente += pointer.next.exponente;
                        nuevoTermino.next = pointer.next.next;
                        pointer.next = nuevoTermino;
                        break;

                    }

                    pointer = pointer.next;
                }

                pointer.next = nuevoTermino;

            }
        }

    }

    public int getGrado() {
        return head.exponente;
    }

    public int evaluar(int x) {
        Nodo puntero = head;
        int total = 0;
        while (puntero != null) {
            total += puntero.coeficiente * Math.pow(x, puntero.exponente);
            puntero = puntero.next;
        }
        return total;
    }

    public void sumPolinomio(Polinomio polinomio) {

        Nodo pointer = polinomio.head;
        while (pointer != null) {
            addTermino(pointer.coeficiente, pointer.exponente);
            pointer = pointer.next;
        }

    }

    public void multiPolinomio(Polinomio polinomio) {

        if(head == null){
            head = polinomio.head;
        }else{

            Nodo pointerNuevoP = polinomio.head;
            Nodo pointer = head;
            Polinomio nuevoPolinomio = new Polinomio();

            while (pointerNuevoP != null){
                while(pointer != null){
                    nuevoPolinomio.addTermino(pointerNuevoP.coeficiente * pointer.coeficiente ,pointerNuevoP.exponente + pointer.exponente);
                    pointer = pointer.next;
                }
                pointer = head;
                pointerNuevoP = pointerNuevoP.next;
            }

            head = nuevoPolinomio.head;
        }


    }

    public String toString() {

        Nodo pointer = head;
        String polinomioStr = "";
        while (pointer != null) {
            polinomioStr = polinomioStr + pointer.toString();
            pointer = pointer.next;
        }
        if (polinomioStr.charAt(0) == '+') {
            polinomioStr = polinomioStr.substring(1);
        }
        return polinomioStr;

    }


    private class Nodo {

        int coeficiente;
        int exponente;
        Nodo next;

        public Nodo() {
        }

        public Nodo(int coeficiente, int exponente) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
        }

        public Nodo(int coeficiente, int exponente, Nodo next) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
            this.next = next;
        }

        public String toString() {
            String signo = "+";

            if (coeficiente == 0) {
                return "";
            }
            if (coeficiente < 0) {
                signo = "";
            }
            if (exponente == 0) {
                return signo + coeficiente;
            }
            if (exponente == 1) {
                return signo + coeficiente + "x";
            }

            return signo + coeficiente + "x^" + exponente;
        }
    }

}



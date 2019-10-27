package geometria.figurepiane;
public class Cerchio {
        private double raggio;
        private static final double PI_GRECO = 3.1415;

        public Cerchio() {
            this.raggio = 1;
        }

        public Cerchio(double raggio) {
            this.raggio = raggio;
        }

        public double calcolaArea() {
            return this.PI_GRECO*(Math.pow(this.raggio, 2));
        }
}

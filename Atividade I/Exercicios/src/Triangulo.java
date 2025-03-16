public class Triangulo {
    float a;
    float b;
    float c;

    public Triangulo(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
        }
    
        public float perimetro(){
            float p = this.a + this.b + this.c;
            return p;
        }
        public double area(){
            float pconta = perimetro() / 2;
            double s_area= Math.sqrt(pconta*(pconta - this.a) * (pconta - this.b) * (pconta - this.c));
            return s_area;
            
        }
        public double centroide_x(){
           double lambda = (Math.pow(this.a,2) + Math.pow(this.b,2) - Math.pow(this.c,2)) / 2 * this.a * this.b;
           double x = (b+ a * lambda)/ 3;
           return x;

        }
        public double centroide_y(){
            double lambda = (Math.pow(this.a,2) + Math.pow(this.b,2) - Math.pow(this.c,2)) / (2 * this.a * this.b);
            double y = (a/3) * Math.sqrt(1 - Math.pow(lambda,2));
            return y;
        }

        public void exibirDados() {
            System.out.printf("Triângulo: (a = %.1f, b = %.1f, c = %.1f)\n", a, b, c);
            System.out.printf("Área: %.2f m²\n", area());
            System.out.printf("Perímetro: %.2f m\n", perimetro());
            System.out.printf("Centroide (x, y): (%.2f, %.2f)\n", centroide_x(), centroide_y());
            
        }

    }


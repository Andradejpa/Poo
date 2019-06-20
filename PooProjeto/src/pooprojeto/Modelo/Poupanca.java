package pooprojeto.Modelo;

public class Poupanca extends ContaC {
    
    public static final double TAXA = 2.02;
    
    public Poupanca(double saldo, String numero) {
        super(saldo, numero);
    }
    
    public void renderJuros() {
        this.creditar(this.getSaldo() * TAXA);
    }
    
}

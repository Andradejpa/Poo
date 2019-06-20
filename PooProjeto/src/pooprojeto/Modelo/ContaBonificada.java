package pooprojeto.Modelo;

public class ContaBonificada extends ContaC {

    private double bonus;
    public static final double TAXA_B = 0.02;

    public ContaBonificada(double saldo, String numero) {
        super(saldo, numero);
    }

    @Override
    public void creditar(double valor) {
        bonus = bonus + (valor * TAXA_B);
        super.creditar(valor);
    }

    public void calcularBonus() {
        super.creditar(bonus);
        bonus = 0;
    }

}

package pooprojeto.Modelo;

public class ContaImposto extends ContaAbstrata {

    public static final double TAXA = 0.02;

    public ContaImposto(double valor, String numero) {
        super(numero, valor);
    }

    @Override
    public void debitar(double valor) {
        if (this.getSaldo() < valor) {
            System.out.println("Saldo insuficiente!");
        } else {
            this.setSaldo(this.getSaldo() - ((valor * TAXA) + valor));
        }
    }

}

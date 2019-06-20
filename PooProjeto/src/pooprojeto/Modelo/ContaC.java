package pooprojeto.Modelo;

public class ContaC extends ContaAbstrata {

    public ContaC(double saldo, String numero) {
        super(numero, saldo);
    }

    @Override
    public void debitar(double valor) {//é um metodo abstrato herdado da classe ContaAbstrata para cada classe que herdar tal método
        //com isso a assinatura desse método abstrato vai estar disponivel para cada classe deter
        //de seu comportamento sem ferir a semática do pai(classe super)

        if (this.getSaldo() < valor) {
            System.out.println("Saldo insuficiente !");
        } else {
            setSaldo(getSaldo() - valor);
        }

    }

}

package pooprojeto;

import pooprojeto.Modelo.ContaBonificada;
import pooprojeto.Modelo.ContaAbstrata;
import pooprojeto.Modelo.ContaImposto;

public class ControllerConta {

    private IrepConta repositorio;

    public ControllerConta(IrepConta repositorio) {//ele não cria ele recebe a criação feita la na facade
        this.repositorio = repositorio;
    }

    public void inserir(ContaAbstrata conta) throws Exception {
        repositorio.inserir(conta);
    }

    public void remover(String numero) throws Exception {
        repositorio.remover(numero);
    }

    public void atualizar(ContaAbstrata conta) throws Exception {
        repositorio.atualizar(conta);
    }

    public ContaAbstrata procurar(String numero) throws Exception {
        ContaAbstrata conta = (ContaAbstrata) repositorio.procurar(numero);

        return conta;
    }

    public void debitar(String numero, double valor) throws Exception {
        ContaAbstrata conta = (ContaAbstrata) repositorio.procurar(numero);
        conta.debitar(valor);

    }

    public void creditar(String numero, double valor) throws Exception {
        ContaAbstrata conta = (ContaAbstrata) repositorio.procurar(numero);
        conta.creditar(valor);

    }

    public void transferir(double valor, ContaAbstrata conta) throws Exception {
        ContaAbstrata c = (ContaAbstrata) repositorio.procurar(conta.getNumero());
        c.transferir(valor, conta);

    }

    public void renderJuros(ContaImposto conta, double valor) throws Exception {
        conta.debitar(valor);
    }

    public void calcularBonus(ContaBonificada conta) {
        conta.calcularBonus();
    }

}

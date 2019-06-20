package pooprojeto;

import pooprojeto.Modelo.ContaBonificada;
import pooprojeto.Modelo.ContaAbstrata;
import pooprojeto.Modelo.ContaImposto;

public class ControllerG<T> {

    private IrepG<T> repositorio;

    void inserir(T t) throws Exception {
        repositorio.inserir(t);
    }

    public void remover(String m) throws Exception {
        repositorio.remover(m);
    }

    void atualizar(T t) throws Exception {
        repositorio.atualizar(t);
    }

    public T procurar(String m) throws Exception {
        T t = null;
        t = repositorio.procurar(m);
        return t;
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

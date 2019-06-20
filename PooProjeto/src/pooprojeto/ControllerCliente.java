package pooprojeto;

import pooprojeto.Modelo.Cliente;

public class ControllerCliente {

    private IrepCliente repositorio;

    public ControllerCliente(IrepCliente repositorio) {
        this.repositorio = repositorio;
    }

    public void inserir(Cliente cliente) throws Exception {
        repositorio.inserir(cliente);
    }

    public void remover(String cpf) throws Exception {
        repositorio.remover(cpf);
    }

    public void atualizar(Cliente cliente) throws Exception {
        repositorio.atualizar(cliente);
    }

    public Cliente procurar(String cpf) throws Exception {
        Cliente cliente = (Cliente) repositorio.procurar(cpf);
        return cliente;
    }

}

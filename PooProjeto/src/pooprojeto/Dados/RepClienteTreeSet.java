package pooprojeto.Dados;


import java.util.Set;
import java.util.TreeSet;
import pooprojeto.Modelo.Cliente;
import pooprojeto.Modelo.Cliente;
import pooprojeto.IrepCliente;
import pooprojeto.IrepCliente;

public class RepClienteTreeSet implements IrepCliente {

    private Cliente[] clientes;
    private int indice;
    private final int TAM = 100;
    private Set<Cliente> cliente;
    private int qtd = 0;

    public RepClienteTreeSet() {
        cliente = new TreeSet<>();

    }

    @Override
    public void inserir(Cliente object) throws Exception {
        if (this.qtd > TAM) {
            throw new Exception("Array cheio");
        } else {
            clientes[indice] = object;
            indice++;
            cliente.add(object);
            this.qtd++;
        }

    }

    @Override
    public void remover(String numero) throws Exception {
        if (existe(numero)) {
            int i = this.procurarIndice(numero);
            clientes[i] = clientes[indice - 1];
            clientes[indice - 1] = null;
            indice = indice - 1;
            cliente.remove(i);
            this.qtd--;
        } else {
            throw new Exception("Não Existe");
        }
    }

    @Override
    public Cliente procurar(String numero) throws Exception {
        if (cliente.contains(numero) == false) {
            throw new Exception("Não Existe");
        }
        return null;

    }

    @Override
    public void atualizar(Cliente object) throws Exception {
        int i = procurarIndice(object.getCpf());

        if (i != -1) {
            clientes[i] = object;
        } else {
            throw new Exception("Array cheio");

        }

    }

    @Override
    public boolean existe(String numero) {
        boolean resp = false;

        int i = this.procurarIndice(numero);

        if (i != -1) {
            resp = true;
        }

        return resp;

    }

    @Override
    public int getTam() {
        return this.indice;
    }

    @Override
    public int procurarIndice(String cpf) {
        int i = 0;
        int ind = -1;

        for (Cliente a : cliente) {
            if ((a.getCpf()).equals(cpf)) {
                ind = i;
                break;
            }
            i++;
        }
        return ind;

    }

}

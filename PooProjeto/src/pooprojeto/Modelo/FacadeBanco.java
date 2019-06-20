package pooprojeto.Modelo;

import pooprojeto.Modelo.TipoDeRepositorio;
import pooprojeto.Modelo.ContaBonificada;
import pooprojeto.Modelo.ContaAbstrata;
import pooprojeto.Modelo.Cliente;
import pooprojeto.Modelo.ContaImposto;
import pooprojeto.Dados.RepClienteArray;
import pooprojeto.Dados.RepContaArray;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import pooprojeto.ControllerCliente;
import pooprojeto.ControllerConta;
import pooprojeto.Dados.RepClienteTreeSet;
import pooprojeto.IrepCliente;

public class FacadeBanco {

    private ControllerConta ctrlConta;
    private ControllerCliente ctrlCliente;
    public static FacadeBanco fachada;
    private TipoDeRepositorio tiposRepositorio;

    //singleton, inicializa o objeto apena 1 e somenta 1 vez 
    public static FacadeBanco getFachada() throws IOException {//metodos estático não precisa criar um objeto para serem utilizado
        if (fachada == null) {
            fachada = new FacadeBanco();
        }
        return fachada;
    }

    private FacadeBanco() throws IOException {//fachada! apenas a propia classe pode inicialiar ela deixando em privado
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("\\src\\pooprojeto\\Properties.properties");
        prop.load(file);
        if (prop.get("array").equals(TipoDeRepositorio.ARRAY)) {
            ctrlCliente = new ControllerCliente(new RepClienteArray());//é a fachada quem inicializa os controladores, é ela quem diz o que o controlador vai receber para guardar os dados array ou hashMap
            ctrlConta = new ControllerConta(new RepContaArray());
        } else if (prop.get("treeSet").equals(TipoDeRepositorio.TREE)) {
            ctrlCliente = new ControllerCliente((IrepCliente) new RepClienteTreeSet());

        } else if (prop.get("hash").equals(TipoDeRepositorio.HASHMAP)) {
            //  ctrlCliente = new ControllerCliente(new RepContaMap());
        }

    }

    public ContaAbstrata consultarConta(String numero) throws Exception {
        ContaAbstrata conta = ctrlConta.procurar(numero);
        return conta;
    }

    public void removerConta(String numero) throws Exception {
        ctrlConta.remover(numero);

    }

    public void inserirConta(ContaAbstrata conta) throws Exception {
        ctrlConta.inserir(conta);
    }

    public void atualizarConta(ContaAbstrata conta) throws Exception {
        ctrlConta.atualizar(conta);
    }

    public void debitar(String numero, double valor) throws Exception {
        ctrlConta.debitar(numero, valor);
    }

    public void tranferir(ContaAbstrata conta, double valor) throws Exception {
        ctrlConta.transferir(valor, conta);
    }

    public void creditar(String numero, double valor) throws Exception {
        ctrlConta.creditar(numero, valor);

    }

    public void calcularBonus(ContaBonificada conta) {
        ctrlConta.calcularBonus(conta);

    }

    public void renderJuros(ContaImposto conta, double valor) throws Exception {
        ctrlConta.renderJuros(conta, valor);

    }

    public Cliente consultarCliente(String cpf) throws Exception {
        return ctrlCliente.procurar(cpf);
    }

    public void inserirCliente(Cliente cliente) throws Exception {
        ctrlCliente.inserir(cliente);
    }

    public void removerCliente(String cpf) throws Exception {
        ctrlCliente.remover(cpf);
    }

}

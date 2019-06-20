package pooprojeto.Modelo;

public abstract class ContaAbstrata {
    
    private String numero;
    private double saldo;
    private Cliente cliente;
    
    public ContaAbstrata(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void creditar(double valor) {
        this.saldo = saldo + valor;
    }

    public void transferir(double valor, ContaAbstrata conta) {
        this.debitar(valor);
        conta.creditar(valor);
    }
    
    public abstract void debitar(double valor);
    
}

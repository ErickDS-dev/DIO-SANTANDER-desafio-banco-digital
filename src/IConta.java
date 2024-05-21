public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void tranferir(double valor, IConta contaDestino);

    void imprimirExtrato();

}

import excepitions.accountNotFound;
import excepitions.insufficientFunds;

public interface IConta {

    /**
     * Realiza o saque de um valor específico da conta.
     *
     * @param valor O valor a ser sacado.
     * @throws IllegalArgumentException Se o valor for negativo ou zero.
     * @throws insufficientFunds Se não houver saldo suficiente para o saque.
     */
    void toWithdraw(double valor) throws IllegalArgumentException, insufficientFunds;

    /**
     * Realiza o depósito de um valor específico na conta.
     *
     * @param valor O valor a ser depositado.
     * @throws IllegalArgumentException Se o valor for negativo ou zero.
     */
    void depositar(double valor) throws IllegalArgumentException;

    /**
     * Transfere um valor específico para outra conta.
     *
     * @param valor O valor a ser transferido.
     * @param contaDestino A conta de destino para a transferência.
     * @throws IllegalArgumentException Se o valor for negativo ou zero.
     * @throws insufficientFunds Se não houver saldo suficiente para a transferência.
     */
    void transferir(double valor, IConta contaDestino) throws IllegalArgumentException, insufficientFunds, accountNotFound;

    /**
     * Imprime o extrato da conta.
     */
    void imprimirExtrato();

    /**
     * Obtém o saldo atual da conta.
     *
     * @return O saldo da conta.
     */
    double getBalance();

    /**
     * Obtém os detalhes da conta, como número da conta e agência.
     *
     * @return Os detalhes da conta.
     */
    String getDetalhesConta();

}

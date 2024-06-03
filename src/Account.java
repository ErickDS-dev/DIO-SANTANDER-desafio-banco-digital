import excepitions.insufficientFunds;
import lombok.Getter;

import java.security.SecureRandom;

public abstract class Account implements IConta {
    private static final short AGENCIA_PADRAO = 4456; // Agência Santander na minha cidade
    @Getter
    protected int agency;
    @Getter
    protected int accountNumber;
    private static final SecureRandom random = new SecureRandom(); //
    @Getter
    protected double balance;

    public Account() {
        this.agency = AGENCIA_PADRAO;
        this.accountNumber = gerarNumeroAleatorio();
    }
    @Override
    public void toWithdraw(double value) throws insufficientFunds {
        if (value <= 0) {
            throw new IllegalArgumentException("The withdrawal amount must be positive.");
        }
        if (balance < value) {
            throw new insufficientFunds("Saldo insuficiente para realizar o saque.");
        }
        balance -= value;
    }
    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor de depósito deve ser positivo.");
        }
        balance += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) throws IllegalArgumentException, insufficientFunds {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor de transferência deve ser positivo.");
        }
        this.toWithdraw(valor);
        contaDestino.depositar(valor);
    }
    private int gerarNumeroAleatorio() {
        int numero;
        do {
            numero = 100000000 + random.nextInt(900000000); // Gera um número aleatório de 9 dígitos
        } while (numero < 100000000 || numero > 999999999);
        return numero;
    }

    @Override
    public String toString() {
        return String.format("Agencia: %d\nNumero: %d\nSaldo: %.2f", agency, accountNumber, balance);
    }

}

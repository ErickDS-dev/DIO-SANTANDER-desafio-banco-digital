public class Main {
    public static void main(String[] args) {

        IConta cc = new ContaCorrente();
        IConta cp = new ContaPoupanca();

        cc.depositar(10.00);
        cc.tranferir( 10.0, cp);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
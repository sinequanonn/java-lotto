package lotto;

public class LottoStore {

    private LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void enter(Customer customer) {
        lottoMachine.sellLottoTo(customer);
    }
}

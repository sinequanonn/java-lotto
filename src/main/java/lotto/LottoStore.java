package lotto;

public class LottoStore {

    private LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void sellLottoTo(Customer customer, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            customer.buy(lottoMachine.makeLotto());
        }
    }
}

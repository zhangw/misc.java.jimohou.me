package protobuf.demo;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @author vincent
 * @date 2020/5/25
 */
@Slf4j
public class MlegPositionTest {
    @Test
    public void test(){
        MlegPositionProtos.MlegPosition.Builder builder = MlegPositionProtos.MlegPosition.newBuilder();
        builder.setId("id001");
        MoneyProtos.Money money = MoneyProtos.Money.newBuilder().setAmount("1234.142857").build();
        builder.addMoneyList(money);
        int tickerId = 90000123;
        builder.putMoneyMap(tickerId, money);
        MlegPositionProtos.MlegPosition mlegPosition = builder.build();
        log.info("mlegPosition representation:{}", mlegPosition);
    }
}

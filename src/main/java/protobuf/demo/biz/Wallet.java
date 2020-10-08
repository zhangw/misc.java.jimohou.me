package protobuf.demo.biz;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author vincent
 * @date 2020/5/25
 */
@Data
public class Wallet implements Serializable {
    private String name;

    private BigDecimal balance;

    private WalletType walletType;
}

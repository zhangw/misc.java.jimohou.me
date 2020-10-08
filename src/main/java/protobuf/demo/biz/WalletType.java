package protobuf.demo.biz;

import java.io.Serializable;

/**
 * @author vincent
 * @date 2020/5/25
 */
public enum WalletType implements Serializable {
    ALIPAY(1, "alipay"),
    WECHAT(2, "wechat");

    private int code;
    private String shortName;

    WalletType(int code, String shortName){
        this.code = code;
        this.shortName = shortName;
    }
}

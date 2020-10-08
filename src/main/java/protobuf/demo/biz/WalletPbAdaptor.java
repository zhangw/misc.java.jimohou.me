package protobuf.demo.biz;

import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.demo.WalletProtos;

import java.math.BigDecimal;

/**
 * @author vincent
 * @date 2020/5/25
 */
public class WalletPbAdaptor {
    public static Wallet parseFromPb(byte[] pbBytes) throws InvalidProtocolBufferException {
        WalletProtos.Wallet walletPb = WalletProtos.Wallet.parseFrom(pbBytes);
        Wallet wallet = new Wallet();
        wallet.setBalance(new BigDecimal(walletPb.getBalance()));
        wallet.setWalletType(WalletType.valueOf(walletPb.getType().name()));
        if(walletPb.getIsNameNull()){
            wallet.setName(null);
        }else{
            wallet.setName(walletPb.getName());
        }
        return wallet;
    }

    public static byte[] convertToPb(Wallet wallet){
        WalletProtos.Wallet.Builder builder = WalletProtos.Wallet.newBuilder();
        builder.setBalance(wallet.getBalance().toPlainString());
        builder.setType(WalletProtos.Wallet.WalletType.valueOf(wallet.getWalletType().name()));
        if(wallet.getName() != null){
            builder.setName(wallet.getName());
            builder.setIsNameNull(false);
        }else{
            builder.setName("");
            builder.setIsNameNull(true);
        }
        return builder.build().toByteArray();
    }
}

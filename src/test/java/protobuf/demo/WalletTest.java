package protobuf.demo;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import protobuf.demo.biz.Wallet;
import protobuf.demo.biz.WalletPbAdaptor;
import protobuf.demo.biz.WalletType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

/**
 * @author vincent
 * @date 2020/5/25
 */
@Slf4j
public class WalletTest {
    @Test
    public void testNullField(){
        try {
            WalletProtos.Wallet wallet = WalletProtos.Wallet.newBuilder()
                    .setName(null)
                    .setBalance("100.17")
                    .setType(WalletProtos.Wallet.WalletType.ALIPAY).build();
            log.info("wallet string representation:{}", wallet);
        }catch (NullPointerException nullPointerException){
            log.error("protobuf not allowd null", nullPointerException);
        }
        WalletProtos.Wallet wallet = WalletProtos.Wallet.newBuilder()
                .setBalance("100.17")
                .setType(WalletProtos.Wallet.WalletType.ALIPAY).build();
        Assert.assertEquals("", wallet.getName());
        log.info("wallet name default value is empty:{}", wallet.getName());
    }

    @Test
    public void testRawDeserialize() throws InvalidProtocolBufferException {
        WalletProtos.Wallet wallet = WalletProtos.Wallet.newBuilder()
                .setName("vincent")
                .setBalance("100.17")
                .setType(WalletProtos.Wallet.WalletType.ALIPAY).build();
        byte[] bytes = wallet.toByteArray();
        WalletProtos.Wallet walletRaw = WalletProtos.Wallet.parseFrom(bytes);
        log.info("the raw wallet deserialized by protobuf:{}", walletRaw);
    }

    @Test
    public void testWalletPbAdaptor() throws InvalidProtocolBufferException{
        Wallet wallet = new Wallet();
        wallet.setWalletType(WalletType.WECHAT);
        wallet.setBalance(new BigDecimal(-100.142857142857));
        byte[] bytes = WalletPbAdaptor.convertToPb(wallet);
        log.info("deserialied by adpator:{}, length:{}", bytes, bytes.length);
        Wallet wallet1 = WalletPbAdaptor.parseFromPb(bytes);
        log.info("serialized by adaptor:{}", wallet1);
        Assert.assertEquals(wallet, wallet1);
    }

    @Test
    public void testSerializeLength() throws IOException {
        Wallet wallet = new Wallet();
        wallet.setWalletType(WalletType.WECHAT);
        wallet.setBalance(new BigDecimal(-100.142857142857));
        byte[] bytesOfPb = WalletPbAdaptor.convertToPb(wallet);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(wallet);
        oos.close();
        oos.flush();
        byte[] bytesOfJdk = bos.toByteArray();
        bos.close();
        bos.flush();
        log.info("bytesOfPb length:{}, bytesOfJdk length:{}", bytesOfPb.length, bytesOfJdk.length);
    }
}

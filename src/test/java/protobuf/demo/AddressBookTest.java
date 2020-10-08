package protobuf.demo;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author vincent
 * @date 2020/5/25
 */
@Slf4j
public class AddressBookTest {
    @Test
    public void test() throws InvalidProtocolBufferException {
        AddressBookProtos.Person.PhoneNumber phoneNumber =
                AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("13900312001")
                        .setType(AddressBookProtos.Person.PhoneType.MOBILE).build();
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setId("id01")
                        .setName("name1")
                        .setEmail("email1")
                        .addPhones(phoneNumber).build();
        AddressBookProtos.AddressBook addressBook =
                AddressBookProtos.AddressBook.newBuilder().addPeople(person).build();
        log.info("addressBook string representation:{}", addressBook);
        byte[] bytes = addressBook.toByteArray();
        log.info("addressBook bytes of protobuf:{}", bytes);
        AddressBookProtos.AddressBook addressBook1 = AddressBookProtos.AddressBook.parseFrom(bytes);
        log.info("addressBook1 string representation:{}", addressBook1);
        Assert.assertEquals(addressBook, addressBook1);
    }
}

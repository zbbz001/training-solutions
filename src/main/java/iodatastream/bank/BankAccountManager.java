package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path folder) {
        Path path = folder.resolve(account.getAccountNumber() + ".dat");

        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path)))) {
            dataOutputStream.writeUTF(account.getAccountNumber());
            dataOutputStream.writeUTF(account.getOwner());
            dataOutputStream.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot write.", e);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(is))) {
            String accountNumber = dataInputStream.readUTF();
            String owner = dataInputStream.readUTF();
            double balance = dataInputStream.readDouble();

            return new BankAccount(accountNumber, owner, balance);

        } catch (IOException e) {
            throw new IllegalStateException("The file cannot read.", e);
        }
    }
}

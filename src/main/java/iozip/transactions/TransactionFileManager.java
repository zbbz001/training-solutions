package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path path, List<Transaction> transactionList) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Transaction transaction : transactionList) {
                zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(transaction.getId())));

                zipOutputStream.write((transaction.getTime().toString() + "\n").getBytes(StandardCharsets.UTF_8));
                zipOutputStream.write((transaction.getAccount() + "\n").getBytes(StandardCharsets.UTF_8));
                zipOutputStream.write((transaction.getAmount() + "\n").getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }
}

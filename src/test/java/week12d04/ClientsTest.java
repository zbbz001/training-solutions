package week12d04;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ClientsTest {

    @Test
    public void ClientTest() {
        Clients clients = new Clients();
        clients.add(new Client("Cody Coder", "123456789"));
        clients.add(new Client("Micky Mouse", "168498435"));
        clients.add(new Client("John James Rambo", "156349844"));

        Client client = clients.getClientByRegNumber("168498435");

        assertEquals("Micky Mouse", client.getName());

        assertEquals("[Client{name='John James Rambo', regNumber='156349844'}]", clients.findByName("James").toString());
    }
}
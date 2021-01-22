package week12d04;

import java.util.*;

public class Clients {
    Map<String, Client> clientMap = new HashMap<>();

    public void add(Client client) {
        clientMap.put(client.getRegNumber(), client);
    }

    public Client getClientByRegNumber(String regNumber) {
        Client client = clientMap.get(regNumber);

        if (client == null) {
            throw new IllegalArgumentException("Client is not exists!");
        }

        return client;
    }

    public List<Client> findByName(String pattern) {
        List<Client> clients = new ArrayList<>();

        for (Map.Entry<String, Client> entry : clientMap.entrySet()) {
            if (entry.getValue().getName().contains(pattern)) {
                clients.add(entry.getValue());
            }
        }

        return clients;
    }
}

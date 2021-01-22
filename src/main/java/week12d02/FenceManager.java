package week12d02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FenceManager {
    private Map<String, List<Fence>> fences = new HashMap<>();

    public FenceManager() {
        fences.put("odd", new ArrayList<Fence>());
        fences.put("even", new ArrayList<Fence>());
    }

    public static void main(String[] args) {
        FenceManager fm = new FenceManager();
        fm.fenceReader(FenceManager.class.getResourceAsStream("kerites.txt"));
        fm.fenceWriter("odd");
    }

    public void fenceReader(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                addFenceToMap(parts[0], new Fence(Integer.parseInt(parts[1]), parts[2]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot read!");
        }
    }

    public void fenceWriter(String side) {
        List<Fence> fenceList = fences.get(side);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fenceList.size(); i++) {
            Fence fence = fenceList.get(i);
            sb.append("(" + fence.getHouseNumber() + ")");

            for (int j = 0; j < fence.getWidth(); j++) {
                sb.append(fence.getColor());
            }
        }

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of("utcakep.txt")))) {
            writer.print(sb.toString());
        } catch (IOException e) {
            throw new IllegalStateException("File cannot write!");
        }
    }

    private void addFenceToMap(String part, Fence fence) {
        List<Fence> fenceList;
        int base = 2;

        if (part.equals("1")) {
            fenceList = fences.get("odd");
            base = 1;
        } else {
            fenceList = fences.get("even");
        }

        fence.setHouseNumber(base + fenceList.size() * 2);

        fenceList.add(fence);
    }

    public List<Fence> sortAllFences() {
        Iterator values = fences.entrySet().iterator();
        List<Fence> sorted = new ArrayList<>();

        while (values.hasNext()) {
            sorted.addAll((List) ((Map.Entry) values.next()).getValue());
        }
        Collections.sort(sorted);

        return sorted;
    }
}

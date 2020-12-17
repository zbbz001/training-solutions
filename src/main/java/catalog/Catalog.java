package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int over) {
        if (!Validators.isPositive(over)) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        double sum = 0;
        int numOfItem = 0;

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature() && catalogItem.numberOfPagesAtOneItem() > over) {
                sum += catalogItem.numberOfPagesAtOneItem();
                numOfItem++;
            }
        }

        if (numOfItem == 0) {
            throw new IllegalArgumentException("No page");
        }

        return sum / numOfItem;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(i);
                return;
            }
        }
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> CatalogItemHasAudio = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                CatalogItemHasAudio.add(catalogItem);
            }
        }
        return CatalogItemHasAudio;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> CatalogItemHasPrinted = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                CatalogItemHasPrinted.add(catalogItem);
            }
        }
        return CatalogItemHasPrinted;
    }

    public int getAllPageNumber() {
        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> results = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (searchCriteria.hasContributor() && catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                results.add(catalogItem);
            } else if (searchCriteria.hasTitle() && catalogItem.getTitles().contains(searchCriteria.getTitle())) {
                results.add(catalogItem);
            }
        }

        return results;
    }
}


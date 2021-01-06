package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    List<Photo> photoList = new ArrayList<>();

    public void addPhoto(String... photoNames) {
        for (String photoName : photoNames) {
            photoList.add(new Photo(photoName));
        }
    }

    public void starPhoto(String photoName, Quality quality) {
        for (Photo photo : photoList) {
            if (photo.getName().equals(photoName)) {
                photo.setQuality(quality);
                return;
            }
        }

        throw new PhotoNotFoundException("Photo not found");
    }

    public int numberOfStars() {
        int sum = 0;
        for (Photo photo : photoList) {
            sum += photo.getQuality().getValue();
        }

        return sum;
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photoList);
    }
}
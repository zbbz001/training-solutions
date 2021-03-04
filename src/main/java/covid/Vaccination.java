package covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vaccination {

    private long citizenId;
    private LocalDate vaccinationTime;
    private int vaccinationStatus;
    private String vaccinationNote;
    private Vaccine vaccine;

    public Vaccination(long citizenId, LocalDate vaccinationTime, int vaccinationStatus, String vaccinationNote, Vaccine vaccine) {
        this.citizenId = citizenId;
        this.vaccinationTime = vaccinationTime;
        this.vaccinationStatus = vaccinationStatus;
        this.vaccinationNote = vaccinationNote;
        this.vaccine = vaccine;
    }

    public int getVaccinationStatus() {
        return vaccinationStatus;
    }

    public LocalDate getVaccinationTime() {
        return vaccinationTime;
    }

    public long getCitizenId() {
        return citizenId;
    }

    public String getVaccinationNote() {
        return vaccinationNote;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "citizenId=" + citizenId +
                ", vaccinationTime=" + vaccinationTime +
                ", vaccinationStatus=" + vaccinationStatus +
                ", vaccinationNote='" + vaccinationNote + '\'' +
                ", vaccine=" + vaccine +
                '}';
    }

    public String getVaccinationInfoText() {
        return " időpont: " + vaccinationTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.")) +
                "   vakcina típusa: " + vaccine.getName();
    }
}

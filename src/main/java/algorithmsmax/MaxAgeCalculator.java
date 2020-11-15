package algorithmsmax;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainerList) {
        Trainer tempTrainer = null;

        for(Trainer trainer:trainerList) {
            if(tempTrainer== null || trainer.getAge() > tempTrainer.getAge()) {
                tempTrainer = trainer;
            }
        }

        return tempTrainer;
    }
}

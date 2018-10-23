package kdg.be.demo.Services;

import kdg.be.demo.FineCalculators.EmissionFineCalculator;
import kdg.be.demo.FineCalculators.FineCalculator;
import kdg.be.demo.FineCalculators.SpeedFineCalculator;
import kdg.be.demo.Model.CameraMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FineService {
    List<FineCalculator> fineCalculators;

    public FineService(EmissionFineCalculator efc, SpeedFineCalculator sfc) {
        this.fineCalculators = new ArrayList<>();
        fineCalculators.add(efc);
        //fineCalculators.add(sfc);
    }

    public void CalcFines(CameraMessage cm){
        for (FineCalculator fc : fineCalculators){
            fc.Calculate(cm);
        }
    }
}

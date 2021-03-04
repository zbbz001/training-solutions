package covid.module;

import covid.dao.VaccinationsDao;
import covid.module.FromConsole;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

public class GenerateReport extends FromConsole {
    public GenerateReport(DataSource dataSource) {
        super(dataSource);
    }

    public void runModule() {
        VaccinationsDao vaccinationsDao = new VaccinationsDao(dataSource);
        List<HashMap<String, Object>> reportResult = vaccinationsDao.selectVaccinationsByZip();

        reportResult.forEach(e -> writeToConsoleLn(() -> String.format("irsz: %-8s oltatlan:%-5s 1x oltott:%-5s 2x oltott:%-5s",
                e.get("zip_code").toString(), e.get("sum_no_vacc").toString(),
                e.get("sum_vacc_x1").toString(), e.get("sum_vacc_x2").toString())));

        writeToConsoleLn(() -> "\nRiport vége\n");
    }
}

package bg.softuni.MobiLeLe.service;


import bg.softuni.MobiLeLe.model.view.BrandViewModel;
import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();
}

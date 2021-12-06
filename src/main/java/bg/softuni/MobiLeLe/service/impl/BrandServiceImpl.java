package bg.softuni.MobiLeLe.service.impl;

import bg.softuni.MobiLeLe.model.entity.BrandEntity;
import bg.softuni.MobiLeLe.model.entity.ModelEntity;
import bg.softuni.MobiLeLe.model.view.BrandViewModel;
import bg.softuni.MobiLeLe.model.view.ModelViewModel;
import bg.softuni.MobiLeLe.repository.BrandRepository;
import bg.softuni.MobiLeLe.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel().
                        setName(brandEntity.getName());

                    brandViewModel.setModels(
                        brandEntity.
                            getModels().
                            stream().
                            map(this::map).
                            collect(Collectors.toList()));
                    return brandViewModel;
                })
                .collect(Collectors.toList());
    }

    private ModelViewModel map(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity, ModelViewModel.class);
    }
}

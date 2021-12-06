package bg.softuni.MobiLeLe.service;

import bg.softuni.MobiLeLe.model.binding.OfferAddBindModel;
import bg.softuni.MobiLeLe.model.service.OfferAddServiceModel;
import bg.softuni.MobiLeLe.model.service.OfferUpdateServiceModel;
import bg.softuni.MobiLeLe.model.view.OfferDetailsView;
import bg.softuni.MobiLeLe.model.view.OfferSummaryView;
import java.util.List;

public interface OfferService {
  void initializeOffers();

  List<OfferSummaryView> getAllOffers();

  OfferDetailsView findById(Long id, String currentUser);

  void deleteOffer(Long id);

  boolean isOwner(String userName, Long id);

  void updateOffer(OfferUpdateServiceModel offerModel);

  OfferAddServiceModel addOffer(OfferAddBindModel offerAddBindModel, String ownerId);
}

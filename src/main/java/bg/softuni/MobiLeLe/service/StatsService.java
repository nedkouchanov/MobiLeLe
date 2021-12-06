package bg.softuni.MobiLeLe.service;

import bg.softuni.MobiLeLe.model.view.StatsView;

public interface StatsService {
  void onRequest();
  StatsView getStats();
}

package service;



import model.GymPackages;

import java.util.List;

public interface IGymPackagesService {
    List<GymPackages> getAllGymPackages();
    GymPackages findGymPackagesById(long idGymPackages);
    void updateGymPackagesById(long idGymPackages, GymPackages gymPackages);
    void deleteGymPackagesById(long idGymPackages);
    void addGymPackages(GymPackages user);
    float getPriceByGymPackagesId(long id);
    boolean checkHasPtByGymPackagesId(long id);

    List<GymPackages> searchGymPackagesByName(String keyName);

}


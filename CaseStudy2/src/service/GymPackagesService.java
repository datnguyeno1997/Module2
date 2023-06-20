package service;

import config.Config;


import model.EPt;
import model.GymPackages;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class GymPackagesService implements IGymPackagesService {
    private final String pathGymPackages = "D:\\moduel2\\CaseStudy2\\src\\data\\gympackages.txt";

    public List<GymPackages> getAllGymPackages() {
        return FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
    }

    public GymPackages findGymPackagesById(long idGymPackages) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        for (GymPackages c : gymPackagess) {
            if (c.getId() == idGymPackages) {
                return c;
            }
        }
        return null;
    }

    public void updateGymPackagesById(long idGymPackages, GymPackages gymPackages) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        for (GymPackages c : gymPackagess) {
            if (c.getId() == idGymPackages) {
                c.setName(gymPackages.getName());
                c.setPrice(gymPackages.getPrice());

            }
        }
        FileUtils.writeFile(pathGymPackages, gymPackagess);
    }

    public void deleteGymPackagesById(long idGymPackages) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        for (int i = 0; i < gymPackagess.size(); i++) {
            if (gymPackagess.get(i).getId() == idGymPackages) {
                gymPackagess.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathGymPackages, gymPackagess);
    }

    public void addGymPackages(GymPackages gymPackages) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        gymPackagess.add(gymPackages);
        FileUtils.writeFile(pathGymPackages, gymPackagess);
    }

    public float getPriceByGymPackagesId(long id) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        for (GymPackages c : gymPackagess) {
            if (c.getId() == id) {
                return c.getPrice();
            }
        }
        return 0;
    }

    public boolean checkHasPtByGymPackagesId(long id) {
        List<GymPackages> gymPackagess = FileUtils.readFile(pathGymPackages, Config.TYPE_GYMPACKAGES);
        for (GymPackages c : gymPackagess) {
            if (c.getId() == id) {
                if (c.getePt() == EPt.KHÔNG) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public List<GymPackages> searchGymPackagesByName(String keyName) {
        List<GymPackages> gymPackagess = getAllGymPackages();
        List<GymPackages> results = new ArrayList<>();

        for (GymPackages u : gymPackagess) {
            if (u.getName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(u);
            }
        }
        return results;
    }

}
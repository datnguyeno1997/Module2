package service;

import config.Config;
import model.Pt;
import model.Pt;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class PtService implements IPtService{
    private final String pathPt = "D:\\moduel2\\CaseStudy2\\src\\data\\pt.txt";
    public List<Pt> getAllPt() {
        return FileUtils.readFile(pathPt, Config.TYPE_PT);
    }
    public Pt findPtById(long idPt) {
        List<Pt> pts = FileUtils.readFile(pathPt, Config.TYPE_PT);
        for (Pt c : pts) {
            if (c.getId() == idPt) {
                return c;
            }
        }
        return null;
    }
    public void updatePtById(long idPt, Pt pt) {
        List<Pt> pts = FileUtils.readFile(pathPt, Config.TYPE_PT);
        for (Pt c : pts) {
            if (c.getId() == idPt) {
                c.setIdStaff(pt.getIdStaff());
                c.setIdCustomer(pt.getIdCustomer());
                c.setTimeStart(pt.getTimeStart());
                c.setTime(pt.getTime());

            }
        }
        FileUtils.writeFile(pathPt, pts);
    }

    public void deletePtById(long idPt) {
        List<Pt> pts = FileUtils.readFile(pathPt, Config.TYPE_PT);
        for (int i = 0; i < pts.size(); i++) {
            if (pts.get(i).getId() == idPt) {
                pts.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathPt, pts);
    }

    public void addPt(Pt pt) {
        List<Pt> pts = FileUtils.readFile(pathPt, Config.TYPE_PT);
        pts.add(pt);
        FileUtils.writeFile(pathPt, pts);
    }


//    public List<Pt> searchPtByName(String keyName) {
//        List<Pt> pts = getAllPt();
//        List<Pt> results = new ArrayList<>();
//
////        for (Pt u : pts) {
////            if (u.getFullName().toLowerCase().contains(keyName.toLowerCase())) {
////                results.add(u);
////            }
////        }
//        return results;
//    }
}

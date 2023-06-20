package service;

import model.Pt;

import java.util.List;

public interface IPtService {
    List<Pt> getAllPt();
    Pt findPtById(long idPt);
    void updatePtById(long idPt, Pt pt);
    void deletePtById(long idPt);
    void addPt(Pt pt);
//
//    List<Pt> searchPtByName(String keyName);
}

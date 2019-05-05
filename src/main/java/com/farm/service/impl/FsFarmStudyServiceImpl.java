package com.farm.service.impl;

import com.farm.bean.FsFarmStudy;
import com.farm.dao.FsFarmStudyMapper;
import com.farm.service.interfaces.IFsFarmStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsFarmStudyServiceImpl implements IFsFarmStudyService {

    @Autowired
    private FsFarmStudyMapper fsFarmStudyMapper;

    @Override
    public List<FsFarmStudy> getAllFarmStudy() {
        return fsFarmStudyMapper.selectAllFarmStudy();
    }

    @Override
    public FsFarmStudy getFarmStudyById(Integer farmstudyId) {
        return fsFarmStudyMapper.selectByPrimaryKey(farmstudyId);
    }

    @Override
    public List<FsFarmStudy> getFsFarmnewsByName(String farmstudyName) {
        return fsFarmStudyMapper.selectFarmStudyByName(farmstudyName);
    }

    @Override
    public int insertSelective(FsFarmStudy record) {
        return fsFarmStudyMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(FsFarmStudy record) {
        return fsFarmStudyMapper.updateByPrimaryKeySelective(record);
    }
}

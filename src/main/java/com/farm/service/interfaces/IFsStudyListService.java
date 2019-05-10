package com.farm.service.interfaces;

import com.farm.bean.FsStudylist;

import java.util.List;


public interface IFsStudyListService {

    List<FsStudylist> getAllChildFsStudylist();

    List<FsStudylist> getAllFsStudylist();

    FsStudylist getStudyListById(Integer studylistId);
    FsStudylist getStudyListBySeq(Integer studylistSeq);

}

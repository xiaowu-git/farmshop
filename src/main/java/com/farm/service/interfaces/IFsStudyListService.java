package com.farm.service.interfaces;

import com.farm.bean.FsStudylist;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/18 0018
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public interface IFsStudyListService {

    List<FsStudylist> getAllChildFsStudylist();

    List<FsStudylist> getAllFsStudylist();

    FsStudylist getStudyListById(Integer studylistId);
    FsStudylist getStudyListBySeq(Integer studylistSeq);

}

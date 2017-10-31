package com.emall.service;

import com.emall.common.ServerResponse;
import com.emall.pojo.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}

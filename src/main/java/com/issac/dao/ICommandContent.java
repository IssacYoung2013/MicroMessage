package com.issac.dao;

import com.issac.bean.CommandContent;

import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-07-02
 * desc:
 *
 */
public interface ICommandContent {
    void insertOne(CommandContent content);

    void insertBatch(List<CommandContent> contentList);
}
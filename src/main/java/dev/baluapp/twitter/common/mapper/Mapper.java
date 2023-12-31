package dev.baluapp.twitter.common.mapper;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

public interface Mapper<D, S> {
    D map(S source);
}

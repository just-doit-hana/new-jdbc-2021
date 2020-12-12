package com.laptrinhweb.mapper;

import java.sql.ResultSet;

public interface Rowmapper<T>{
    T mapRow(ResultSet rs);

}

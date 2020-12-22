package com.laptrinhweb.paging;

import com.laptrinhweb.sort.Sorter;

public interface Pageble {
Integer getPage();
Integer getOffset();
Integer getLimit();
Sorter getSorter();


}

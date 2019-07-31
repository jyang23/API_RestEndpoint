package com.jy.template.Repository;

import com.jy.template.Beans.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Long> {
    Data findByData(String data);
}

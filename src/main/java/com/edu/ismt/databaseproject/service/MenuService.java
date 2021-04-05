package com.edu.ismt.databaseproject.service;

import com.edu.ismt.databaseproject.entity.Menu;
import java.util.List;

public interface MenuService {
    List<Menu> getAll();
    Menu getById(int id);
    void save(Menu menu);
    void delete(int id);
}

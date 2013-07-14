package com.github.theresajayne.standaloneexample.model.dao;

import com.github.theresajayne.standaloneexample.model.beans.StandaloneVO;

import java.util.List;

public interface StandaloneDao {
    public List findAll();

    void save(StandaloneVO standaloneVO);
}

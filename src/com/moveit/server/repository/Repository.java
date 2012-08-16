package com.moveit.server.repository;

import com.moveit.client.model.Creater;
import com.moveit.client.model.Model;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.dao.JDO;

import java.util.Collection;

/**
 *
 */
public abstract class Repository<J extends JDO, M extends Model, C extends Creater> {

    protected Converter<J, M, C> conv;
    protected Dao<J> dao;


    public Repository(Dao<J> dao, Converter<J, M, C> con){
        this.conv = con;
        this.dao = dao;
    }

    public Converter<J, M, C> getConverter() {
        return conv;
    }

    public Dao<J> getDao() {
        return dao;
    }

    public Collection<M> findBy(FindByOneParam f){
        return getConverter().convertJDOs(getDao().findBy(f));
    }

    public M create(C creater) {
        J jdo = getDao().create(getConverter().convert(creater));
        return getConverter().convert(jdo);
    }

    public M get(Long id) {
        return getConverter().convert(getDao().read(id));
    }

    public Collection<M> getAll() {
        return getConverter().convertJDOs(getDao().readAll());
    }


    public void delete(Long id) {
        getDao().delete(id);
    }

    public void deleteAll(FindByOneParam param){
        getDao().deleteAll(param);
    }

    protected void deleteAll(Collection<J> jdos) {
        getDao().deleteAll(jdos);
    }
    

    public abstract Class<M> getRepositoryType();


}

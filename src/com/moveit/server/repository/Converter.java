package com.moveit.server.repository;

import com.moveit.client.model.Creater;
import com.moveit.client.model.Model;
import com.moveit.server.dao.JDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public abstract class Converter <J extends JDO, M extends Model, C extends Creater> {

    public abstract J convert(C creater);
    
    public abstract M convert(J jdo);

    public List<M> convertJDOs(Collection<J> jdos) {
        if (jdos == null) {
            return null;
        }
        List<M> rs = new ArrayList<M>();
        for (J jdo : jdos) {
            rs.add(convert(jdo));
        }
        return rs;
    }

}

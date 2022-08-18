package com.monitorsensors.repository;

import com.monitorsensors.entity.Sensor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SensorRepositoryImpl implements SensorRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sensor> getAllSensors() {
        return em.createQuery("from Sensor",Sensor.class).getResultList();
    }

    @Override
    public void saveOrUpdateSensor(Sensor sensor) {
        Sensor merge = em.merge(sensor);
        merge.setId(merge.getId());
    }

    @Override
    public Sensor getSensor(int id) {
        return em.find(Sensor.class,id);
    }

    @Override
    public void deleteSensor(int id) {
        Query query=em.createQuery("delete from Sensor where id =:sensorId");
        query.setParameter("sensorId",id);
        query.executeUpdate();

    }

    @Override
    public List<Sensor> searchForMatches(String s) {

        return getAllSensors();
    }
}

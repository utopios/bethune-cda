package com.example.correctionhotel.repository;

import com.example.correctionhotel.entity.Room;
import com.example.correctionhotel.util.hibernate.ServiceHibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository extends BaseRepository<Room> {

    public RoomRepository(ServiceHibernate serviceHibernate) {
        super(serviceHibernate);
    }

    public List<Room> findAll() {
        Query<Room> query = _session.createQuery("from Room", Room.class);
        return query.list();
    }
}

package com.example.correctionhotel.repository;

import com.example.correctionhotel.entity.Customer;
import com.example.correctionhotel.entity.Reservation;
import com.example.correctionhotel.util.hibernate.ServiceHibernate;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationRepository extends BaseRepository<Reservation> {
    public ReservationRepository(ServiceHibernate serviceHibernate) {
        super(serviceHibernate);
    }

    public List<Reservation> findAll() {
        Query<Reservation> query = _session.createQuery("from Reservation", Reservation.class);
        return query.list();
    }
}

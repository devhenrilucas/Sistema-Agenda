package dao;

import java.util.List;
import model.entities.Venue;

public interface VenueDAO {
	 void insert(Venue obj);
	 void update(Venue obj);
	 void deletById(Integer id);
	 Venue findById(Integer id);
	 List<Venue> findAll();
}

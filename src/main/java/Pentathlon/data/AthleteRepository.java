package Pentathlon.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
public interface AthleteRepository extends JpaRepository<Athlete, Integer>{
	Athlete findByName(String name);
	@Transactional
    Long deleteByName(String name);
	void deleteById(Integer id);
}

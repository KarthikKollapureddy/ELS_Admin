package coms.Admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Admin.bean.Grades;

@Repository
public interface GradeDao extends JpaRepository<Grades, Integer> {

	boolean existsByGradName(String gradName);

	

	

	Grades findByGradId(Integer gradId);



	void deleteByGradId(Integer gradId);

}

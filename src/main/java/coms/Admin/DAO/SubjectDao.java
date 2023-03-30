package coms.Admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Admin.bean.Subjects;

@Repository
public interface SubjectDao extends JpaRepository<Subjects, Integer> {

	Subjects findBySubName(String subName);

	Subjects findBySubId(Integer id);

}

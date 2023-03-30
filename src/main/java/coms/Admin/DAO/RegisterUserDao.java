package coms.Admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Admin.bean.Register;

@Repository
public interface RegisterUserDao extends JpaRepository<Register, Integer> {

}

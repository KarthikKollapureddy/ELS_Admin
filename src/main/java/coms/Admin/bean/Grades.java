package coms.Admin.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="grade_info")
public class Grades {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int gradId;
	public String gradName;
	
	
	
	

}

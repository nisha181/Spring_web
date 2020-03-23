package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.model.Student;

public class StudentDaoImpl implements StudentDao {

	
	private List<Student> list=new ArrayList<>();
	@Override
	public String insert(Student s) {
		if(list.add(s))
			return "Success";
		else
			return "Fail";
	}

	@Override
	public String delete(Student s) {
		String flag="Deletion Failure";
		int i=0;
		for(Student st:list)
		{
			
			if(st.getId()==s.getId())
			{
				list.remove(i);
				flag="Deletion Successful";
				break;
			}
			i++;
		}
		return flag;
	}

	@Override
	public String update(Student s) {
		String flag=" ";
		for(Student st:list)
		{
			if(st.getId()==s.getId())
			{
				st.setName(s.getName());
				flag="Success";
			}
			else
			{
				flag="Fail";
			}
		}
		return flag;
	}

	@Override
	public List<Student> getAll() {		
		return list;
	}
	
}

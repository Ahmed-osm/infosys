package com.project_zero.utility;

import com.project_zero.dao.ProjectDao;
import com.project_zero.dao.ProjectDaoInterface;

public class DaoFactory {

	public static ProjectDaoInterface createObject() {
		// TODO Auto-generated method stub
		return new ProjectDao();
	}

}

package com.project_zero.dao;

import com.project_zero.entity.ProjectUser;

public interface ProjectDaoInterface {

	int createprofiledao(ProjectUser pu);

	boolean logindao(ProjectUser pu);

	ProjectUser viewprofile(ProjectUser pu);

	int deletedao(ProjectUser pu);

	ProjectUser viewalldao();

}

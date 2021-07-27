package com.project_zero.utility;

import com.project_zero.controller.ProjectController;
import com.project_zero.controller.ProjectControllerInterface;

public class ControllerFactory {

	public static ProjectControllerInterface createObject() {
		return new ProjectController();
	}
}


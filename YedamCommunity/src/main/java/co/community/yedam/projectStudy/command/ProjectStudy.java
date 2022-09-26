package co.community.yedam.projectStudy.command;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.community.yedam.common.Command;
import co.community.yedam.projectStudy.service.ProjectStudyService;
import co.community.yedam.projectStudy.service.ProjectStudyServiceImpl;
import co.community.yedam.projectStudy.service.ProjectStudyVO;

public class ProjectStudy implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("커멘드로 왔어?");
		ProjectStudyService dao = new ProjectStudyServiceImpl();
		List<ProjectStudyVO> list = dao.projectStudySelectList();
		
		for (ProjectStudyVO vo : list) {
			// 언어가 여러개면 언어 사이에 # 붙이기
			if (vo.getProjectStudyLanguage().indexOf(",") != -1) {
				String[] strArr = vo.getProjectStudyLanguage().split(",");
				System.out.println("strArr =>  " + Arrays.toString(strArr));
				
				for (int i = 0; i < strArr.length; i++) {
					strArr[i] = strArr[i].trim();
					System.out.println("str.trim() =>  " + "\"" + strArr[i] + "\"");
				}
				
				String result = String.join(" #", strArr);
				System.out.println(result);
				vo.setProjectStudyLanguage(result);
			}
			
		}
		
		request.setAttribute("list", list);
		
		return "projectStudy/projectStudy/projectStudy";
	}

}

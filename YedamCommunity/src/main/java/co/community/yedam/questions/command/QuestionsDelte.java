package co.community.yedam.questions.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.community.yedam.common.Command;
import co.community.yedam.questions.service.questionsService;
import co.community.yedam.questions.service.questionsServiceImpl;
import co.community.yedam.questions.service.questionsVO;

public class QuestionsDelte implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 삭제
		String viewPage="questions/questionsError";
		questionsService dao = new questionsServiceImpl();
		questionsVO vo = new questionsVO();
		vo.setQuestionsId(Integer.valueOf(request.getParameter("id")));
		
		int n = dao.questionsDelete(vo);
		if(n != 0) {
			request.setAttribute("vo", vo);
			viewPage="noticeSelectList.do";
		}else {
			request.setAttribute("message", "게시글 삭제가 실패하였습니다.!");
		}
		return null;
	}

}

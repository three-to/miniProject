package co.community.yedam.freeBoard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.community.yedam.common.Command;

public class FreeBoard implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "main/freeBoard/freeBoard";
	}

}
package com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GameDAO;
import com.dto.GameDTO;

public class GameService {
	
	public List<GameDTO> newGameListSelect() {
		List<GameDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			GameDAO dao = new GameDAO();
			list = dao.newGameListSelect(session);
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			session.close();
		}
		return list;
	}
	
	public List<GameDTO> recommendGameListSelect() {
		List<GameDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			GameDAO dao = new GameDAO();
			list = dao.recommendGameListSelect(session);
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			session.close();
		}
		return list;
	}
	
	public List<GameDTO> tagGameListSelect(String[] gameTags) {
		List<GameDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			GameDAO dao = new GameDAO();
			list = dao.tagGameListSelect(session, gameTags);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}

package com.ideabobo.service;

import java.util.List;
import java.util.Map;

import com.ideabobo.model.Changci;
import com.ideabobo.util.Page;

public interface ChangciService {
	public void save(Changci model);
	public void update(Changci model);
	public Changci find(String uuid);
	public Changci find(Changci model);
	public void delete(Integer uuid);
	public List<Changci> list();
	public Page findByPage(Page page,Map paramsMap);
}

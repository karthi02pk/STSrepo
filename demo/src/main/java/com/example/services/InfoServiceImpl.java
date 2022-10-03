package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Info;
import com.example.repositories.InfoRepository;

@Service
@Transactional
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	InfoRepository repository;

	@Override
	public Info getInfobyId(Integer Id) {
		
		Optional<Info> result=	repository.findById(Id);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}

	@Override
	public void deleteInfo() {
		repository.deleteAll();
		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addInfo(Info inf) {
		repository.save(inf);	
	}

	@Override
	public void deleteById(Integer Id) {
		repository.deleteById(Id);
	}

	public ArrayList<Info> getAllInfo() {
		ArrayList list = new ArrayList();
		list = (ArrayList) repository.findAll();
		return list;
	}
}

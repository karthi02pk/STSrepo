package com.example.services;

import com.example.demo.Info;

public interface InfoService {

	Info getInfobyId(Integer Id);
	void deleteInfo();
	void deleteById(Integer Id);
	void addInfo(Info inf);
}

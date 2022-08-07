package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.example.services.InfoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@SuppressWarnings("unchecked")
@Api(value = "Rest API's")
@RestController
public class DemoController {
	
	@Autowired
	InfoServiceImpl infoservice;
	
		static HashMap dataMap = new HashMap<String,String>();
		static {
			dataMap.put("1","One");
			dataMap.put("2","two");
			dataMap.put("3","three");
		}

@RequestMapping(value="/getdata",method = RequestMethod.GET)
	public ResponseEntity<String> getData(){
		return new ResponseEntity<>(dataMap.values().toString(),HttpStatus.OK);
	}
	
@RequestMapping(value="/removedata",method = RequestMethod.POST)
	public ResponseEntity<String> deleteData(@RequestParam("id") String Id){
		dataMap.remove(Id);
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}

@SuppressWarnings("unchecked")
@RequestMapping(value="/adddata",method = RequestMethod.POST)
public ResponseEntity<String> addData(@RequestParam("id") String Id , @RequestParam("value") String value){
	dataMap.put(Id , value);
	return new ResponseEntity<>("Added successfully",HttpStatus.OK);
}

@RequestMapping(value="/error",method = RequestMethod.GET)
public ResponseEntity<String> handleException() throws Exception{
	throw new Exception();
} 
//---------------------------------------------------------------------------------
@ApiOperation(value = "This API is used to get data by ID." ,response = String.class)
@ApiResponses(value = { @ApiResponse(code = 200 , message = "OK"), @ApiResponse(code = 500 , message = "Internal server error")} )
@RequestMapping(value="/getdatabyId", method = RequestMethod.GET)
public ResponseEntity<String> getDataById(@RequestParam("id") String Id) throws Exception{
	    String result = null;
	    Info inf = infoservice.getInfobyId(Integer.parseInt(Id));
	    result = new Gson().toJson(inf, Info.class);
	    return new ResponseEntity<>(result,HttpStatus.OK);	
}

@ApiOperation(value = "This API is used to Delete data by ID." ,response = String.class)
@ApiResponses(value = { @ApiResponse(code = 200 , message = "OK"), @ApiResponse(code = 500 , message = "Internal server error")} )
@RequestMapping(value="/deletedatabyId", method = RequestMethod.POST)
public ResponseEntity<String> deleteDataById(@RequestParam("id") String Id) throws Exception{
	    infoservice.deleteById(Integer.parseInt(Id));
	    return new ResponseEntity<>("deleted successfully",HttpStatus.OK);	
}

@ApiOperation(value = "This API is used to All data." ,response = String.class)
@ApiResponses(value = { @ApiResponse(code = 200 , message = "OK"), @ApiResponse(code = 500 , message = "Internal server error")} )
@RequestMapping(value="/getAlldata", method = RequestMethod.GET)
public ResponseEntity<String> getAllData() throws Exception{
	    Gson gson =   new Gson();
	    ArrayList<Info> list = new ArrayList();
		list = infoservice.getAllInfo();
		String jsonstr =gson.toJson(list);
	    return new ResponseEntity<>(jsonstr,HttpStatus.OK);	
}

@ApiOperation(value = "This API is used to Add data into DB." ,response = String.class)
@ApiResponses(value = { @ApiResponse(code = 200 , message = "OK"), @ApiResponse(code = 500 , message = "Internal server error")} )
@RequestMapping(value="/addInfo", method = RequestMethod.POST)
public ResponseEntity<String> addInfo(@RequestBody Info inf) throws Exception{
	    infoservice.addInfo(inf);
	    return new ResponseEntity<>("added successfully",HttpStatus.OK);	
}

@RequestMapping(value="/page")
public ModelAndView page() {
	
	return new ModelAndView("page").addObject("message", "****");
}
}

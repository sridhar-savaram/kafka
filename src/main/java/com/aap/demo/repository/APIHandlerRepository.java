package com.aap.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class APIHandlerRepository {

	@Autowired
	EntityManager entityManager;
	
	public String processAPI(String interfaceCode, String payload) {
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("API_HANDLER");
		  procedureQuery.registerStoredProcedureParameter("P_INTERFACE_CODE", String.class, ParameterMode.IN);
		  procedureQuery.registerStoredProcedureParameter("P_JSON_IN", String.class, ParameterMode.IN);
		  procedureQuery.registerStoredProcedureParameter("P_JSON_OUT", String.class, ParameterMode.OUT);
		  procedureQuery.registerStoredProcedureParameter("P_PROCESS_FLAG", String.class, ParameterMode.OUT);
		  procedureQuery.registerStoredProcedureParameter("P_PROCESS_MSG", String.class, ParameterMode.OUT);
		  
		  procedureQuery.setParameter("P_INTERFACE_CODE", (String)interfaceCode);
		  procedureQuery.setParameter("P_JSON_IN", (String)payload);
		  
		  procedureQuery.execute();
		  
		  return (String)procedureQuery.getOutputParameterValue("P_JSON_OUT");
	}
}

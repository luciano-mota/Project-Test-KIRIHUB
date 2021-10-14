package com.project.kirihub.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.kirihub.entity.TaxaSelic;

@Service
public class SelicService {
	
	static String urlSelic = "http://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados";
	
	public ResponseEntity<?> getTaxaSelicPorDias(String dias){
		String taxaSelicJson = urlSelic + "/ultimos/" + dias + "?formato=json";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TaxaSelic[]> resposta =  restTemplate.getForEntity(taxaSelicJson,  TaxaSelic[].class);
		return resposta;
	}
}

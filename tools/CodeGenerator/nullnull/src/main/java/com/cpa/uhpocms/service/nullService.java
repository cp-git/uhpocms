/**
 * @author  - Code Generator
 * @createdOn -  ${genDate}
 * @Description Entity class for ${Cservice} Service
 * 
 */

package com.cpa.uhpocms.service;

import java.util.List;

import com.cpa.uhpocms.entity.${Cservice};

public interface ${Cservice}Service {

	${Cservice} create${Cservice}(${Cservice} ${service});

	${Cservice} get${Cservice}By${findBy}(String ${findbys});

	List<Object> getAll${Cservice}s();

	${Cservice} update${Cservice}By${findBy}(${Cservice} ${service}, String ${findbys});

	int delete${Cservice}By${findBy}(String ${findbys});

}
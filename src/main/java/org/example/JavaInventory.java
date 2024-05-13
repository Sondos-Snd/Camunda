package org.example;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class JavaInventory implements JavaDelegate {

    private final Logger LOGGER=Logger.getLogger(JavaInventory.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String productCode =(String) delegateExecution.getVariable("productCode");
        LOGGER.info("product is "+ productCode);

        int productCount=0;

        delegateExecution.setVariable("productCount",productCount);

        if(productCount<=0){
            try{
                throw new BpmnError("product_Not_Available","This product is not available");
            } catch(BpmnError e){
                LOGGER.info("exception occured : product count is :"+ productCount);
                delegateExecution.setVariable("errorCode","Product not available");
                delegateExecution.setVariable("errormessage","This product is not available");
                throw e;
            }
        }

    }
}

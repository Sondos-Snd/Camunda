package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;
import java.util.List;

public class IncrementServiceTask  implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Integer> appliedEmployees= new ArrayList<>();

        appliedEmployees.add(1);
        appliedEmployees.add(2);
        appliedEmployees.add(3);

        delegateExecution.setVariable("thelist", appliedEmployees);
        delegateExecution.setVariable("thesize", appliedEmployees.size());
    }
}

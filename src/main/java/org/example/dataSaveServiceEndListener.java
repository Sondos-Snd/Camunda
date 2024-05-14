package org.example;
        import org.camunda.bpm.engine.delegate.DelegateExecution;
        import org.camunda.bpm.engine.delegate.ExecutionListener;

        import java.util.Date;

public class dataSaveServiceEndListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("serviceName", "dataSaveServiceEndListener");
    }
}


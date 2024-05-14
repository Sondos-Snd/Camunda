package org.example;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.community.process_test_coverage.junit5.platform7.ProcessEngineCoverageExtension;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.logging.Logger;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
@ExtendWith(ProcessEngineCoverageExtension.class)
public class ProcessUnitTest {

    private final Logger LOGGER= Logger.getLogger(ProcessUnitTest.class.getName());

    private static final String PROCESS8DEFINITION8KEY= "camunda_junit";

    static {
        LogFactory.useSlf4jLogging();
    }

    @Before
    public void setup(){
        // setup
    }

    public void testParsingAndDeployment(){}
//        @Test
        @Rule
        public ProcessEngineRule processEngineRule = new ProcessEngineRule();

    @Test
    @Deployment(resources = "process.bpmn")
    public void ruleUsageExample(){

        RuntimeService runtimeService = processEngineRule.getRuntimeService();

        ProcessInstance p1=runtimeService.startProcessInstanceByKey("camunda-junit");

        LOGGER.info("process id "+ p1.getProcessInstanceId());

        TaskService taskService = processEngineRule.getTaskService();
        Task task=taskService.createNativeTaskQuery().singleResult();

        assertEquals("watch",task.getId());
        taskService.complete(task.getId());

        assertEquals(0,runtimeService.createExecutionQuery().count());

    }
}

/*
 * Copyright 2023 Conductor authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.netflix.conductor.core.execution.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.netflix.conductor.common.metadata.tasks.TaskDef;
import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import com.netflix.conductor.core.utils.IDGenerator;
import com.netflix.conductor.model.TaskModel;
import com.netflix.conductor.model.WorkflowModel;

public class NoopTaskMapperTest {

    @Test
    public void getMappedTasks() {

        WorkflowTask workflowTask = new WorkflowTask();
        workflowTask.setType(TaskType.TASK_TYPE_NOOP);

        String taskId = new IDGenerator().generate();

        WorkflowDef workflowDef = new WorkflowDef();
        WorkflowModel workflow = new WorkflowModel();
        workflow.setWorkflowDefinition(workflowDef);

        TaskMapperContext taskMapperContext =
                TaskMapperContext.newBuilder()
                        .withWorkflowModel(workflow)
                        .withTaskDefinition(new TaskDef())
                        .withWorkflowTask(workflowTask)
                        .withRetryCount(0)
                        .withTaskId(taskId)
                        .build();

        List<TaskModel> mappedTasks = new NoopTaskMapper().getMappedTasks(taskMapperContext);

        Assert.assertNotNull(mappedTasks);
        Assert.assertEquals(1, mappedTasks.size());
        Assert.assertEquals(TaskType.TASK_TYPE_NOOP, mappedTasks.get(0).getTaskType());
    }
}

/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl.cmd;

import org.camunda.bpm.engine.exception.NullValueException;
import org.camunda.bpm.engine.history.UserOperationLogEntry;
import org.camunda.bpm.engine.impl.persistence.entity.TaskEntity;

/**
 * Command that changes the description of a task.
 */
public class SetTaskDescriptionCmd extends AbstractSetTaskPropertyCmd<String> {

  /**
   * Public Constructor.
   *
   * @param taskId      the id of the task whose description should be changed
   * @param description the new description value to change to
   * @throws NullValueException in case the given taskId or the given description are null
   */
  public SetTaskDescriptionCmd(String taskId, String description) {
    super(taskId, description, true);
  }

  @Override
  protected String getUserOperationLogName() {
    return UserOperationLogEntry.OPERATION_TYPE_SET_DESCRIPTION;
  }

  @Override
  protected void executeSetOperation(TaskEntity task, String value) {
    task.setDescription(value);
  }
}

-- add historic external task log
create table ACT_HI_EXT_TASK_LOG (
    ID_ varchar(64) not null,
    TIMESTAMP_ timestamp not null,
    TASK_ID_ varchar(64) not null,
    RETRIES_ integer,
    TOPIC_NAME_ varchar(255),
    WORKER_ID_ varchar(255),
    PRIORITY_ bigint not null default 0,
    ERROR_MSG_ varchar(4000),
    ERROR_DETAILS_ID_ varchar(64),
    ACT_ID_ varchar(255),
    ACT_INST_ID_ varchar(64),
    EXECUTION_ID_ varchar(64),
    PROCESS_INSTANCE_ID_ varchar(64),
    PROCESS_DEF_ID_ varchar(64),
    PROCESS_DEF_KEY_ varchar(255),
    TENANT_ID_ varchar(64),
    STATE_ integer,
    REV_ integer,
    primary key (ID_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_bin;

create index ACT_HI_EXT_TASK_LOG_PROCINST on ACT_HI_EXT_TASK_LOG(PROCESS_INSTANCE_ID_);
create index ACT_HI_EXT_TASK_LOG_PROCDEF on ACT_HI_EXT_TASK_LOG(PROCESS_DEF_ID_);
create index ACT_HI_EXT_TASK_LOG_PROC_DEF_KEY on ACT_HI_EXT_TASK_LOG(PROCESS_DEF_KEY_);
create index ACT_HI_EXT_TASK_LOG_TENANT_ID on ACT_HI_EXT_TASK_LOG(TENANT_ID_);
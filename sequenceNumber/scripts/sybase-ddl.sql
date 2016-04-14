/**
 * This is Sybase DDL script for Sequence Number Project.
 */
/**
 * This is TABLE Create script for Sequence Number.
 */
IF OBJECT_ID ('dbo.sequences') IS NOT NULL
	DROP TABLE dbo.sequences
GO

CREATE TABLE dbo.sequences
	(
	  sequence_name VARCHAR (50) NOT NULL,
	  nextval   INT NULL,
	  increment  INT NOT NULL,
	 CONSTRAINT pk_sequences PRIMARY KEY (sequence_name) ON 'default'
	)
	LOCK DATAROWS
	ON 'default'
GO

-- Each records in the table is a sequence.
-- you could use table name as the sequence name. 
INSERT INTO sequences (sequence_name, nextval, increment) VALUES ('student', 1, 2)
INSERT INTO sequences (sequence_name, nextval, increment) VALUES ('class', 10, 1)
INSERT INTO sequences (sequence_name, nextval, increment) VALUES ('teacher', 100, 1)
INSERT INTO sequences (sequence_name, nextval, increment) VALUES ('semester', 1000, 1)

/**
 * Stored Procedure Create script for Sequence Number.
 * This stored procedure simulate
 */
IF OBJECT_ID ('dbo.get_next_sequence') IS NOT NULL
	DROP PROCEDURE dbo.get_next_sequence
GO

CREATE PROCEDURE dbo.get_next_sequence(
	@sequence_name	varchar(50)
,	@key_int		int         = NULL output  
, 	@no_of_keys		int 		= 1 
)
AS 
declare
	@error             int
,	@rowcount          int
,   @err_msg         varchar(255)
,   @raiserror_num     int
,   @NOT_EXIST_ERROR   int

SELECT
	@error           = 0
,	@err_msg       = 'Error '
,	@raiserror_num   = 100
,	@sequence_name   = lower(@sequence_name)
,   @NOT_EXIST_ERROR = 101

/* 
 * Request next # of keys for the table
 * Default no_of_keys to 1
 */
begin tran
update
	dbo.sequences
set
	nextval = nextval + increment * @no_of_keys
where
	sequence_name = @sequence_name

select
	@error    = @@error
,	@rowcount = @@rowcount

if (@rowcount=0 or @error!=0) begin -- @sequence_name not found
	select
		@err_msg     = 'ERROR: Sequence not found : ' + @sequence_name
	,	@raiserror_num = @NOT_EXIST_ERROR
	goto ExitOnError
end

select
	@key_int    = nextval
from
	sequences
where
	sequence_name = @sequence_name

select
	@error    = @@error
,	@rowcount = @@rowcount

if (@error=0 and @rowcount!=0) begin
	commit tran
	return(0)
end

ExitOnError:
    if (@@trancount != 0) begin
		rollback tran
    end
    raiserror @raiserror_num @err_msg
    return(-1)
GO

sp_procxmode get_next_sequence, anymode
GO
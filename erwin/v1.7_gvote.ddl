
DROP INDEX XAK1TM_VIDEO_RC ON TM_VIDEO_RC;

DROP INDEX XAK1TT_FORM ON TT_FORM;

DROP INDEX XAK1TT_VOTE ON TT_VOTE;

DROP INDEX XAK2TT_VOTE ON TT_VOTE;

DROP INDEX XAK1TT_GROUP_USER ON TT_GROUP_USER;

DROP INDEX XAK1TM_PLAN_DETAIL ON TM_PLAN_DETAIL;

DROP INDEX XAK1TM_PLAN ON TM_PLAN;

DROP INDEX XAK1TT_GVOTE_RECEIVE ON TT_GVOTE_RECEIVE;

DROP INDEX XAK1TM_USER ON TM_USER;

DROP TABLE TM_VIDEO_RC;

DROP TABLE TM_VIDEO_DESC;

DROP TABLE TT_FORM;

DROP TABLE TT_VOTE;

DROP TABLE TT_VOTE_SUBJECT;

DROP TABLE TT_DEBATE;

DROP TABLE TT_GROUP_USER;

DROP TABLE TT_USER_PLAN;

DROP TABLE TM_PLAN_DETAIL;

DROP TABLE TM_VIDEO;

DROP TABLE TM_PLAN;

DROP TABLE TR_GVOTE_RESULT;

DROP TABLE TT_GVOTE_ITEM;

DROP TABLE TT_GVOTE_RECEIVE;

DROP TABLE TT_GVOTE;

DROP TABLE TM_USER;

CREATE TABLE TM_PLAN
(
	PLAN_ID              INTEGER NOT NULL AUTO_INCREMENT,
	LEVEL                SMALLINT NOT NULL,
	TRAINING_DAY         SMALLINT NOT NULL,
	COST                 VARCHAR(20) NULL,
	VOCATION             boolean NULL,
	DEFAULT_STATUS       SMALLINT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	PRIMARY KEY (PLAN_ID)
);

CREATE UNIQUE INDEX XPKTM_PLAN ON TM_PLAN
(
	PLAN_ID ASC
);

CREATE UNIQUE INDEX XAK1TM_PLAN ON TM_PLAN
(
	LEVEL ASC,
	TRAINING_DAY ASC
);

CREATE TABLE TM_PLAN_DETAIL
(
	PLAN_DETAIL_ID       INTEGER NOT NULL AUTO_INCREMENT,
	PLAN_ID              INTEGER NOT NULL,
	VIDEO_ID             INTEGER NOT NULL,
	REPETITIONS          SMALLINT NOT NULL,
	SETS                 SMALLINT NOT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	PRIMARY KEY (PLAN_DETAIL_ID)
);

CREATE UNIQUE INDEX XPKTM_PLAN_DETAIL ON TM_PLAN_DETAIL
(
	PLAN_DETAIL_ID ASC
);

CREATE UNIQUE INDEX XAK1TM_PLAN_DETAIL ON TM_PLAN_DETAIL
(
	PLAN_ID ASC,
	VIDEO_ID ASC
);

CREATE TABLE TM_USER
(
	USER_ID              INTEGER NOT NULL AUTO_INCREMENT,
	OPEN_ID              VARCHAR(50) NULL,
	AVATAR_URL           VARCHAR(200) NULL,
	NICKNAME             VARCHAR(20) NULL,
	PROVINCE             VARCHAR(20) NULL,
	GENDER               DECIMAL(1) NULL,
	PREFER               SMALLINT NULL,
	VOTE_WEIGHT          SMALLINT NOT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (USER_ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTM_USER ON TM_USER
(
	USER_ID ASC
);

CREATE UNIQUE INDEX XAK1TM_USER ON TM_USER
(
	OPEN_ID ASC
);

CREATE TABLE TM_VIDEO
(
	VIDEO_ID             INTEGER NOT NULL AUTO_INCREMENT,
	CATEGORY             SMALLINT NOT NULL,
	DIFFICULTY           SMALLINT NOT NULL,
	DURATION             INTEGER NULL,
	ORD                  SMALLINT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (VIDEO_ID)
);

CREATE UNIQUE INDEX XPKTM_VIDEO ON TM_VIDEO
(
	VIDEO_ID ASC
);

CREATE TABLE TM_VIDEO_DESC
(
	VIDEO_ID             INTEGER NOT NULL,
	CHN_NAME             VARCHAR(30) NULL,
	ENG_NAME             VARCHAR(30) NULL,
	TRAIN_MUSCLE         VARCHAR(20) NULL,
	START_ACTION         VARCHAR(200) NULL,
	ESSEN_EXERCISE       VARCHAR(200) NULL,
	REMIND               VARCHAR(200) NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (VIDEO_ID)
);

CREATE UNIQUE INDEX XPKTM_VIDEO_DESC ON TM_VIDEO_DESC
(
	VIDEO_ID ASC
);

CREATE TABLE TM_VIDEO_RC
(
	VIDEO_RC_ID          INTEGER NOT NULL AUTO_INCREMENT,
	VIDEO_ID             INTEGER NOT NULL,
	GENDER               SMALLINT NULL,
	VIDEO_URL            VARCHAR(200) NULL,
	THUMBNAIL_URL        VARCHAR(200) NULL,
	AUDIO_URL            VARCHAR(200) NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (VIDEO_RC_ID)
);

CREATE UNIQUE INDEX XPKTM_VIDEO_RC ON TM_VIDEO_RC
(
	VIDEO_RC_ID ASC
);

CREATE UNIQUE INDEX XAK1TM_VIDEO_RC ON TM_VIDEO_RC
(
	GENDER ASC,
	VIDEO_ID ASC
);

CREATE TABLE TR_GVOTE_RESULT
(
	GVOTE_ITEM_ID        INTEGER NOT NULL,
	USER_ID              INTEGER NOT NULL,
	PRIMARY KEY (GVOTE_ITEM_ID,USER_ID)
);

CREATE UNIQUE INDEX XPKTR_GVOTE_RESULT ON TR_GVOTE_RESULT
(
	GVOTE_ITEM_ID ASC,
	USER_ID ASC
);

CREATE TABLE TT_DEBATE
(
	DEBATE_ID            INTEGER NOT NULL AUTO_INCREMENT,
	TITLE                VARCHAR(50) NULL,
	CONTENT              VARCHAR(100) NULL,
	GROUP_ID             VARCHAR(30) NULL,
	STATUS               SMALLINT NOT NULL,
	REVERSE              VARCHAR(50) NULL,
	OBVERSE              VARCHAR(50) NULL,
	TOTAL_COUNT          INTEGER NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (DEBATE_ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTT_DEBATE ON TT_DEBATE
(
	DEBATE_ID ASC
);

CREATE TABLE TT_FORM
(
	ID                   INTEGER NOT NULL AUTO_INCREMENT,
	USER_ID              INTEGER NULL,
	FORM_ID              VARCHAR(50) NOT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	PRIMARY KEY (ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTT_FORM ON TT_FORM
(
	ID ASC
);

CREATE UNIQUE INDEX XAK1TT_FORM ON TT_FORM
(
	FORM_ID ASC
);

CREATE TABLE TT_GROUP_USER
(
	GROUP_USER_ID        INTEGER NOT NULL AUTO_INCREMENT,
	GROUP_ID             VARCHAR(30) NULL,
	OPEN_ID              VARCHAR(50) NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	PRIMARY KEY (GROUP_USER_ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTT_GROUP_USER ON TT_GROUP_USER
(
	GROUP_USER_ID ASC
);

CREATE UNIQUE INDEX XAK1TT_GROUP_USER ON TT_GROUP_USER
(
	GROUP_ID ASC,
	OPEN_ID ASC
);

CREATE TABLE TT_GVOTE
(
	GVOTE_ID             INTEGER NOT NULL AUTO_INCREMENT,
	TITLE                VARCHAR(50) NOT NULL,
	DESCRIPTION          VARCHAR(100) NULL,
	MULTI                boolean NOT NULL,
	ANONYMOUS            boolean NOT NULL,
	END_TIME             DATETIME NULL,
	MIN_COUNT            SMALLINT NULL,
	MAX_COUNT            SMALLINT NULL,
	STATUS               SMALLINT NULL,
	OWNER                INTEGER NOT NULL,
	GROUP_ID             VARCHAR(30) NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (GVOTE_ID)
);

CREATE UNIQUE INDEX XPKTT_GVOTE ON TT_GVOTE
(
	GVOTE_ID ASC
);

CREATE TABLE TT_GVOTE_ITEM
(
	GVOTE_ITEM_ID        INTEGER NOT NULL AUTO_INCREMENT,
	GVOTE_ID             INTEGER NOT NULL,
	CONTENT              VARCHAR(30) NOT NULL,
	PRIMARY KEY (GVOTE_ITEM_ID)
);

CREATE UNIQUE INDEX XPKTT_GVOTE_ITEM ON TT_GVOTE_ITEM
(
	GVOTE_ITEM_ID ASC
);

CREATE TABLE TT_GVOTE_RECEIVE
(
	RECEIVE_ID           INTEGER NOT NULL AUTO_INCREMENT,
	USER_ID              INTEGER NOT NULL,
	GVOTE_ID             INTEGER NOT NULL,
	DELETED              boolean NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (RECEIVE_ID)
);

CREATE UNIQUE INDEX XPKTT_GVOTE_RECEIVE ON TT_GVOTE_RECEIVE
(
	RECEIVE_ID ASC
);

CREATE UNIQUE INDEX XAK1TT_GVOTE_RECEIVE ON TT_GVOTE_RECEIVE
(
	USER_ID ASC,
	GVOTE_ID ASC
);

CREATE TABLE TT_USER_PLAN
(
	USER_PLAN_ID         INTEGER NOT NULL AUTO_INCREMENT,
	USER_ID              INTEGER NOT NULL,
	PLAN_ID              INTEGER NOT NULL,
	STATUS               SMALLINT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (USER_PLAN_ID)
);

CREATE UNIQUE INDEX XPKTT_USER_PLAN ON TT_USER_PLAN
(
	USER_PLAN_ID ASC
);

CREATE TABLE TT_VOTE
(
	VOTE_ID              INTEGER NOT NULL AUTO_INCREMENT,
	VALUE                SMALLINT NOT NULL,
	USER_ID              INTEGER NOT NULL,
	DEBATE_ID            INTEGER NULL,
	SUBJECT_ID           INTEGER NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	PRIMARY KEY (VOTE_ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTT_VOTE ON TT_VOTE
(
	VOTE_ID ASC
);

CREATE UNIQUE INDEX XAK1TT_VOTE ON TT_VOTE
(
	USER_ID ASC,
	DEBATE_ID ASC
);

CREATE UNIQUE INDEX XAK2TT_VOTE ON TT_VOTE
(
	USER_ID ASC,
	SUBJECT_ID ASC
);

CREATE TABLE TT_VOTE_SUBJECT
(
	SUBJECT_ID           INTEGER NOT NULL AUTO_INCREMENT,
	TITLE                VARCHAR(50) NOT NULL,
	CONTENT              VARCHAR(100) NOT NULL,
	SIDE1                VARCHAR(50) NULL,
	SIDE2                VARCHAR(50) NULL,
	SIDE3                VARCHAR(50) NULL,
	SIDE4                VARCHAR(50) NULL,
	ANONYMOUS            TINYINT(1) NULL,
	GROUP_ID             VARCHAR(30) NULL,
	TOTAL_NUM            INTEGER NOT NULL,
	UNIT_PRICE           INTEGER NOT NULL,
	STATUS               SMALLINT NOT NULL,
	FUND_POOL            INTEGER NOT NULL,
	CREATE_BY            INTEGER NOT NULL,
	CREATE_ON            DATETIME NOT NULL,
	UPDATE_BY            INTEGER NULL,
	UPDATE_ON            DATETIME NULL,
	PRIMARY KEY (SUBJECT_ID)
)
 AUTO_INCREMENT = 1;

CREATE UNIQUE INDEX XPKTT_VOTE_SUBJECT ON TT_VOTE_SUBJECT
(
	SUBJECT_ID ASC
);

ALTER TABLE TM_PLAN_DETAIL
ADD FOREIGN KEY R_11 (PLAN_ID) REFERENCES TM_PLAN (PLAN_ID);

ALTER TABLE TM_PLAN_DETAIL
ADD FOREIGN KEY R_12 (VIDEO_ID) REFERENCES TM_VIDEO (VIDEO_ID);

ALTER TABLE TM_VIDEO_DESC
ADD FOREIGN KEY R_2 (VIDEO_ID) REFERENCES TM_VIDEO (VIDEO_ID);

ALTER TABLE TM_VIDEO_RC
ADD FOREIGN KEY R_1 (VIDEO_ID) REFERENCES TM_VIDEO (VIDEO_ID);

ALTER TABLE TR_GVOTE_RESULT
ADD FOREIGN KEY R_14 (USER_ID) REFERENCES TM_USER (USER_ID);

ALTER TABLE TR_GVOTE_RESULT
ADD FOREIGN KEY R_16 (GVOTE_ITEM_ID) REFERENCES TT_GVOTE_ITEM (GVOTE_ITEM_ID);

ALTER TABLE TT_GVOTE
ADD FOREIGN KEY R_19 (OWNER) REFERENCES TM_USER (USER_ID);

ALTER TABLE TT_GVOTE_ITEM
ADD FOREIGN KEY R_15 (GVOTE_ID) REFERENCES TT_GVOTE (GVOTE_ID);

ALTER TABLE TT_GVOTE_RECEIVE
ADD FOREIGN KEY R_17 (USER_ID) REFERENCES TM_USER (USER_ID);

ALTER TABLE TT_GVOTE_RECEIVE
ADD FOREIGN KEY R_18 (GVOTE_ID) REFERENCES TT_GVOTE (GVOTE_ID);

ALTER TABLE TT_USER_PLAN
ADD FOREIGN KEY R_7 (USER_ID) REFERENCES TM_USER (USER_ID);

ALTER TABLE TT_USER_PLAN
ADD FOREIGN KEY R_8 (PLAN_ID) REFERENCES TM_PLAN (PLAN_ID);

ALTER TABLE TT_VOTE
ADD FOREIGN KEY R_5 (DEBATE_ID) REFERENCES TT_DEBATE (DEBATE_ID);

ALTER TABLE TT_VOTE
ADD FOREIGN KEY R_6 (SUBJECT_ID) REFERENCES TT_VOTE_SUBJECT (SUBJECT_ID);

alter table tr_gvote_result add column CREATE_ON datetime NOT NULL DEFAULT now();
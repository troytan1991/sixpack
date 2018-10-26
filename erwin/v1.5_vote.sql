INSERT INTO `sixpack`.`tt_vote_subject`(`TITLE`,`CONTENT`,`SIDE1`,`SIDE2`,`SIDE3`,`SIDE4`,`ANONYMOUS`,`GROUP_ID`,`TOTAL_NUM`,`UNIT_PRICE`,`STATUS`,FUND_POOL,`CREATE_BY`,`CREATE_ON`)
VALUES('IT辩论赛','项目投资大会','车联网项目','电动车项目','人工智能实验室','BA能力培训计划',false,null,50,2000,1,100000, 1, now());
insert into sixpack.tt_debate(title,content, group_id, status, reverse, obverse,create_by, create_on,total_count)
values('SGM奇葩说','SGM未来发展中，哪类人员更重要？',null, 1, 'BA人员更重要','开发人员更重要',1, now(),30);
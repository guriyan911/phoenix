
/* Drop Tables */

DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS project_month;
DROP TABLE IF EXISTS project_problem;
DROP TABLE IF EXISTS work_report;




/* Create Tables */

CREATE TABLE project
(
	project_id varchar(5) NOT NULL,
	-- プロジェクト状態
	project_status varchar(3),
	PRIMARY KEY (project_id)
) WITHOUT OIDS;


CREATE TABLE project_month
(
	id serial NOT NULL,
	project_id varchar(5) NOT NULL,
  ym varchar(6) NOT NULL,
  project_name varchar(100),
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE project_problem
(
	id serial NOT NULL,
	-- ジャンルを表す記号を持つ
	project_id varchar(5) NOT NULL,
	ym varchar(6) NOT NULL,
	-- 問題に対する解答を設定する
	problem_no integer DEFAULT 0,
	problem varchar(200),
	answer varchar(200),
	project_month_id integer,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE work_report
(
	id serial NOT NULL,
	-- 管理者が開設した部屋の名前
	project_id varchar(30) NOT NULL,
	-- 0：開設中　1：ゲーム終了
	ym varchar(6) NOT NULL,
	staff_id varchar(8) NOT NULL,
	report varchar(100),
	project_month_id integer,
	PRIMARY KEY (id)
) WITHOUT OIDS;


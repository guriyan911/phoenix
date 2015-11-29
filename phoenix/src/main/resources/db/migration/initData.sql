
INSERT INTO project (project_id, project_status) VALUES ('1', '100');
INSERT INTO project (project_id, project_status) VALUES ('2', '200');
INSERT INTO project (project_id, project_status) VALUES ('3', '300');

INSERT INTO project_month (id, project_id, ym, project_name) VALUES (1, '1', '201511', '案件');
INSERT INTO project_month (id, project_id, ym, project_name) VALUES (2, '1', '201511', 'ANKEN B');
INSERT INTO project_month (id, project_id, ym, project_name) VALUES (3, '2', '201511', 'ANKEN C');

SELECT pg_catalog.setval('project_month_id_seq', 3, true);



INSERT INTO project_problem (id, project_id, ym, problem_no, problem, answer, project_month_id) VALUES (1, '1', '201511', 1, 'PROBLEM1', 'ANSWER1', 1);
INSERT INTO project_problem (id, project_id, ym, problem_no, problem, answer, project_month_id) VALUES (2, '2', '201511', 1, 'P2', 'A2', 2);


SELECT pg_catalog.setval('project_problem_id_seq', 3, true);


INSERT INTO work_report (id, project_id, ym, staff_id, report, project_month_id) VALUES (1, '1', '201511', '100', 'REPORT1', 1);
INSERT INTO work_report (id, project_id, ym, staff_id, report, project_month_id) VALUES (2, '2', '201511', '200', 'REPORT2', 2);


SELECT pg_catalog.setval('work_report_id_seq', 3, true);


